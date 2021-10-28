CREATE SCHEMA IF NOT EXISTS `consultafit` DEFAULT CHARACTER SET latin1 ;
USE `consultafit` ;

CREATE TABLE `Producto` (
  `archivo` VarChar(255),
  `categoria` VarChar(15),
  `color` VarChar(30),
  `descrip` VarChar(555),
  `id_Producto` Int,	
  `marca` VarChar(50),
  `nombre` VarChar(50),
  `precio` Int,
  `talla` VarChar(50),
  `cantidad` Int,
  PRIMARY KEY (`id_Producto`)
);