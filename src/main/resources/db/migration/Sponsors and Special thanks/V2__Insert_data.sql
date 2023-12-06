USE `Soholight`;

LOCK TABLES `sponsors` WRITE;
/*!40000 ALTER TABLE `sponsors` DISABLE KEYS */;
/*!40000 ALTER TABLE `sponsors` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `specialthanks` WRITE;
/*!40000 ALTER TABLE `specialthanks` DISABLE KEYS */;
INSERT INTO `specialthanks` VALUES
(1,'Team_8','https://git.cardiff.ac.uk/c23089855/team-8-soho-kids-christmas-lights','https://cdn.statically.io/gh/chenxuzhou1/fastapi@main/xxx/image-(1).70lk7katga00.webp');
/*!40000 ALTER TABLE `specialthanks` ENABLE KEYS */;
UNLOCK TABLES;