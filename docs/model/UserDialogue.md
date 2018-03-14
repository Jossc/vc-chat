## user_dialogue
---
### Properties
Number|Name|Type|Length|Digit|NotNull|Default|Remark
  ---|---|---|---|---|---|---|---
1|	id|	Long|	20|	0|	Y|	null|	   
2|	user_id|	String|	64|	0|	Y|	null|	   
3|	to_user_id|	String|	64|	0|	Y|	null|	该字段为 冗余字段，用于记录对方id，方便用于查找头像   
4|	parent_id|	Long|	20|	0|	Y|	0|	父对话id   
5|	parent_make|	Integer|	10|	0|	Y|	0|	父字段标识位 0 不是 1 是   
6|	created_time|	Date|	19|	0|	Y|	null|	   
7|	updated_time|	Date|	19|	0|	Y|	CURRENT_TIMESTAMP|	对话更新时间,会随新来的消息进行时间更新   
8|	unread_total|	Integer|	10|	0|	Y|	0|	未读消息数   
9|	ordered|	Long|	20|	0|	Y|	0|	排序字段   
10|	last_message|	String|	65535|	0|	N|	null|	最后一条消息   
11|	push|	Integer|	10|	0|	Y|	0|	0.正常全部接收 1.只接收不弹出 2.不接收不弹出   
12|	uni_id|	String|	32|	0|	Y|	null|	使用双方id md5 加密 生成唯一id   
13|	type|	Integer|	10|	0|	Y|	0|	0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动    


### sql
```sql
CREATE TABLE IF NOT EXISTS `user_dialogue` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) NOT NULL,
  `to_user_id` varchar(64) NOT NULL COMMENT '该字段为 冗余字段，用于记录对方id，方便用于查找头像',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父对话id',
  `parent_make` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '父字段标识位 0 不是 1 是',
  `created_time` datetime NOT NULL,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '对话更新时间,会随新来的消息进行时间更新',
  `unread_total` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '未读消息数',
  `ordered` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `last_message` text COMMENT '最后一条消息',
  `push` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '0.正常全部接收 1.只接收不弹出 2.不接收不弹出',
  `uni_id` varchar(32) NOT NULL COMMENT '使用双方id md5 加密 生成唯一id',
  `type` int(2) unsigned NOT NULL DEFAULT '0' COMMENT '0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_id` (`uni_id`),
  KEY `user_id` (`user_id`),
  KEY `updated_time` (`updated_time`),
  KEY `unread_total` (`unread_total`),
  KEY `parent_id` (`parent_id`),
  KEY `to_user_id` (`to_user_id`),
  KEY `ordered_and userId` (`ordered`,`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

```