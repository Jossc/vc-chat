## system_message
---
### Properties
Number|Name|Type|Length|Digit|NotNull|Default|Remark
  ---|---|---|---|---|---|---|---
1|	id|	Long|	19|	0|	Y|	null|	   
2|	send_id|	String|	64|	0|	N|	null|	发件人id   
3|	rec_id|	String|	64|	0|	N|	null|	收件人id   
4|	message|	String|	65535|	0|	N|	null|	消息内容   
5|	type|	Integer|	10|	0|	N|	null|	0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动    
6|	created_time|	Date|	19|	0|	N|	null|	创建时间   


### sql
```sql
CREATE TABLE IF NOT EXISTS `system_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_id` varchar(64) DEFAULT NULL COMMENT '发件人id',
  `rec_id` varchar(64) DEFAULT NULL COMMENT '收件人id',
  `message` text COMMENT '消息内容',
  `type` int(2) DEFAULT NULL COMMENT '0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动 ',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `created_time` (`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```