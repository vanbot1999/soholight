USE `Soholight`;
LOCK TABLES `Feedback` WRITE;
/*!40000 ALTER TABLE `Feedback`
    DISABLE KEYS */;
INSERT INTO Feedback (username, email, message)
VALUES ('Enoch', 'enoch.ribin@domain.com', 'Great service and support.'),
       ('Yifan', 'yifan.wu@gmail.com', 'I had a wonderful experience.'),
       ('Chenxu', 'chenxu@hotmail.com', 'Very helpful and informative.');
/*!40000 ALTER TABLE `Feedback`
    ENABLE KEYS */;
UNLOCK TABLES;
