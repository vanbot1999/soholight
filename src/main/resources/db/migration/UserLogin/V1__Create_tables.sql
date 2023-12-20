USE `Soholight`;
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin`
(
    `user_id`  INT(11),
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    CONSTRAINT `user_id_userlogin` FOREIGN KEY (`user_id`) REFERENCES `User` (`User_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
