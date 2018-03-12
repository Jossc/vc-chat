## user_system_message
---
### Properties
Number|Name|Type|Length|Digit|NotNull|Default|Remark
  ---|---|---|---|---|---|---|---
1|	id|	Long|	19|	0|	Y|	null|	   
2|	user_id|	String|	64|	0|	Y|	null|	用户id   
3|	system_message_id|	Long|	19|	0|	N|	null|	系统消息id   
4|	created_time|	Date|	19|	0|	N|	null|	创建时间   
5|	uni_id|	String|	32|	0|	N|	null|	user_id与system_message_id 加密的MD5 唯一键   


### sql
```sql
CREATE TABLE IF NOT EXISTS `user_system_message` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `system_message_id` bigint(19) DEFAULT NULL COMMENT '系统消息id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `uni_id` varchar(32) DEFAULT NULL COMMENT 'user_id与system_message_id 加密的MD5 唯一键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_id` (`uni_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```