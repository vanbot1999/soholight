USE `Soholight`;

LOCK TABLES `sponsors` WRITE, `specialthanks` WRITE;
/*!40000 ALTER TABLE `sponsors` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialthanks` DISABLE KEYS */;

-- 在这里插入数据到'sponsors'表，如果需要的话

INSERT INTO `sponsors` VALUES
    (1, 'fidelity energy', 'https://fidelity-energy.co.uk/', 'https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/5ac340da-ffed-465f-b384-db82c33e0023.1yqzgrgf3wio.webp'),
    (2,'shaftesbury capital','https://www.shaftesburycapital.com/en/index.html','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/SHAFTESBURY-CAPITAL-LOGO-RGB.1qr9u8rotakg.webp'),
    (3,'Hines','https://www.hines.com/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/Hines-187-Logo.2trdbkeeczm0.png'),
    (4,'CleaningSolutionsLtd','','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/CleaningSolutionsLtd-logo.f8d26r83ryo.webp'),
    (5,'archer street','https://archerstreet.co.uk/venues/soho/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/ArcherStreetLinear_SOHO.5dg9zeb33os0.webp'),
    (6,'city of westminster','https://www.westminster.gov.uk/council-tax','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/wcc_logo_cmyk.2pl7nb47tza0.webp');

/*!40000 ALTER TABLE `sponsors` ENABLE KEYS */;

INSERT INTO `specialthanks` VALUES
 (1,'TheLIA','https://www.thelia.org.uk/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/TheLIA_LOGO_Master.2i8qklgmgr20.webp'),
(2,'Tunda valiszka','https://www.valiszka.com/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/TV-Logo_TVP.4xn5lcvi65k0.png'),
(3,'fashion-textile-museum','https://fashiontextilemuseum.org/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/fashion-textile-museum-logo-[PNG].7dmu9ql85mw0.webp'),
(4,'cardiff university national software academy','https://www.cardiff.ac.uk/software-academy','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/NatSoftwareAcademyWhite.png-(1).53mzl1uwoos0.webp'),
(5,'Antonio Capelao Architecture','http://antoniocapelao-portfolio.co.uk/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/Antonio-Capelao-Architecture_black.3ix1id29yrg0.webp'),
(6,'Soho Radio','https://sohoradiolondon.com/','https://cdn.jsdelivr.net/gh/tantalulu/soho-pic@pic/xxx/White-Soho-Radio-Logo.60kw0210i2c0.webp');

/*!40000 ALTER TABLE `specialthanks` ENABLE KEYS */;

UNLOCK TABLES;
