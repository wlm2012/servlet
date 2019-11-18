CREATE TABLE `t_article` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL,
  `article` text DEFAULT NULL,
  `update_time` datetime NOT null ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(600) NOT NULL,
  `create_time` datetime NOT null  DEFAULT CURRENT_TIMESTAMP,
  `visited` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `t_article_update_time_IDX` (`update_time`) USING BTREE,
  KEY `t_article_user_id_IDX` (`user_id`) USING BTREE,
  KEY `t_article_title_IDX` (`title`) USING BTREE,
  KEY `t_article_create_time_IDX` (`create_time`) USING BTREE,
  KEY `t_article_visited_IDX` (`visited`) USING BTREE,
  FULLTEXT KEY `t_article_article_IDX` (`article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `t_user` (
  `id` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_un` (`name`),
  KEY `t_user_status_IDX` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





CREATE TABLE `t_v6_log` (
  `user` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `svrName` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `body` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createtime` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  KEY `t_v6_log_user_IDX` (`user`) USING BTREE,
  KEY `t_v6_log_svrName_IDX` (`svrName`(768)) USING BTREE,
  KEY `t_v6_log_createtime_IDX` (`createtime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci



