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
 * userId 	VARCHAR 	64 	用户id
 * systemMessageId 	BIGINT 	19 	系统消息id
 * createdTime 	TIMESTAMP 	19 	创建时间
 * uniId 	VARCHAR 	32 	user_id与system_message_id 加密的MD5 唯一键
 */
@Data
@Accessors(chain = true)
public class UserSystemMessage implements Serializable {
    private static final long serialVersionUID = 4255076984708447420L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "系统消息id")
    private Long systemMessageId;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "user_id与system_message_id 加密的MD5 唯一键")
    private String uniId;

}
