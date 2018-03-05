package com.vcg.chat.server.router;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public final class ClientLocation {

    /**
     * 连接所在的机器IP
     */
    private String host;

    /**
     * 连接所在的机器端口
     */
    private int port;

    /**
     * 客户端系统类型
     */
    private String osName;

    /**
     * 客户端版本
     */
    private String clientVersion;

    /**
     * 客户端设备ID
     */
    private String deviceId;

    /**
     * 链接ID
     */
    private String sessionId;

    /**
     * 客户端类型
     */
    private String clientType;

}
