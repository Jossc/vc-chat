package com.vcg.chat.server.ampq;

/**
 * created by wuyu on 2018/3/3
 */
public interface QueueName {

    /**
     * 重试队列名称
     */
    String CHAT_RETRY_QUEUE_NAME = "chatRetryQueue";


    String CHAT_BROADCAST_QUEUE_NAME = "chatBroadcastQueue";


}
