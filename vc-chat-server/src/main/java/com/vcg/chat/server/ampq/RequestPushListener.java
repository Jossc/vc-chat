package com.vcg.chat.server.ampq;

import com.corundumstudio.socketio.SocketIOClient;
import com.vcg.chat.api.model.Request;
import com.vcg.chat.server.router.LocalRouter;
import com.vcg.chat.server.router.LocalRouterManager;
import com.vcg.chat.server.router.RemoteRouterManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Set;

/**
 * 基于消息广播推送
 * <p>
 * created by wuyu on 2018/3/3
 */
@RabbitListener(
        bindings =
        @QueueBinding(
                value = @Queue(value = QueueName.CHAT_BROADCAST_QUEUE_NAME),
                exchange = @Exchange(value = ExchangeTypes.FANOUT, type = ExchangeTypes.FANOUT)
        ),
        containerFactory = "rabbitListenerContainerFactory")
@Slf4j
public class RequestPushListener {

    @Autowired
    private LocalRouterManager localRouterManager;

    @Autowired
    private RemoteRouterManager remoteRouterManager;

    @RabbitHandler
    public void process(@Payload Request request) {
        localPush(request);
    }


    /**
     * 本机推送
     *
     * @param request
     */
    public void localPush(Request request) {
        if (request.getUserId() == null) return;
        Set<LocalRouter> routers = localRouterManager.lookupAll(request.getUserId());
        for (LocalRouter router : routers) {
            SocketIOClient client = router.getSocketIOClient();
            if (client.isChannelOpen()) {
                client.sendEvent(request.getEventName(), request.getData());
            } else {
                remoteRouterManager.unRegister(request.getUserId(), client.getSessionId().toString());
                localRouterManager.unRegister(request.getUserId(), client.getSessionId().toString());
            }
        }
    }

}
