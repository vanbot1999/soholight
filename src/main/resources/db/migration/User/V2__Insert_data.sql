USE `Soholight`;
LOCK TABLES `User` WRITE;

INSERT INTO User (first_name, last_name, email, birthday_date)
VALUES ('Enoch ', 'Ribin', 'enoch.ribin@gmail.com', '1998-05-15'),
       ('Yifan', 'Wu', 'yifan.wu@gmail.com', '1999-10-10'),
       ('Chenxu', 'Zhou', 'chenxu.zhou@gmail.com', '1998-03-10'),
       ('Shijie', 'Yin', 'shijie.yin@gmail.com', '1997-11-28');

UNLOCK TABLES;