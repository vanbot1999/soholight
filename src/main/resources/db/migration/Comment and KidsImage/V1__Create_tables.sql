USE `Soholight`;

DROP TABLE IF EXISTS `Comment`;

DROP TABLE IF EXISTS `KidsImage`;

CREATE TABLE `KidsImage` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `URL` varchar(2083) DEFAULT NULL,
  `SourceURL` varchar(2083) DEFAULT NULL,
  `issueDate` text DEFAULT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `Comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_id` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_image_id` (`image_id`),
  CONSTRAINT `fk_image_id` FOREIGN KEY (`image_id`) REFERENCES `KidsImage` (`img_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
