package com.vcg.chat.server.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.Set;

/**
 * socketio 配置类
 * created by wuyu on 2018/2/26
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "chat")
public class ChatProperties {

    @NestedConfigurationProperty
    private Configuration configuration;

    @NestedConfigurationProperty
    private SocketConfig socketConfig;

    /**
     * 最大消息重试次数
     */
    private Integer maxRetryCount = 5;

    @NestedConfigurationProperty
    private OAuth2 oauth2;

    @Data
    public static class OAuth2 {
        /**
         * 获取用户信息url
         */
        private String userInfoUrl;

        /**
         * app id
         */
        private String clientId;

        private String clientSecret;

        /**
         * 权限范围
         */
        private Set<String> scope;

    }


}
