DROP TABLE IF EXISTS `peliculas`;
DROP TABLE IF EXISTS `salas`;

CREATE TABLE `peliculas` (
  `codigo` int NOT NULL auto_increment,
  `nombre` varchar(100) NOT NULL,
  `calificacionEdad` int NOT NULL,
  PRIMARY KEY (`codigo`)
);
INSERT INTO `peliculas` (`nombre`,`calificacionEdad`) VALUES ('La bella y la bestia',12),('Scary Movie',16),('Thor: Love and Thunder',12);


CREATE TABLE `salas` (
  `codigo` int NOT NULL auto_increment,
  `nombre` varchar(100) NOT NULL,
  `pelicula` int NOT NULL,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `salas_fk1` FOREIGN KEY (`pelicula`) REFERENCES `peliculas` (`codigo`)
);
INSERT INTO `salas` (`nombre`,`pelicula`) VALUES ('Marvel',3),('Disney',1),('Comedia',2);