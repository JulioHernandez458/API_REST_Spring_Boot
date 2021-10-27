CREATE SCHEMA `pruebadb` ;

USE pruebadb;

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);

select * from pruebadb.persona;