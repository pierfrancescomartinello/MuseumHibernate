-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: museum
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
INSERT INTO `account` VALUES ('Alelame@gmail.com','IlGustoDellOrrido1010',0),('AurelianoAdami@gmail.com','vemenamoforte',0),('BippoBaudoReal@gmail.com','AHAHAHHAHAHAHA',1),('Bm3t@gmail.com','99999999999',0),('ciaociao@youunipa.it','ciaociao',0),('interistasbarazzino00','robehrobeh',0),('mar280499@gmail.com','passwordbella',0),('mikeracc@gmail.com','iosonobatman',0),('pierframarti@gmail.com','KONODIODA',0),('pippofranco@unipa.it','pastaefagioli',0),('sdfefjsefjwejnwfe.it','ciaociao',0),('StatesSchool@gmail.com','18611865',0),('themessiah99@gmail.com','sonoubriaco',0),('TheRealJesus@gmail.com','sonoubriacoreal',1),('turbosuca@unipa.it','sucamaturbo',0),('unanuovaemail@you.unipa.it',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Barocca','Barocco',199,0),(2,'John Wick','Marocco',NULL,0),(3,'ciao','ciaesimo',4,0),(4,'Jotaro','JoJo',NULL,1),(5,'Quinta','Impressionante',NULL,1);
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
  `immagine` mediumblob,
  `miniatura` blob,
  PRIMARY KEY (`artworkId`),
  KEY `location` (`areaId`),
  CONSTRAINT `location` FOREIGN KEY (`areaId`) REFERENCES `area` (`areaId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artwork`
--

LOCK TABLES `artwork` WRITE;
/*!40000 ALTER TABLE `artwork` DISABLE KEYS */;
INSERT INTO `artwork` VALUES (1,'beppe','we','2021-03-01','we','we',NULL,NULL,NULL),(2,'we','we','2020-03-04','dokefe','erfererg',NULL,NULL,NULL),(15,'Impressione','Anonimo','15.287878787818181818','Una persona impressionata',NULL,5,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('Giuseppe','Termerissa','1999-12-25','2018-01-01',0,1,1,10000,1,0,'TheRealJesus@gmail.com'),('palla','palle','2021-01-04','2021-01-04',0,0,4,0,0,0,'unanuovaemail@you.unipa.it'),('palla','palle','2021-01-04',NULL,0,0,5,0,0,0,'ciaociao@youunipa.it'),('pippo','franco','2021-01-04','2021-01-04',0,0,6,0,0,0,'pippofranco@unipa.it'),('Simone','Turbante','1978-10-10','2018-01-01',1,0,199,2000,8,0,'Themessiah99@gmail.com'),('Bippo','Baudo','1978-10-10','2018-01-01',0,0,1010,1900,0,1,'BippoBaudoReal@gmail.com');
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
) ENGINE=InnoDB AUTO_INCREMENT=2312 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (2310,'Adult','2021-02-01','2020-12-27',1,9,8.99),(2311,'Adult','2021-02-01','2020-12-27',1,6,8.99);
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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES ('Matteo','Bellavia','1998-08-27','2020-07-01',1,6,'Bm3t@gmail.com'),('Marco','Marrone','1999-04-28','2020-01-02',1,9,'mar280499@gmail.com'),('wefgewgwee','ffhdfd','2020-01-05','2020-01-05',0,10,'turbosuca@unipa.it'),('Michele','Raccuglia','1999-09-11','2020-01-02',1,11,'mikeracc@gmail.com'),('Pierfrancesco','Martinello','2000-05-11','2020-01-02',1,12,'pierframarti@gmail.com'),('Alessandro','Lame','2001-10-11','2019-10-11',1,20,'Alelame@gmail.com'),('Aureliano','Adami','1984-05-20','2020-01-01',1,34,'AurelianoAdami@gmail.com'),('Daniel','Smith','1968-11-01','2019-11-02',1,91,'StatesSchool@gmail.com');
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

-- Dump completed on 2021-01-11 10:48:57
