package com.vcg.chat.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

/**
 * created by wuyu on 2018/2/27
 */
@Data
@Accessors(chain = true)
@ToString
public class Request {


    /**
     * 唯一消息id
     */
    @NotNull
    @ApiModelProperty(value = "唯一id")
    private String id = UUID.randomUUID().toString();

    /**
     * 用户id
     */
    @NotNull
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * socketio 创建的 session id
     */
    @ApiModelProperty(value = "socketio建立的连接id")
    private String sessionId;

    /**
     * 消息发送失败已经重试的次数
     */
    @NotNull
    @ApiModelProperty(value = "已经重试的次数")
    private Integer retryCount = 0;

    /**
     * 客户端类型
     */
    @ApiModelProperty(value = "客户端类型")
    private String clientType;

    /**
     * event name 事件名
     */
    @NotNull
    @ApiModelProperty(value = "事件名")
    private String eventName = "message";

    /**
     * 消息内容
     */
    @NotNull
    @ApiModelProperty(value = "推送的数据")
    private Object data;

    /**
     * 时间戳
     */
    @NotNull
    @ApiModelProperty(value = "时间戳")
    private Date createdTime = new Date();


}
