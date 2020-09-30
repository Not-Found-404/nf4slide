CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(40) DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮件',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `type` varchar(6) NOT NULL COMMENT '用户类型',
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