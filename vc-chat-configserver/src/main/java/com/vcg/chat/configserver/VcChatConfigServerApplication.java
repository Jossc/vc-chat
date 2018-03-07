package com.vcg.chat.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by wuyu on 2016/7/25.
 */
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class VcChatConfigServerApplication {

    public static void main(String[] args) throws IOException {
        //pid
        String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        try(FileWriter writer = new FileWriter(new File("VcChatConfigServerApplication.pid"))) {
            writer.write(name);
        }
        SpringApplication.run(VcChatConfigServerApplication.class,args);
    }
}
