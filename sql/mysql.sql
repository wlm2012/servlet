CREATE TABLE `t_article` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL,
  `article` text,
  `update_time` datetime NOT NULL,
  `title` varchar(600) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `t_article_update_time_IDX` (`update_time`) USING BTREE,
  KEY `t_article_user_id_IDX` (`user_id`) USING BTREE,
  KEY `t_article_title_IDX` (`title`) USING BTREE,
  FULLTEXT KEY `t_article_article_IDX` (`article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `t_user` (
  `id` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `t_user_status_IDX` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci