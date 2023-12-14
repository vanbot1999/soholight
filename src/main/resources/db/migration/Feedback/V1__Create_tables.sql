USE `Soholight`;
CREATE TABLE feedback (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  email VARCHAR(255),
  message TEXT
);