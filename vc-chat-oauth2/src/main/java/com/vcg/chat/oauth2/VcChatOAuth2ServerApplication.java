package com.vcg.chat.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

@SpringBootApplication
@EnableRedisHttpSession
@EnableTransactionManagement
@EnableWebSecurity
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableJpaRepositories
public class VcChatOAuth2ServerApplication {

    public static void main(String[] args) throws IOException {
        //pid
        try (FileWriter writer = new FileWriter(new File("VcChatOAuth2ServerApplication.pid"))) {
            String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            writer.write(name);
        }
        SpringApplication.run(VcChatOAuth2ServerApplication.class, args);
    }

}
