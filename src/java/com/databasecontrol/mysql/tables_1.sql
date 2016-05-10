create database `movie`  
character set 'utf8'  
COLLATE 'utf8_general_ci';
--管理员表
CREATE TABLE `admin` (
  `admin_id` int unsigned NOT NULL auto_increment,
  `admin_name` varchar(50) NOT NULL COMMENT '登录名',
  `admin_pwd` varchar(32) NOT NULL COMMENT '密码',
  PRIMARY KEY  USING BTREE (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--会员表
CREATE TABLE `user` (
  `user_id` varchar(11)  NOT NULL COMMENT '电话',
  `user_pwd` varchar(32) NOT NULL COMMENT '密码',
  `user_reg` timestamp   NOT NULL COMMENT '注册时间',
  `user_name` varchar(50) default NULL COMMENT '用户名',
  `user_email` varchar(50) NOT NULL COMMENT '邮箱',
  `user_phone` varchar(20) default NULL COMMENT '电话',
  `user_gender` tinyint(1) default NULL COMMENT '性别',
  PRIMARY KEY  USING BTREE (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--电影信息表
CREATE TABLE `movie` (
  `movie_id` varchar(8) NOT NULL,
  `movie_name` varchar(50) NOT NULL COMMENT '名称',
  `movie_director` varchar(50) NOT NULL COMMENT '导演',
  `movie_actor` varchar(100) NOT NULL COMMENT '演员',
  `movie_info` varchar(200) NOT NULL COMMENT '简介',
  `movie_lang` int unsigned NOT NULL COMMENT '语言',
  `movie_type` int unsigned NOT NULL COMMENT '类型',
  `movie_photo` varchar(200) NOT NULL COMMENT '海报',
  `movie_length` int unsigned NOT NULL COMMENT '片长',
  `movie_date` date NOT NULL COMMENT '上映日期',
  `movie_edition` int unsigned NOT NULL COMMENT '版本',
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--影评表
CREATE TABLE `comment` (
  `comment_id` INT(11) NOT NULL auto_increment,
  `movie_id` VARCHAR(8) NOT NULL,
  `user_id` VARCHAR(11) NOT NULL,
  `comment_title` VARCHAR(100) NULL,
  `comment_content` VARCHAR(500) NULL,
  `comment_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  INDEX `FK_comment_user_id_idx` (`user_id` ASC),
  INDEX `FK_comment_movie_id_idx` (`movie_id` ASC),
  CONSTRAINT `FK_comment_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_comment_movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie` (`movie_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--场次表
CREATE TABLE `play` (
  `play_id` varchar(10) NOT NULL,
  `movie_id` varchar(8) NOT NULL COMMENT '影片',
  `hall_id`	int NOT NULL COMMENT '放映厅',
  `play_time`  datetime NOT NULL COMMENT '开始时间',
  `play_price` double NOT NULL COMMENT '票价',
  PRIMARY KEY (`play_id`),
  INDEX `FK_play_movie_id_idx` (`movie_id` ASC),
  CONSTRAINT `FK_play_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--座位号表
CREATE TABLE `seats` (
  `user_id` VARCHAR(11) NOT NULL,
  `play_id` VARCHAR(10) NOT NULL,
  `seat_row` INT NOT NULL,
  `seat_line` INT NOT NULL,
  `seat_active` TINYINT NOT NULL,
  INDEX `FK_seats_play_id_idx` (`play_id` ASC),
  INDEX `FK_seats_user_id_idx` (`user_id` ASC),
  CONSTRAINT `FK_seats_play_id`
    FOREIGN KEY (`play_id`)
    REFERENCES `play` (`play_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_seats_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	
--订单信息表
CREATE TABLE `orderlist` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(11) NOT NULL,
  `play_id` VARCHAR(10) NOT NULL,
  `order_date` TIMESTAMP NOT NULL,
  `order_price` DOUBLE NULL,
  `order_pay` TINYINT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `FK_user_id_idx` (`user_id` ASC),
  INDEX `FK_play_id_idx` (`play_id` ASC),
  CONSTRAINT `FK_order_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_order_play_id`
    FOREIGN KEY (`play_id`)
    REFERENCES `play` (`play_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)ENGINE=InnoDB DEFAULT CHARSET=utf8;	
	
--订单座位表
CREATE TABLE `orderseats` (
  `order_id` INT NOT NULL,
  `seat_row` INT NOT NULL,
  `seat_line` INT NOT NULL,
  INDEX `FK_orderseats_order_id_idx` (`order_id` ASC),
  CONSTRAINT `FK_orderseats_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `orderlist` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)ENGINE=InnoDB DEFAULT CHARSET=utf8;