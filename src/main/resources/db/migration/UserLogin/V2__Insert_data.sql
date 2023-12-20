USE `Soholight`;

--
-- Dumping data for table `userlogin`
--
LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin`
    DISABLE KEYS */;
INSERT INTO `userlogin` (user_id, username, password)
VALUES (1, 'enoch', 'password123'),
       (2, 'yifan', 'password123'),
       (3, 'chenxu', 'password123'),
       (4, 'shijie', 'password123');
/*!40000 ALTER TABLE `userlogin`
    ENABLE KEYS */;
UNLOCK TABLES;