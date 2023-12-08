USE `Soholight`;

LOCK TABLES `sponsors` WRITE, `specialthanks` WRITE;
/*!40000 ALTER TABLE `sponsors` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialthanks` DISABLE KEYS */;

-- 在这里插入数据到'sponsors'表，如果需要的话

INSERT INTO `sponsors` VALUES
    (1, 'Team_8', 'https://git.cardiff.ac.uk/c23089855/team-8-soho-kids-christmas-lights', 'https://cdn.statically.io/gh/chenxuzhou1/fastapi@main/xxx/image-(1).70lk7katga00.webp');
/*!40000 ALTER TABLE `sponsors` ENABLE KEYS */;

INSERT INTO `specialthanks` VALUES
    (1, 'Team_8', 'https://git.cardiff.ac.uk/c23089855/team-8-soho-kids-christmas-lights', 'https://cdn.statically.io/gh/chenxuzhou1/fastapi@main/xxx/image-(1).70lk7katga00.webp');

/*!40000 ALTER TABLE `specialthanks` ENABLE KEYS */;

UNLOCK TABLES;
