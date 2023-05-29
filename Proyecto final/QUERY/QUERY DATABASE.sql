
Create database db_CRUD_Final;

use db_CRUD_Final;

CREATE TABLE `libros` (
  `idLibros` int NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Autor` varchar(45) NOT NULL,
  `Publicacion` datetime NOT NULL,
  `Categoria` varchar(45) NOT NULL,
  `Idioma` varchar(45) NOT NULL,
  `Paginas` int NOT NULL,
  `Edicion` varchar(45) NOT NULL,
  `Cantidad` varchar(45) NOT NULL,
  `Disponibles` int NOT NULL,
  PRIMARY KEY (`idLibros`)
) ;

use db_CRUD_Final;
CREATE TABLE `usuarios` (
  `idUsuarios` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Clave` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `nombreLibor` varchar(45),
  `Cantidad` int,
  PRIMARY KEY (`idUsuarios`)
);










