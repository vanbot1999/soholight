USE `Soholight`;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`
(
    `User_id`       INT AUTO_INCREMENT PRIMARY KEY,
    `first_name`    VARCHAR(255) NOT NULL,
    `last_name`     VARCHAR(255) NOT NULL,
    `email`         VARCHAR(255) NOT NULL,
    `birthday_date` DATE         NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
