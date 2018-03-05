package com.vcg.chat.server;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * created by wuyu on 2018/2/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class VcChatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VcChatServerApplication.class, args);
    }

}
