package com.vcg.chat.server.ampq;

import com.vcg.chat.api.model.Request;
import com.vcg.chat.server.service.PushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * 对发送失败的消息进行重试
 * <p>
 * created by wuyu on 2018/3/3
 */
@RabbitListener(queues = QueueName.CHAT_RETRY_QUEUE_NAME, containerFactory = "rabbitListenerContainerFactory")
@Slf4j
public class RequestRetryListener {

    @Autowired
    private PushService pushService;


    @RabbitHandler
    public void process(@Payload Request request) {
        pushService.singlePush(request);
    }
}
