package com.vcg.chat.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * created by wuyu on 2018/3/7
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.vcg.chat.api")
public class VcChatSampleApplication {
    public static void main(String[] args) throws IOException {
        //pid
        try (FileWriter writer = new FileWriter(new File("VcChatSampleApplication.pid"))) {
            String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            writer.write(name);
        }
        SpringApplication.run(VcChatSampleApplication.class, args);
    }

}
