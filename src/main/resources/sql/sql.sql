CREATE TABLE `profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


CREATE TABLE `user_profile` (
  `userid` bigint(20) NOT NULL,
  `user_profileid` bigint(20) NOT NULL,
  `profileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`,`user_profileid`),
  KEY `FK_USER_PROFILE` (`user_profileid`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profileid`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

