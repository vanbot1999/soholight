USE
    `Soholight`;
DROP TABLE IF EXISTS `PhoneNumber`;
CREATE TABLE `PhoneNumber`
(
    `User_id`     int(11) NOT NULL,
    `CountryCode` varchar(255) DEFAULT NULL,
    PhoneNumber   varchar(255) DEFAULT NULL,
    PRIMARY KEY (`User_id`),
    CONSTRAINT `user_id_phonenumber` FOREIGN KEY (`User_id`) REFERENCES `User` (`User_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
