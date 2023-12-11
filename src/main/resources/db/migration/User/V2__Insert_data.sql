USE `Soholight`;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User`
    DISABLE KEYS */;
INSERT INTO User (first_name, last_name, email, birthday_date)
VALUES ('Enoch ', 'Ribin', 'enoch.ribin@gmail.com', '1998-05-15'),
       ('Yifan', 'Wu', 'yifan.wu@gmail.com', '1999-10-10'),
       ('Chenxu', 'Zhou', 'chenxu.zhou@gmail.com', '1998-03-10'),
       ('Shijie', 'Yin', 'shijie.yin@gmail.com', '1997-11-28');

/*!40000 ALTER TABLE `User`
    ENABLE KEYS */;
UNLOCK TABLES;