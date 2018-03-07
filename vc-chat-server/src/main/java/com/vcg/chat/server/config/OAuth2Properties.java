package com.vcg.chat.server.config;

import lombok.Data;

import java.util.Set;

/**
 * created by wuyu on 2018/3/7
 */
@Data
public class OAuth2Properties {

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
