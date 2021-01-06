-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: museum
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `isLoggedIn` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('ciaociao@youunipa.it','ciaociao',0),('pippofranco@unipa.it','pastaefagioli',0),('sdfefjsefjwejnwfe.it','ciaociao',0),('turbosuca@unipa.it','sucamaturbo',0),('unanuovaemail@you.unipa.it',NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `areaId` int NOT NULL AUTO_INCREMENT,
  `areaName` varchar(255) DEFAULT NULL,
  `areaStyle` varchar(255) DEFAULT NULL,
  `areaCuratorID` int DEFAULT NULL,
  `isAccessible` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`areaId`),
  KEY `areaCurator` (`areaCuratorID`),
  CONSTRAINT `areaCurator` FOREIGN KEY (`areaCuratorID`) REFERENCES `employee` (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (3,'ciao','ciaesimo',4,0);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artwork`
--

DROP TABLE IF EXISTS `artwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artwork` (
  `artworkId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `submissionDate` varchar(255) DEFAULT NULL,
  `simpleDescription` varchar(255) DEFAULT NULL,
  `completeDescription` varchar(255) DEFAULT NULL,
  `areaId` int DEFAULT NULL,
  PRIMARY KEY (`artworkId`),
  KEY `location` (`areaId`),
  CONSTRAINT `location` FOREIGN KEY (`areaId`) REFERENCES `area` (`areaId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artwork`
--

LOCK TABLES `artwork` WRITE;
/*!40000 ALTER TABLE `artwork` DISABLE KEYS */;
INSERT INTO `artwork` VALUES (1,'beppe','we','2021-03-01','we','we',NULL),(2,'we','we','2020-03-04','dokefe','erfererg',NULL);
/*!40000 ALTER TABLE `artwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `fName` varchar(255) DEFAULT '',
  `surname` varchar(255) DEFAULT '',
  `dateOfBirth` date DEFAULT ((0 = NULL)),
  `dateOfSignUp` date DEFAULT NULL,
  `isCurator` tinyint(1) DEFAULT '0',
  `isDirector` tinyint(1) DEFAULT '0',
  `employeeid` int NOT NULL AUTO_INCREMENT,
  `salary` float DEFAULT (0.0),
  `workingHours` int NOT NULL DEFAULT (0),
  `isSalesperson` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeid`),
  UNIQUE KEY `employeeId` (`employeeid`),
  KEY `emailE` (`email`),
  CONSTRAINT `emailE` FOREIGN KEY (`email`) REFERENCES `account` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('palla','palle','2021-01-04','2021-01-04',0,0,4,0,0,0,'unanuovaemail@you.unipa.it'),('palla','palle','2021-01-04',NULL,0,0,5,0,0,0,'ciaociao@youunipa.it'),('pippo','franco','2021-01-04','2021-01-04',0,0,6,0,0,0,'pippofranco@unipa.it');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!50001 DROP VIEW IF EXISTS `sales`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sales` AS SELECT 
 1 AS `visitorId`,
 1 AS `tickets`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticketId` int NOT NULL AUTO_INCREMENT,
  `ticketType` varchar(255) DEFAULT NULL,
  `visitDate` date DEFAULT ((0 = NULL)),
  `purchaseDate` date DEFAULT ((0 = NULL)),
  `isUsable` tinyint(1) DEFAULT '1',
  `visitor` int DEFAULT NULL,
  `ticketPrice` float NOT NULL DEFAULT (0.0),
  PRIMARY KEY (`ticketId`),
  KEY `ticketOwner` (`visitor`),
  CONSTRAINT `ticketOwner` FOREIGN KEY (`visitor`) REFERENCES `visitor` (`visitorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor` (
  `fName` varchar(255) DEFAULT '',
  `surname` varchar(255) DEFAULT '',
  `dateOfBirth` date DEFAULT ((0 = NULL)),
  `dateOfSignUp` date DEFAULT NULL,
  `isAdult` tinyint(1) DEFAULT '0',
  `visitorid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`visitorid`),
  KEY `emailV` (`email`),
  CONSTRAINT `emailV` FOREIGN KEY (`email`) REFERENCES `account` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES ('wefgewgwee','ffhdfd','2020-01-05','2020-01-05',0,10,'turbosuca@unipa.it');
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `sales`
--

/*!50001 DROP VIEW IF EXISTS `sales`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sales` (`visitorId`,`tickets`) AS select `visitor`.`visitorid` AS `visitorId`,`ticket`.`ticketId` AS `ticketId` from (`ticket` join `visitor` on((`ticket`.`visitor` = `visitor`.`visitorid`))) group by `visitor`.`visitorid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-06 11:44:16