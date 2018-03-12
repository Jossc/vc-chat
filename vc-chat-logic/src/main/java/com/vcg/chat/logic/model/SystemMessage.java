package com.vcg.chat.logic.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * Created on 2018/3/12 12:28.
 * <p>
 * id 	BIGINT 	19
 * sendId 	VARCHAR 	64 	发件人id
 * recId 	VARCHAR 	64 	收件人id
 * type 	INTEGER 	10 	0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动
 * createdTime 	TIMESTAMP 	19 	创建时间
 * message 	LONGVARCHAR 	65535 	消息内容
 */
@Data
@Accessors(chain = true)
public class SystemMessage implements Serializable {
    private static final long serialVersionUID = 5389075161802625014L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "发件人id")
    private String sendId;

    @ApiModelProperty(value = "收件人id")
    private String recId;

    @ApiModelProperty(value = "0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动 ")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "消息内容")
    private String message;

}
