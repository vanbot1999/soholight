USE `Soholight`;
LOCK TABLES `PhoneNumber` WRITE;
/*!40000 ALTER TABLE `PhoneNumber`
    DISABLE KEYS */;
INSERT INTO `PhoneNumber` (User_id, CountryCode, PhoneNumber)
VALUES (1, '+44', '9876543210'),
       (2, '+44', '8765343219'),
       (3, '+44', '7654321987'),
       (4, '+44', '9696958348');
/*!40000 ALTER TABLE `PhoneNumber`
    ENABLE KEYS */;
UNLOCK TABLES;
