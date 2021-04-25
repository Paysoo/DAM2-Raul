-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-04-2021 a las 22:13:59
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `activitat3m6uf4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comandes`
--

CREATE TABLE `comandes` (
  `ID` smallint(4) NOT NULL,
  `IDPRODUCTE` smallint(4) NOT NULL,
  `DATACOMANDA` date DEFAULT NULL,
  `QUANTITAT` tinyint(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producte`
--

CREATE TABLE `producte` (
  `ID` smallint(4) NOT NULL,
  `DESCRIPCIO` varchar(50) DEFAULT NULL,
  `STOCKACTUAL` tinyint(3) DEFAULT NULL,
  `STOCKMINIM` tinyint(3) DEFAULT NULL,
  `PVP` float(6,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producte`
--

INSERT INTO `producte` (`ID`, `DESCRIPCIO`, `STOCKACTUAL`, `STOCKMINIM`, `PVP`) VALUES
(1, 'Teclado', 2, 2, 50.00),
(2, 'Pantalla', 2, 1, 120.00),
(3, 'Torre', 5, 2, 20.00),
(4, 'Raton', 20, 5, 30.00),
(5, 'Procesador', 15, 5, 300.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendes`
--

CREATE TABLE `vendes` (
  `ID` smallint(4) NOT NULL,
  `IDPRODUCTE` smallint(4) NOT NULL,
  `DATAVENDA` date DEFAULT NULL,
  `QUANTITAT` tinyint(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendes`
--

INSERT INTO `vendes` (`ID`, `IDPRODUCTE`, `DATAVENDA`, `QUANTITAT`) VALUES
(1, 1, '2021-04-25', 2),
(2, 1, '2021-04-25', 3),
(3, 1, '2021-04-25', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comandes`
--
ALTER TABLE `comandes`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `producte`
--
ALTER TABLE `producte`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `vendes`
--
ALTER TABLE `vendes`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
