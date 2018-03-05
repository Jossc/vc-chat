CREATE TABLE IF NOT EXISTS `pri_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '发件人id',
  `rec_id` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '收件人id',
  `message` text COMMENT '消息内容',
  `type` int(1) NOT NULL COMMENT '0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动 ',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dialogue_id` bigint(20) NOT NULL COMMENT '对话id',
  `uni_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_id` (`uni_id`),
  KEY `dialougue_id_nor` (`dialogue_id`),
  KEY `created_time_nor` (`created_time`),
  KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

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
  `type` int(2) unsigned NOT NULL COMMENT '0 普通消息 1 系统消息 2 点赞  3 关注 4 评论消息 5 作品 6 部落 7 签约 8 活动 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_id` (`uni_id`),
  KEY `user_id` (`user_id`),
  KEY `updated_time` (`updated_time`),
  KEY `unread_total` (`unread_total`),
  KEY `parent_id` (`parent_id`),
  KEY `to_user_id` (`to_user_id`),
  KEY `ordered_and userId` (`ordered`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

