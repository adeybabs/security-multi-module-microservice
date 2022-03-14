DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS schooluser;


CREATE TABLE `role` (
   `id` long NOT NULL,
   `roleName` varchar(100) NOT NULL,
   PRIMARY KEY (`id`)
);

INSERT INTO `role` (`id`,`roleName`)
 VALUES (1,'ADMIN');

INSERT INTO `role` (`id`,`roleName`)
VALUES (2,'STUDENT');

INSERT INTO `role` (`id`,`roleName`)
VALUES (3,'STAFF');

INSERT INTO `role` (`id`,`roleName`)
VALUES (4,'ALUMNI');
 
CREATE TABLE `school_user` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar_casesensitive(100) NOT NULL,
  PRIMARY KEY (`id`)
);

 
INSERT INTO `school_user` (`id`, `name`,`email`, `username`, `password`)
 VALUES (1, 'Sarah','adeybabs.aa@gmmail.com', 'Sarah', 'S12345');

INSERT INTO `school_user` (`id`, `name`,`email`, `username`, `password`)
  VALUES (2, 'Jane Doe','adeybabs.aa@gmmail.com', 'Jane', 'J12345');

INSERT INTO `school_user` (`id`, `name`,`email`, `username`, `password`)
  VALUES (3, 'Fisher Reey', 'adeybabs.aa@gmmail.com','Fisher', 'F12345');

INSERT INTO `school_user` (`id`, `name`,`email`, `username`, `password`)
  VALUES (4, 'Don Simon', 'adeybabs.aa@gmmail.com','Don', 'D12345');

INSERT INTO `school_user` (`id`, `name`,`email`, `username`, `password`)
 VALUES (5, 'chichong','adeybabs.aa@gmmail.com', 'chi', 'C12345');

INSERT INTO `school_user` (`id`, `name`,`email`, `username`, `password`)
 VALUES (6, 'Angel','adeybabs.aa@gmmail.com', 'Angel', 'A12345');



