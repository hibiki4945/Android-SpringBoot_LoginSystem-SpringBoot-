CREATE TABLE IF NOT EXISTS `user` (
  `account` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`account`)
);