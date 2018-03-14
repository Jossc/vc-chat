package com.vcg.chat.sample;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;

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

    @Bean
    public CloseableHttpClient httpClient(){
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .build();
        return HttpClientBuilder.create()
                .setMaxConnPerRoute(500)
                .setMaxConnTotal(500)
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

}
