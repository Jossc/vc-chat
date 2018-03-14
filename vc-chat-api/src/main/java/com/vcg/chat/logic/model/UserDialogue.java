package com.vcg.chat.logic.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * Created on 2018/3/05 12:31.
 * <p>
 * id 	BIGINT 	20
 * userId 	VARCHAR 	64
 * toUserId 	VARCHAR 	64 	该字段为 冗余字段，用于记录对方id，方便用于查找头像
 * parentId 	BIGINT 	20 	父对话id
 * parentMake 	INTEGER 	10 	父字段标识位 0 不是 1 是
 * createdTime 	TIMESTAMP 	19
 * updatedTime 	TIMESTAMP 	19 	对话更新时间,会随新来的消息进行时间更新
 * unreadTotal 	INTEGER 	10 	未读消息数
 * ordered 	BIGINT 	20 	排序字段
 * push 	INTEGER 	10 	0.正常全部接收 1.只接收不弹出 2.不接收不弹出
 * uniId 	VARCHAR 	32 	使用双方id md5 加密 生成唯一id
 * type 	INTEGER 	10 	0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动
 * lastMessage 	LONGVARCHAR 	65535 	最后一条消息
 */
@Data
@Accessors(chain = true)
public class UserDialogue implements Serializable {

    private static final long serialVersionUID = 7767598562320638669L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "userId")
    private String userId;

    @ApiModelProperty(value = "该字段为 冗余字段，用于记录对方id，方便用于查找头像")
    private String toUserId;

    @ApiModelProperty(value = "父对话id")
    private Long parentId;

    @ApiModelProperty(value = "父字段标识位 0 不是 1 是")
    private Integer parentMake;

    @ApiModelProperty(value = "createdTime")
    private Date createdTime;

    @ApiModelProperty(value = "对话更新时间,会随新来的消息进行时间更新")
    private Date updatedTime;

    @ApiModelProperty(value = "未读消息数")
    private Integer unreadTotal;

    @ApiModelProperty(value = "排序字段")
    private Long ordered;

    @ApiModelProperty(value = "0.正常全部接收 1.只接收不弹出 2.不接收不弹出")
    private Integer push;

    @ApiModelProperty(value = "使用双方id md5 加密 生成唯一id")
    private String uniId;

    @ApiModelProperty(value = "0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动 ")
    private Integer type;

    @ApiModelProperty(value = "最后一条消息内容")
    private String lastMessage;

    @ApiModelProperty(value = "最后一条消息")
    private PriMessage priMessage;

}
