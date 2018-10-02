-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-10-2018 a las 13:34:07
-- Versión del servidor: 5.7.21
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nosvamos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE IF NOT EXISTS `equipo` (
  `nombre_equipo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `estado_equipo` tinyint(4) NOT NULL,
  `usuario_correo_usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `liga_nombre_liga` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo_liga_idtipo_liga` int(11) NOT NULL,
  PRIMARY KEY (`nombre_equipo`),
  KEY `fk_equipo_usuario1` (`usuario_correo_usuario`),
  KEY `fk_equipo_liga1` (`liga_nombre_liga`),
  KEY `fk_equipo_tipo_liga1` (`tipo_liga_idtipo_liga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`nombre_equipo`, `estado_equipo`, `usuario_correo_usuario`, `liga_nombre_liga`, `tipo_liga_idtipo_liga`) VALUES
('admin', 1, 'super@super.com', NULL, 1),
('Alisa', 0, 'arcu.Curabitur.ut@mollislectus.co.uk', NULL, 3),
('Alvin', 0, 'dictum.Phasellus@euultrices.ca', NULL, 1),
('Alyssa', 0, 'elit@netus.co.uk', NULL, 1),
('Anastasia', 1, 'congue.turpis@malesuadafames.edu', NULL, 1),
('April', 0, 'at.risus@at.ca', NULL, 3),
('Berk', 1, 'congue.turpis@malesuadafames.edu', NULL, 2),
('Bevis', 0, 'a@sitamet.edu', NULL, 3),
('Brielle', 1, 'eget.metus.eu@Sed.net', NULL, 3),
('Brooke', 0, 'felis.Donec@egestas.co.uk', NULL, 1),
('Cassidy', 0, 'iaculis.quis@eudui.org', NULL, 2),
('Castor', 0, 'elit.pretium@scelerisque.net', NULL, 1),
('Daphne', 0, 'elit@netus.co.uk', NULL, 2),
('Daryl', 1, 'at.velit.Cras@fames.edu', NULL, 1),
('Denton', 1, 'elit.pretium@scelerisque.net', NULL, 1),
('Eaton', 0, 'dignissim@convallisante.co.uk', NULL, 2),
('Ella', 0, 'felis.Donec@egestas.co.uk', NULL, 3),
('Fitzgerald', 0, 'erat.volutpat@fringilla.edu', NULL, 3),
('Flynn', 1, 'auctor@vestibulumneceuismod.edu', NULL, 3),
('Hop', 0, 'cursus.non@Quisquepurus.net', NULL, 1),
('juan', 0, 'super@super.com', NULL, 1),
('Juan Perez', 0, 'JuanPerez@gmail.com', 'Internacional', 2),
('Julie', 1, 'erat.volutpat@fringilla.edu', NULL, 2),
('Kaden', 0, 'dolor.egestas@Suspendissedui.ca', NULL, 3),
('Korinox', 1, 'super@super.com', 'Internachional :v', 2),
('Leigh', 1, 'elit.pretium@scelerisque.net', NULL, 2),
('Lester', 1, 'eget.metus.eu@Sed.net', NULL, 1),
('Macey', 0, 'id@velitAliquamnisl.com', NULL, 3),
('Maggie', 1, 'at.risus@at.ca', NULL, 1),
('Mara', 1, 'elit@netus.co.uk', NULL, 2),
('Martin', 0, 'dolor.egestas@Suspendissedui.ca', NULL, 3),
('Nadine', 0, 'dolor.egestas@Suspendissedui.ca', NULL, 2),
('Nehru', 1, 'dictum@atsem.edu', NULL, 3),
('Olivia', 0, 'elit.pretium@scelerisque.net', NULL, 1),
('Paki', 0, 'iaculis.quis@eudui.org', NULL, 1),
('pepe', 0, 'super@super.com', NULL, 2),
('Phelan', 1, 'eget.ipsum@Namligula.org', NULL, 1),
('Quinlan', 0, 'congue.turpis@malesuadafames.edu', NULL, 2),
('Remedias', 0, 'elit.pretium@scelerisque.net', NULL, 3),
('Remedios', 1, 'dolor.egestas@Suspendissedui.ca', NULL, 1),
('Teegan', 0, 'eget.ipsum@Namligula.org', NULL, 2),
('Thomas', 1, 'dignissim@convallisante.co.uk', NULL, 3),
('Ursula', 0, 'at.risus@at.ca', NULL, 3),
('Whitney', 1, 'aptent@Innecorci.org', NULL, 3),
('Zachary', 0, 'elit@netus.co.uk', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

DROP TABLE IF EXISTS `imagen`;
CREATE TABLE IF NOT EXISTS `imagen` (
  `imagen` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `liga_nombre_liga` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `equipo_nombre_equipo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `integrantes_rut_integrante` varchar(13) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`imagen`),
  KEY `fk_imagen_liga1` (`liga_nombre_liga`),
  KEY `fk_imagen_equipo1` (`equipo_nombre_equipo`),
  KEY `fk_imagen_integrantes2` (`integrantes_rut_integrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`imagen`, `liga_nombre_liga`, `equipo_nombre_equipo`, `integrantes_rut_integrante`) VALUES
('Equipo-admin.jpg', NULL, 'admin', NULL),
('Equipo-Juan Perez', NULL, 'Juan Perez', NULL),
('Equipo-juan.jpg', NULL, 'juan', NULL),
('Equipo-pepe.jpg', NULL, 'pepe', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `integrantes`
--

DROP TABLE IF EXISTS `integrantes`;
CREATE TABLE IF NOT EXISTS `integrantes` (
  `rut_integrante` varchar(13) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_integrante` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nick` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `estado_int` tinyint(4) NOT NULL,
  `equipo_nombre_equipo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`rut_integrante`),
  KEY `fk_integrantes_equipo1` (`equipo_nombre_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `integrantes`
--

INSERT INTO `integrantes` (`rut_integrante`, `nombre_integrante`, `nick`, `estado_int`, `equipo_nombre_equipo`) VALUES
('11111111-1', 'Simon Chavez', 'Saimondo', 1, 'Alisa'),
('12345678-9', 'asdasd', 'asd123', 1, 'admin'),
('15157787-3', 'Robert', 'Anne', 1, 'Hop'),
('18807674-2', 'Ignatius', 'Mari', 1, 'Cassidy'),
('20822748-3', 'Conan', 'Joy', 1, 'Denton'),
('22053260-7', 'Guy', 'Denton', 1, 'Denton'),
('22094908-7', 'Phelan', 'Britanni', 1, 'Korinox'),
('22728930-9', 'Connor', 'Simone', 1, 'Zachary'),
('22908243-4', 'Zachary', 'Deacon', 1, 'Anastasia'),
('25474498-0', 'Oliver', 'Jackson', 1, 'Alyssa'),
('26638519-6', 'Caesar', 'Kennedy', 1, 'Brooke'),
('27411671-4', 'Emery', 'Stuart', 1, 'Phelan'),
('28334826-1', 'Chancellor', 'Dale', 1, 'Alyssa'),
('28737932-3', 'Marshall', 'Maggie', 1, 'Castor'),
('31177054-3', 'Hashim', 'Stacy', 1, 'Hop'),
('31810059-4', 'Tanner', 'Mollie', 1, 'Denton'),
('34729140-4', 'Conan', 'Noble', 1, 'Berk'),
('37015117-2', 'Malcolm', 'Stewart', 1, 'Brooke'),
('38564533-3', 'Gavin', 'Sawyer', 1, 'Castor'),
('38903270-0', 'Francis', 'Zeus', 1, 'Zachary'),
('39326282-6', 'Davis', 'Felicia', 1, 'Lester'),
('48266366-4', 'Reed', 'Kellie', 1, 'Anastasia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liga`
--

DROP TABLE IF EXISTS `liga`;
CREATE TABLE IF NOT EXISTS `liga` (
  `nombre_liga` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_termino` date NOT NULL,
  `lugar` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_liga_idtipo_liga` int(11) NOT NULL,
  PRIMARY KEY (`nombre_liga`),
  KEY `fk_liga_tipo_liga1` (`tipo_liga_idtipo_liga`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `liga`
--

INSERT INTO `liga` (`nombre_liga`, `fecha_inicio`, `fecha_termino`, `lugar`, `tipo_liga_idtipo_liga`) VALUES
('Internachional :v', '2018-09-12', '2018-09-28', 'Mikasa', 2),
('Internacional', '2018-09-14', '2018-09-21', 'Mikasa', 2),
('Internacional2038', '2018-09-07', '2018-09-13', 'Mikasa', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liga_resultado`
--

DROP TABLE IF EXISTS `liga_resultado`;
CREATE TABLE IF NOT EXISTS `liga_resultado` (
  `liga_nombre_liga` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `resultados_id_resultados` int(11) NOT NULL,
  KEY `fk_liga_resultado_liga1` (`liga_nombre_liga`),
  KEY `fk_liga_resultado_resultados1` (`resultados_id_resultados`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE IF NOT EXISTS `resultados` (
  `id_resultados` int(11) NOT NULL AUTO_INCREMENT,
  `equipo_1` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `equipo_2` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `ganador` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_resultado` datetime NOT NULL,
  PRIMARY KEY (`id_resultados`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_liga`
--

DROP TABLE IF EXISTS `tipo_liga`;
CREATE TABLE IF NOT EXISTS `tipo_liga` (
  `idtipo_liga` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idtipo_liga`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_liga`
--

INSERT INTO `tipo_liga` (`idtipo_liga`, `descripcion`) VALUES
(1, 'CS'),
(2, 'Dota2'),
(3, 'LoL'),
(4, 'Fornite');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `descripcion`) VALUES
(1, 'Super Usuario'),
(2, 'Administrador'),
(3, 'Particular'),
(4, 'Organizacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `correo_usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `pass_usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_usuario_id_tipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`correo_usuario`),
  KEY `fk_usuario_tipo_usuario1` (`tipo_usuario_id_tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`correo_usuario`, `nombre_usuario`, `pass_usuario`, `tipo_usuario_id_tipo_usuario`) VALUES
('a@sitamet.edu', 'Cathleen', '9206', 2),
('aptent@Innecorci.org', 'Jada', '8199', 3),
('arcu.Curabitur.ut@mollislectus.co.uk', 'Rogan', '7115', 3),
('at.risus@at.ca', 'Irma', '2684', 2),
('at.velit.Cras@fames.edu', 'Beatrice', '8535', 2),
('auctor@risus.org', 'Lynn', '8352', 3),
('auctor@vestibulumneceuismod.edu', 'Guy', '9894', 2),
('congue.turpis@malesuadafames.edu', 'Abraham', '3374', 2),
('consectetuer@semmolestie.co.uk', 'Emily', '4057', 3),
('cursus.non@Quisquepurus.net', 'Wynter', '3288', 2),
('dictum.Phasellus@euultrices.ca', 'Kellie', '4929', 2),
('dictum@atsem.edu', 'Erasmus', '3269', 2),
('dignissim@convallisante.co.uk', 'Chaney', '6213', 3),
('dolor.egestas@Suspendissedui.ca', 'Sylvester', '7983', 3),
('eget.ipsum@Namligula.org', 'Zachery', '1158', 2),
('eget.metus.eu@Sed.net', 'Kennan', '4713', 2),
('elit.a.feugiat@pharetraQuisqueac.ca', 'Cally', '3359', 3),
('elit.pretium@scelerisque.net', 'Sacha', '5647', 2),
('elit@liberonec.co.uk', 'Chester', '1727', 2),
('elit@netus.co.uk', 'Alika', '6162', 3),
('erat.volutpat@fringilla.edu', 'Nissim', '9561', 2),
('eu.lacus.Quisque@scelerisqueneque.net', 'Rachel', '8537', 2),
('felis.Donec@egestas.co.uk', 'Gloria', '9576', 2),
('iaculis.quis@eudui.org', 'Octavius', '9818', 3),
('id@velitAliquamnisl.com', 'Cassandra', '6552', 3),
('In.at.pede@sollicitudin.edu', 'Aurora', '8133', 3),
('Integer@massaQuisqueporttitor.net', 'Nathaniel', '5618', 2),
('JuanPerez@gmail.com', 'Juan Perez', 'asd123', 3),
('leo@molestie.ca', 'Adrian', '7931', 3),
('lorem.fringilla.ornare@Nullamscelerisque.net', 'Ramona', '2161', 2),
('magna.Ut.tincidunt@afelis.net', 'Beverly', '2272', 3),
('malesuada.vel.convallis@sempercursus.edu', 'Jasmine', '9324', 3),
('metus@Phasellusdapibusquam.net', 'Jack', '6300', 2),
('nisi@nunc.org', 'Clio', '1267', 2),
('nulla.at.sem@egestasAliquamfringilla.ca', 'Naomi', '8810', 3),
('orci@natoquepenatibuset.net', 'Rudyard', '3428', 3),
('ornare@tempus.org', 'Talon', '7488', 3),
('pede.Cras.vulputate@Aliquam.net', 'Joy', '4667', 3),
('penatibus.et@Cum.edu', 'Ruby', '8139', 2),
('penatibus@facilisis.org', 'Christian', '1785', 3),
('pharetra.nibh.Aliquam@congue.edu', 'Ulysses', '9970', 2),
('placerat@pharetra.edu', 'Evangeline', '4928', 3),
('quam@odioapurus.org', 'Grace', '4925', 2),
('quis.massa@Crasconvallis.net', 'Oleg', '3538', 3),
('quis@Sedeunibh.net', 'Lucas', '5649', 3),
('sagittis@acliberonec.com', 'Ishmael', '2375', 2),
('sed.pede.nec@magnaDuisdignissim.co.uk', 'Jerry', '6516', 3),
('sed@dictumPhasellusin.net', 'Paul', '7708', 3),
('Sed@lobortisauguescelerisque.ca', 'Declan', '9622', 3),
('sem.magna.nec@Vestibulumanteipsum.com', 'Yael', '3530', 3),
('super@super.com', 'Super Usuario', 'super', 1),
('turpis.egestas@arcu.org', 'Hyatt', '9854', 2),
('ut.aliquam.iaculis@atrisus.co.uk', 'Sybill', '8551', 3),
('ut.sem.Nulla@nibh.org', 'Arden', '3992', 3),
('ut@metusAliquam.com', 'Ivory', '1867', 3),
('ut@tinciduntnibh.org', 'Chaim', '8942', 3),
('varius.et@rutrum.org', 'Fiona', '5859', 2),
('varius.ultrices.mauris@parturientmontes.co.uk', 'Deanna', '3261', 3),
('vel.pede@Praesenteu.com', 'Cara', '4988', 2),
('velit@Suspendissealiquet.edu', 'Chava', '6436', 3),
('velit@tinciduntorci.net', 'Sawyer', '9818', 2),
('vitae@Etiamligula.edu', 'Anjolie', '6140', 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `fk_equipo_liga1` FOREIGN KEY (`liga_nombre_liga`) REFERENCES `liga` (`nombre_liga`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_equipo_tipo_liga1` FOREIGN KEY (`tipo_liga_idtipo_liga`) REFERENCES `tipo_liga` (`idtipo_liga`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_equipo_usuario1` FOREIGN KEY (`usuario_correo_usuario`) REFERENCES `usuario` (`correo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `fk_imagen_equipo1` FOREIGN KEY (`equipo_nombre_equipo`) REFERENCES `equipo` (`nombre_equipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_imagen_integrantes2` FOREIGN KEY (`integrantes_rut_integrante`) REFERENCES `integrantes` (`rut_integrante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_imagen_liga1` FOREIGN KEY (`liga_nombre_liga`) REFERENCES `liga` (`nombre_liga`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `integrantes`
--
ALTER TABLE `integrantes`
  ADD CONSTRAINT `fk_integrantes_equipo1` FOREIGN KEY (`equipo_nombre_equipo`) REFERENCES `equipo` (`nombre_equipo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `liga`
--
ALTER TABLE `liga`
  ADD CONSTRAINT `fk_liga_tipo_liga1` FOREIGN KEY (`tipo_liga_idtipo_liga`) REFERENCES `tipo_liga` (`idtipo_liga`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `liga_resultado`
--
ALTER TABLE `liga_resultado`
  ADD CONSTRAINT `fk_liga_resultado_liga1` FOREIGN KEY (`liga_nombre_liga`) REFERENCES `liga` (`nombre_liga`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_liga_resultado_resultados1` FOREIGN KEY (`resultados_id_resultados`) REFERENCES `resultados` (`id_resultados`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipo_usuario1` FOREIGN KEY (`tipo_usuario_id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
