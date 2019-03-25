CREATE DATABASE  IF NOT EXISTS `LegoHouse`;


USE `LegoHouse`;

DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `LegoHouse`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `LegoHouse`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `shipped` BOOLEAN NOT NULL DEFAULT false,
  `shippingDate` DATE NOT NULL DEFAULT '1900-01-01',
  `connectedPattern` BOOLEAN NOT NULL DEFAULT false,
  `withDoor` BOOLEAN NOT NULL DEFAULT false,
  `withWindow` BOOLEAN NOT NULL DEFAULT false,
  PRIMARY KEY (`id`),
  INDEX `orderIdUserIdFK_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `orderIdUserIdFK`
    FOREIGN KEY (`userId`)
    REFERENCES `LegoHouse`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);




LOCK TABLES `users` WRITE;
INSERT INTO `users`(email, password, role) VALUES 
('jens@somewhere.com','jensen','CUSTOMER'),
('ken@somewhere.com','kensen','CUSTOMER'),
('robin@somewhere.com','batman','EMPLOYEE'),
('test@nowhere.com','1234','CUSTOMER'),
('tc','1','CUSTOMER'),
('te','1','EMPLOYEE'),
('test','12','EMPLOYEE');

LOCK TABLES `orders` WRITE;
INSERT INTO `orders`(userId, length, width, height) VALUES(4, 13, 9, 4);


UNLOCK TABLES;



