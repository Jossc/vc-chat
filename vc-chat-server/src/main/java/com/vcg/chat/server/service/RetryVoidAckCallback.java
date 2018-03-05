package com.vcg.chat.server.service;

import com.corundumstudio.socketio.VoidAckCallback;
import com.vcg.chat.api.model.Request;
import com.vcg.chat.server.ampq.QueueName;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * 消息重试回调
 * <p>
 * created by wuyu on 2018/3/2
 */
public class RetryVoidAckCallback extends VoidAckCallback {


    private AmqpTemplate amqpTemplate;

    private Request request;

    public RetryVoidAckCallback(AmqpTemplate amqpTemplate, Request request) {
        this.amqpTemplate = amqpTemplate;
        this.request = request;
    }

    public RetryVoidAckCallback(int timeout, AmqpTemplate amqpTemplate, Request request) {
        super(timeout);
        this.amqpTemplate = amqpTemplate;
        this.request = request;
    }

    @Override
    protected void onSuccess() {

    }

    @Override
    public void onTimeout() {
        amqpTemplate.convertAndSend(QueueName.CHAT_RETRY_QUEUE_NAME, this.request);
    }
}
