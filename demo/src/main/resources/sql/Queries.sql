CREATE USER 'bankingdemo'@'localhost' IDENTIFIED BY 'bankingdemo';

GRANT ALL PRIVILEGES ON * . * TO 'bankingdemo'@'localhost';
ALTER USER 'bankingdemo'@'localhost' IDENTIFIED WITH mysql_native_password BY 'bankingdemo';

DROP DATABASE  IF EXISTS `bankingdemo`;

CREATE DATABASE  IF NOT EXISTS `bankingdemo`;
USE `bankingdemo`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(20) NOT NULL,
  `password` varchar(80) NOT NULL,
  `role` varchar(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `balance` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `customer` VALUES (101, 'nihar' ,'$2a$10$HNJa8V.ZeVzfOgZMQuzx8eL7VjJuK2JcCAj0vr1hx3Mn3NnR3bpiO', 'ROLE_USER', 'nihar', NOW(), 1500.00),
(102, 'sachin','$2a$10$HNJa8V.ZeVzfOgZMQuzx8eL7VjJuK2JcCAj0vr1hx3Mn3NnR3bpiO', 'ROLE_USER', 'sachin', NOW(), 2200.00),
(103, 'rahul' ,'$2a$10$HNJa8V.ZeVzfOgZMQuzx8eL7VjJuK2JcCAj0vr1hx3Mn3NnR3bpiO', 'ROLE_USER', 'rahul', NOW(), 3400.00),
(104, 'dhoni' ,'$2a$10$HNJa8V.ZeVzfOgZMQuzx8eL7VjJuK2JcCAj0vr1hx3Mn3NnR3bpiO', 'ROLE_USER', 'dhoni', NOW(), 4500.00),
(105, 'admin' ,'$2a$10$aJMXGwDM35iBfFsLftwaseNKJdiBSQdjhZCWmNtN6MEpkyq0NOZdy', 'ROLE_ADMIN', 'admin', NOW(), 7600.00);

CREATE TABLE `payee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `accountno` varchar(20) NOT NULL,
  `ifsc` varchar(20) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `payee_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `transaction_detail` (
  `tx_id` int(11) NOT NULL AUTO_INCREMENT,
  `tx_date_time` datetime NOT NULL,
  `tx_type` varchar(20) NOT NULL,
  `tx_amount` double(10,2) NOT NULL,
  `payee_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`tx_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `tx_cust_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  KEY `payee_id` (`payee_id`),
  CONSTRAINT `tx_payee_ibfk_1` FOREIGN KEY (`payee_id`) REFERENCES `payee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `transaction_detail` VALUES (10001, NOW(), "deposite", 1200.00, 8, 101),
(10002, NOW(), "deposite", 1200.00, 8, 101),
(10003, NOW(), "withdraw", 600.00, 8, 101);