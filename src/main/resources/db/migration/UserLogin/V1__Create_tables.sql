--
-- Current Database: `Soholight`
--

CREATE DATABASE /*!32312 IF NOT EXISTS */ `Soholight` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
--
USE `Soholight`;
-- Table structure for table `userlogin`
--
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin`
(
    `user_id`  INT(11),
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
