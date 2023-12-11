
USE `Soholight`;
DROP TABLE IF EXISTS `Sponsors`;

CREATE TABLE `Sponsors` (
  `Sponsor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `URL` varchar(2083) DEFAULT NULL,
  `Sponsor_logo` varchar(2083) DEFAULT NULL,
  PRIMARY KEY (`Sponsor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `SpecialThanks`;
CREATE TABLE `SpecialThanks` (
  `SpecialThanks_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `URL` varchar(2083) DEFAULT NULL,
  `SpecialThanks_logo` varchar(2083) DEFAULT NULL,
  PRIMARY KEY (`SpecialThanks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;