USE `Soholight`;
DROP TABLE IF EXISTS `PhoneNumeber`;
CREATE TABLE `PhoneNumeber` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT,
  `CountryCode` varchar(255) DEFAULT NULL,
  `PhoneNumeber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;