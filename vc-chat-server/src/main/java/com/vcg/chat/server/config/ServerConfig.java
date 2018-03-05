package com.vcg.chat.server.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.vcg.chat.server.ampq.RequestRetryListener;
import com.vcg.chat.server.filter.AuthFilter;
import com.vcg.chat.server.filter.Filter;
import com.vcg.chat.server.listener.SessionListener;
import com.vcg.chat.server.router.LocalRouterManager;
import com.vcg.chat.server.router.RemoteRouterManager;
import com.vcg.chat.server.service.HttpPushService;
import com.vcg.chat.server.service.PushService;
import com.vcg.chat.server.store.RedisStore;
import com.vcg.chat.server.store.Store;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * created by wuyu on 2018/2/26
 */
@Configuration
@EnableConfigurationProperties(ChatProperties.class)
public class ServerConfig {

    @Autowired
    private ChatProperties chatProperties;

    /**
     * 远程路由表存储
     *
     * @param stringRedisTemplate
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public Store store(@Autowired StringRedisTemplate stringRedisTemplate) {
        return new RedisStore(stringRedisTemplate);
    }

    /**
     * 本地路由表
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public LocalRouterManager localRouterManager() {
        return new LocalRouterManager();
    }

    /**
     * 远程路由表
     *
     * @param store
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public RemoteRouterManager remoteRouterManager(@Autowired Store store) {
        return new RemoteRouterManager(store);
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }

    /**
     * session监听器
     * @param localRouterManager 本地路由
     * @param remoteRouterManager 远程路由
     * @param registration 本机在服务中心注册的信息
     * @param filters 过滤器
     * @return
     */
    @Bean
    public SessionListener sessionListener(@Autowired LocalRouterManager localRouterManager,
                                           @Autowired RemoteRouterManager remoteRouterManager,
                                           @Autowired Registration registration,
                                           @Autowired List<Filter> filters) {

        SessionListener sessionListener = new SessionListener(
                registration,
                localRouterManager,
                remoteRouterManager
        );
        sessionListener.addFilters(filters);
        return sessionListener;
    }

    /**
     * 初始化Socket-io see https://github.com/mrniko/netty-socketio/wiki/Configuration-details
     *
     * @return
     */
    @Bean
    public SocketIOServer socketIOServer(@Autowired SessionListener sessionListener) {
        com.corundumstudio.socketio.Configuration configuration = chatProperties.getConfiguration();
        SocketConfig socketConfig = chatProperties.getSocketConfig();
        configuration.setSocketConfig(socketConfig);
        SocketIOServer socketIOServer = new SocketIOServer(configuration);
        socketIOServer.addConnectListener(sessionListener);
        socketIOServer.addDisconnectListener(sessionListener);
        return socketIOServer;
    }


    @Bean
    @ConditionalOnMissingBean
    public RequestRetryListener requestRetryListener() {
        return new RequestRetryListener();
    }


    /**
     * 推送服务
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public PushService pushService() {
        return new HttpPushService();
    }

    /**
     * http请求工具
     *
     * @return
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .build();
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(manager)
                .setMaxConnPerRoute(500)
                .setMaxConnTotal(500)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .setDefaultRequestConfig(requestConfig)
                .build();
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }


    /**
     * http  异步请求工具
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public AsyncRestTemplate asyncRestTemplate() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .build();
        CloseableHttpAsyncClient closeableHttpAsyncClient = HttpAsyncClientBuilder.create()
                .setMaxConnPerRoute(500)
                .setMaxConnTotal(500)
                .setDefaultRequestConfig(requestConfig)
                .build();
        return new AsyncRestTemplate(new HttpComponentsAsyncClientHttpRequestFactory(closeableHttpAsyncClient));
    }

    /**
     * 等待Spring初始化完成后启动 socket-io 服务
     *
     * @param socketIOServer
     * @return
     */
    @Bean
    public ApplicationListener<ContextRefreshedEvent> startListener(@Autowired SocketIOServer socketIOServer) {
        return event -> socketIOServer.start();
    }


    @Bean
    public ApplicationListener<ContextClosedEvent> stopListener(@Autowired SocketIOServer socketIOServer) {
        return event -> socketIOServer.stop();
    }

}
