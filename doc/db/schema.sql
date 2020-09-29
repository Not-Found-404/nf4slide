CREATE TABLE `slide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `library_id` bigint(20) NOT NULL COMMENT '文件库id',
  `folder_id` bigint(20) NOT NULL COMMENT '所在文件目录id',
  `name` varchar(32) DEFAULT NULL COMMENT '幻灯片名',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `status` varchar(10) NOT NULL COMMENT '状态',
  `author_set` varchar(1024) DEFAULT NULL COMMENT '参与人',
  `access_level` varchar(10) NOT NULL COMMENT '访问等级，公开或者私有',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁',
  `extra_json` varchar(1024) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_library_id` (`library_id`),
  KEY `idx_folder_id` (`folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COMMENT='幻灯片';


CREATE TABLE `slide_content` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`slide_id` bigint(20) NOT NULL COMMENT '幻灯片id',
	`slide_name` varchar(64) DEFAULT NULL COMMENT '幻灯片名',
	`content_type` varchar(10) NOT NULL COMMENT '内容存储方式，FILE:存储在oss中，TEXT:存储在数据库中',
	`content_text` text DEFAULT NULL COMMENT 'TEXT:幻灯片内容',
	`content_url` varchar(64) DEFAULT NULL COMMENT 'FILE:幻灯片内容url',
  `config_json` varchar(1024) DEFAULT NULL COMMENT '播放配置项',
	`status` varchar(10) NOT NULL COMMENT '状态',
	`version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁',
	`extra_json` varchar(1024),
	`created_at` datetime NOT NULL,
	`updated_at` datetime NOT NULL,
	`updated_by` varchar(10) DEFAULT NULL COMMENT '最后更新人',
	KEY `idx_slide_id_status` (`slide_id`,`status`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 100000 CHARSET = utf8mb4 COMMENT '幻灯片内容';

CREATE TABLE `folder` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录id',
	`level` tinyint NOT NULL COMMENT '层级，0为根目录',
	`library_id`  bigint(20) NOT NULL COMMENT '文件库id',
	`name` varchar(32) NOT NULL COMMENT '目录名',
	`p_id` bigint(20) DEFAULT -1 COMMENT '父目录id',
	`status` varchar(10) NOT NULL COMMENT '状态',
	`extra_json` varchar(1024),
	`created_at` datetime NOT NULL,
	`updated_at` datetime NOT NULL,
	KEY `idx_owner` (`owner_id`,`owner_type`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 100000 CHARSET = utf8mb4 COMMENT '文件库';


CREATE TABLE `library` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`owner_type` varchar(5) NOT NULL COMMENT '拥有者类型, TEAM:团队， USER:个人',
	`owner_id`  bigint(20) NOT NULL COMMENT '拥有者id',
	`name` varchar(32) NOT NULL COMMENT '文件库名',
	`description` varchar(128) DEFAULT NULL COMMENT '描述',
	`access_level` varchar(10) NOT NULL COMMENT '访问等级，公开或者私有',
	`status` varchar(10) NOT NULL COMMENT '状态',
	`extra_json` varchar(1024),
	`created_at` datetime NOT NULL,
	`updated_at` datetime NOT NULL,
	KEY `idx_owner` (`owner_id`,`owner_type`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 100000 CHARSET = utf8mb4 COMMENT '文件库';


CREATE TABLE `team` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` varchar(32) NOT NULL COMMENT '团队名',
	`owner_id`  bigint(20) NOT NULL COMMENT '拥有者id',
	`description` varchar(128) DEFAULT NULL COMMENT '描述',
	`description` varchar(128) DEFAULT NULL COMMENT '描述',
	`access_level` varchar(10) NOT NULL COMMENT '访问等级，公开或者私有',
	`member_amount` int(10) NOT NULL COMMENT '团队成员数量',
	`status` varchar(10) NOT NULL COMMENT '状态',
	`extra_json` varchar(1024),
	`created_at` datetime NOT NULL,
	`updated_at` datetime NOT NULL,
	KEY `idx_owner` (`owner_id`,`owner_type`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 100000 CHARSET = utf8mb4 COMMENT '团队';


CREATE TABLE `team_user_binding` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`team_id` bigint(20) NOT NULL  COMMENT '团队id',
	`user_id` bigint(20) NOT NULL  COMMENT '用户id',
	`access_level` varchar(10) NOT NULL COMMENT '访问等级，公开或者私有',
	`status` varchar(10) NOT NULL COMMENT '状态'，
	`extra_json` varchar(1024),
	`created_at` datetime NOT NULL,
	`updated_at` datetime NOT NULL,
	KEY `idx_item_user` (`team_id`,`user_id`),
	PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 100000 CHARSET = utf8mb4 COMMENT '团队用户关联';


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(40) DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮件',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `type` smallint(6) NOT NULL COMMENT '用户类型',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像图片地址',
  `name` varchar(40) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(10) NOT NULL COMMENT '状态',
  `role_json` varchar(512) DEFAULT NULL COMMENT '用户权限信息',
  `extra_json` varchar(1024) DEFAULT NULL COMMENT '用户额外信息',
  `tag_json` varchar(1024) DEFAULT NULL COMMENT '用户标签的json表示形式',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_users_email` (`email`),
  UNIQUE KEY `idx_users_mobile` (`phone`)
) ENGINE=InnoDB CHARSET=utf8 COMMENT='用户表';