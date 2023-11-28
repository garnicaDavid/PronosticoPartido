-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tpfinal
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pronosticos`
--

DROP TABLE IF EXISTS `pronosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronosticos` (
  `equipo1` varchar(40) DEFAULT NULL,
  `ganaEquipo1` varchar(1) DEFAULT NULL,
  `empatan` varchar(1) DEFAULT NULL,
  `ganaEquipo2` varchar(1) DEFAULT NULL,
  `equipo2` varchar(40) DEFAULT NULL,
  `apostadores` varchar(40) DEFAULT NULL,
  `ronda` varchar(3) DEFAULT NULL,
  `fase` varchar(3) DEFAULT NULL,
  `idd` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idd`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronosticos`
--

LOCK TABLES `pronosticos` WRITE;
/*!40000 ALTER TABLE `pronosticos` DISABLE KEYS */;
INSERT INTO `pronosticos` VALUES ('Argentina','0','0','1','Arabia_Saud','Mariana','1','1',1),('Polonia','0','1','0','Mexico','Mariana','1','1',2),('Argentina','1','0','0','Mexico','Mariana','2','1',3),('Arabia_Saud','0','0','1','Polonia','Mariana','2','1',4),('Polonia','0','0','1','Argentina','Mariana','3','1',5),('Arabia_Saud','0','0','1','Mexico','Mariana','3','1',6),('Holanda','1','0','0','USA','Mariana','4','2',7),('Argentina','1','0','0','Australia','Mariana','4','2',8),('Holanda','0','0','1','Argentina','Mariana','5','2',9),('Craoacia','0','0','1','Brasil','Mariana','5','2',10),('Argentina','1','0','0','Arabia_Saud','Pedro','1','1',11),('Polonia','0','0','1','Mexico','Pedro','1','1',12),('Argentina','1','0','0','Mexico','Pedro','2','1',13),('Arabia_Saud','0','1','0','Polonia','Pedro','2','1',14),('Polonia','0','0','1','Argentina','Pedro','3','1',15),('Arabia_Saud','0','0','1','Mexico','Pedro','3','1',16),('Holanda','1','0','0','USA','Pedro','4','2',17),('Argentina','1','0','0','Australia','Pedro','4','2',18),('Holanda','0','0','1','Argentina','Pedro','5','2',19),('Craoacia','0','0','1','Brasil','Pedro','5','2',20),('Argentina','0','1','0','Arabia_Saud','Jorge','1','1',21),('Polonia','1','0','0','Mexico','Jorge','1','1',22),('Argentina','1','0','0','Mexico','Jorge','2','1',23),('Arabia_Saud','0','0','1','Polonia','Jorge','2','1',24),('Polonia','0','0','1','Argentina','Jorge','3','1',25),('Arabia_Saud','0','1','0','Mexico','Jorge','3','1',26),('Holanda','1','0','0','USA','Jorge','4','2',27),('Argentina','1','0','0','Australia','Jorge','4','2',28),('Holanda','0','1','0','Argentina','Jorge','5','2',29),('Craoacia','0','1','0','Brasil','Jorge','5','2',30);
/*!40000 ALTER TABLE `pronosticos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-27 21:34:36
