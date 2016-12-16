-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2016 a las 17:21:30
-- Versión del servidor: 10.1.9-MariaDB
-- Versión de PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_estoc`
--
CREATE DATABASE IF NOT EXISTS `bd_estoc` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `bd_estoc`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_categoria`
--

DROP TABLE IF EXISTS `tbl_categoria`;
CREATE TABLE IF NOT EXISTS `tbl_categoria` (
  `categoria_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_categoria`
--

INSERT INTO `tbl_categoria` (`categoria_id`, `categoria_nom`) VALUES
(1, 'Mueble'),
(2, 'Fruta'),
(3, 'Informatico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_comanda`
--

DROP TABLE IF EXISTS `tbl_comanda`;
CREATE TABLE IF NOT EXISTS `tbl_comanda` (
  `comanda_id` int(11) NOT NULL AUTO_INCREMENT,
  `comanda_quantitat` int(5) NOT NULL,
  `comanda_data` date NOT NULL,
  `prov_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comanda_id`),
  KEY `FK_comanda_prov` (`prov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_detall_com`
--

DROP TABLE IF EXISTS `tbl_detall_com`;
CREATE TABLE IF NOT EXISTS `tbl_detall_com` (
  `detall_com_id` int(11) NOT NULL AUTO_INCREMENT,
  `comanda_id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`detall_com_id`),
  KEY `FK_detall_com_prod` (`prod_id`),
  KEY `FK_detall_com_comanda` (`comanda_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estoc`
--

DROP TABLE IF EXISTS `tbl_estoc`;
CREATE TABLE IF NOT EXISTS `tbl_estoc` (
  `estoc_id` int(11) NOT NULL AUTO_INCREMENT,
  `estoc_q_max` int(5) NOT NULL,
  `estoc_q_min` int(5) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `lloc_id` int(11) DEFAULT NULL,
  `estoc_actual` int(4) NOT NULL,
  PRIMARY KEY (`estoc_id`),
  KEY `FK_estoc_prod` (`prod_id`),
  KEY `FK_estoc_lloc` (`lloc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_estoc`
--

INSERT INTO `tbl_estoc` (`estoc_id`, `estoc_q_max`, `estoc_q_min`, `prod_id`, `lloc_id`, `estoc_actual`) VALUES
(1, 99, 10, 2, 1, 14),
(2, 79, 5, 3, 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_lloc`
--

DROP TABLE IF EXISTS `tbl_lloc`;
CREATE TABLE IF NOT EXISTS `tbl_lloc` (
  `lloc_id` int(11) NOT NULL AUTO_INCREMENT,
  `num_bloc` enum('Bloc 1','Bloc 2','Bloc3','Bloc 4','Bloc 5','Bloc 6','Bloc 7','Bloc 8') COLLATE utf8_unicode_ci NOT NULL,
  `num_passadis` enum('passadis 1','passadis 2','passadis 3','passadis 4','passadis 5','passadis 6','passadis 7','passadis 8','passadis 9','passadis 10','passadis 11','passadis 12') COLLATE utf8_unicode_ci NOT NULL,
  `num_lleixa` enum('lleixa 1','lleixa 2','lleixa 3','lleixa 4','lleixa 5','lleixa 6','lleixa 7','lleixa 8') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`lloc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_lloc`
--

INSERT INTO `tbl_lloc` (`lloc_id`, `num_bloc`, `num_passadis`, `num_lleixa`) VALUES
(1, 'Bloc 1', 'passadis 2', 'lleixa 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_producte`
--

DROP TABLE IF EXISTS `tbl_producte`;
CREATE TABLE IF NOT EXISTS `tbl_producte` (
  `prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_nom` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prod_foto` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `prod_precio` double(5,2) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_producte`
--

INSERT INTO `tbl_producte` (`prod_id`, `prod_nom`, `prod_foto`, `prod_precio`, `categoria_id`) VALUES
(2, 'prueba', 'NA', 4.00, 1),
(3, 'prueba2', 'NA', 5.00, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_proveidor`
--

DROP TABLE IF EXISTS `tbl_proveidor`;
CREATE TABLE IF NOT EXISTS `tbl_proveidor` (
  `prov_id` int(11) NOT NULL AUTO_INCREMENT,
  `prov_nom` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prov_adre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `prov_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`prov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
CREATE TABLE IF NOT EXISTS `tbl_usuario` (
  `usu_id` int(3) NOT NULL AUTO_INCREMENT,
  `usu_nick` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `usu_pass` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`usu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`usu_id`, `usu_nick`, `usu_pass`) VALUES
(1, 'mlopez', 'asdf');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_comanda`
--
ALTER TABLE `tbl_comanda`
  ADD CONSTRAINT `FK_comanda_prov` FOREIGN KEY (`prov_id`) REFERENCES `tbl_proveidor` (`prov_id`);

--
-- Filtros para la tabla `tbl_detall_com`
--
ALTER TABLE `tbl_detall_com`
  ADD CONSTRAINT `FK_detall_com_comanda` FOREIGN KEY (`comanda_id`) REFERENCES `tbl_comanda` (`comanda_id`),
  ADD CONSTRAINT `FK_detall_com_prod` FOREIGN KEY (`prod_id`) REFERENCES `tbl_producte` (`prod_id`);

--
-- Filtros para la tabla `tbl_estoc`
--
ALTER TABLE `tbl_estoc`
  ADD CONSTRAINT `FK_estoc_lloc` FOREIGN KEY (`lloc_id`) REFERENCES `tbl_lloc` (`lloc_id`),
  ADD CONSTRAINT `FK_estoc_prod` FOREIGN KEY (`prod_id`) REFERENCES `tbl_producte` (`prod_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
