package com.vcg.chat.server.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.vcg.chat.api.model.Request;
import com.vcg.chat.server.ampq.QueueName;
import com.vcg.chat.server.config.ChatProperties;
import com.vcg.chat.server.router.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.http.*;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

import java.net.URI;

/**
 * created by wuyu on 2018/3/1
 */
@Slf4j
@EnableConfigurationProperties(ChatProperties.class)
public class HttpPushService implements PushService {

    @Autowired
    private LocalRouterManager localRouterManager;

    @Autowired
    private RemoteRouterManager remoteRouterManager;

    @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private ChatProperties chatProperties;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 单连接推送
     *
     * @param request
     */
    public void singlePush(Request request) {
        if (request.getSessionId() == null) {
            log.warn("{} SessionId can not be empty!", request);
            return;
        }
        RemoteRouter remoteRouter = remoteRouterManager.lookup(request.getUserId(), request.getSessionId());
        push(remoteRouter, request);
    }

    /**
     * 多连接推送 一个用户可能连接到不同的机器上. 该方法 主要根据用户id 查询相关sessionId 进行转发调用
     *
     * @param request
     */
    public void multiPush(Request request) {
        remoteRouterManager.lookupAll(request.getUserId())
                .parallelStream()
                .forEach(r -> push(r, request));
    }


    protected void push(RemoteRouter remoteRouter, Request request) {
        if (remoteRouter == null || request.getUserId() == null || request.getData() == null) {
            return;
        }
        Request requestCopy = new Request()
                .setUserId(request.getUserId())
                .setSessionId(remoteRouter.getClientLocation().getSessionId())
                .setClientType(request.getClientType())
                .setRetryCount(request.getRetryCount() == null ? 0 : request.getRetryCount() + 1)
                .setData(request.getData())
                .setId(request.getId())
                .setEventName(request.getEventName());

        ClientLocation clientLocation = remoteRouter.getClientLocation();
        String remoteAddress = clientLocation.getHost() + ":" + clientLocation.getPort();
        String localAddress = registration.getHost() + ":" + registration.getPort();
        //如果是存在 直接本机推送
        if (remoteAddress.equalsIgnoreCase(localAddress)) {
            localPush(requestCopy);
        } else {
            //调用远程接口进行推送
            remotePush(remoteAddress, requestCopy);
        }
    }

    /**
     * 本机推送
     *
     * @param request
     */
    public void localPush(Request request) {
        if (request.getSessionId() == null) return;
        LocalRouter router = localRouterManager.lookup(request.getUserId(), request.getSessionId());
        //如果本地路由查不到,将删除远程路由
        if (router == null) {
            remoteRouterManager.unRegister(request.getUserId(), request.getSessionId());
            return;
        }

        SocketIOClient client = router.getSocketIOClient();
        if (client.isChannelOpen()) {
            client.sendEvent(request.getEventName(), new RetryVoidAckCallback(this.amqpTemplate, request), request.getData());
        } else {
            localRouterManager.unRegister(request.getUserId(), request.getSessionId());
        }
    }

    /**
     * 远程推送
     *
     * @param remoteAddress 远程机器地址
     * @param request
     */
    protected void remotePush(final String remoteAddress, Request request) {
        final Integer retryCount = request.getRetryCount() == null ? 0 : request.getRetryCount();
        //检查最大重试次数,如果超过直接丢弃
        if (checkRetries(retryCount)) {
            boolean isClusterHost = isClusterHost(remoteAddress);
            //如果不是集群里的机器,将删除远程这个远程注册表
            if (!isClusterHost) {
                remoteRouterManager.unRegister(request.getUserId(), request.getSessionId());
            }
            log.warn("Exceed the maximum number of retries.{}", request);
        }

        String scheme = "http://";
        if (registration.isSecure()) {
            scheme = "https://";
        }
        String url = scheme + remoteAddress + "/api/push/singlePush";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Request> requestEntity = new RequestEntity<>(request, httpHeaders, HttpMethod.POST, URI.create(url));


        asyncRestTemplate.postForEntity(url, requestEntity, Void.class)
                .addCallback(new ListenableFutureCallback<ResponseEntity<Void>>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        log.warn("push error " + request.toString(), throwable);
                        final Request requestCopy = new Request()
                                .setId(request.getId())
                                .setCreatedTime(request.getCreatedTime())
                                .setData(request.getData())
                                .setClientType(request.getClientType())
                                .setSessionId(request.getSessionId())
                                .setRetryCount(retryCount)
                                .setUserId(request.getUserId());
                        amqpTemplate.convertAndSend(
                                ExchangeTypes.DIRECT,
                                QueueName.CHAT_RETRY_QUEUE_NAME,
                                requestCopy,
                                message -> {
                                    //使用延迟队列,防止短暂的网络抖动导致,retryCount 快速增大丢弃消息
                                    MessageProperties messageProperties = message.getMessageProperties();
                                    messageProperties.setDelay(retryCount * 1000);
                                    return message;
                                }
                        );
                    }

                    @Override
                    public void onSuccess(ResponseEntity<Void> voidResponseEntity) {
                        if (log.isDebugEnabled()) {
                            log.debug("push to " + url + " success");
                        }
                    }
                });
    }

    /**
     * 检查最大重试次数
     *
     * @param retryCount 已经重试的次数
     * @return
     */
    public boolean checkRetries(Integer retryCount) {
        return (chatProperties.getMaxRetryCount() - retryCount) < 0;
    }

    /**
     * 检查远程地址是否归属于本集群
     *
     * @param remoteAddress 远程地址
     * @return
     */
    public boolean isClusterHost(String remoteAddress) {
        return discoveryClient.getInstances(applicationName)
                .stream()
                .anyMatch(serviceInstance -> {
                    String host = serviceInstance.getHost();
                    int port = serviceInstance.getPort();
                    return (host + ":" + port).equalsIgnoreCase(remoteAddress);
                });

    }
}
