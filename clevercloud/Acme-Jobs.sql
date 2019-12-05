-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: acme-jobs
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2a5vcjo3stlfcwadosjfq49l1` (`user_account_id`),
  CONSTRAINT `FK_2a5vcjo3stlfcwadosjfq49l1` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (4,0,3),(1519,0,1518);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adrian_bulletin`
--

DROP TABLE IF EXISTS `adrian_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adrian_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adrian_bulletin`
--

LOCK TABLES `adrian_bulletin` WRITE;
/*!40000 ALTER TABLE `adrian_bulletin` DISABLE KEYS */;
/*!40000 ALTER TABLE `adrian_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alejandro_bulletin`
--

DROP TABLE IF EXISTS `alejandro_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alejandro_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alejandro_bulletin`
--

LOCK TABLES `alejandro_bulletin` WRITE;
/*!40000 ALTER TABLE `alejandro_bulletin` DISABLE KEYS */;
/*!40000 ALTER TABLE `alejandro_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `text` varchar(1024) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (1545,0,'2019-09-06 08:10:00.000000','http:/algo.com','Description01','Titulo01'),(1546,0,'2019-10-06 08:10:00.000000','http:/algo.com','Description02','Titulo02'),(1547,0,'2019-10-20 08:10:00.000000','http:/algo.com','Description03','Titulo03'),(1548,0,'2019-08-10 08:10:00.000000','http:/algo.com','Description04','Titulo04'),(1549,0,'2019-10-27 09:10:00.000000',NULL,'Description05','Titulo05');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anonymous`
--

DROP TABLE IF EXISTS `anonymous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anonymous` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6lnbc6fo3om54vugoh8icg78m` (`user_account_id`),
  CONSTRAINT `FK_6lnbc6fo3om54vugoh8icg78m` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anonymous`
--

LOCK TABLES `anonymous` WRITE;
/*!40000 ALTER TABLE `anonymous` DISABLE KEYS */;
INSERT INTO `anonymous` VALUES (2,0,1);
/*!40000 ALTER TABLE `anonymous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `qualifications` varchar(1024) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `skills` varchar(1024) DEFAULT NULL,
  `statements` varchar(1024) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `job_id` int(11) NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ct7r18vvxl5g4c4k7aefpa4do` (`reference`),
  KEY `FKoa6p4s2oyy7tf80xwc4r04vh6` (`job_id`),
  KEY `FKmbjdoxi3o93agxosoate4sxbt` (`worker_id`),
  CONSTRAINT `FKmbjdoxi3o93agxosoate4sxbt` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`),
  CONSTRAINT `FKoa6p4s2oyy7tf80xwc4r04vh6` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1617,0,'2019-09-15 08:10:00.000000','Qualifications1','EMPA-JOBB:APPA','Skills1','Statements1','PENDING',1606,1540),(1618,0,'2019-09-15 08:10:00.000000','Qualifications2','EMPA-JOBB:APPB','Skills2','Statements2','ACCEPTED',1606,1543),(1619,0,'2019-09-15 08:10:00.000000','Qualifications3','EMPA-JOBC:APPA','Skills3','Statements3','REJECTED',1607,1540),(1620,0,'2019-09-15 08:10:00.000000','Qualifications4','EMPA-JOBC:APPB','Skills4','Statements4','PENDING',1607,1543),(1621,0,'2019-09-15 08:10:00.000000','Qualifications5','EMPA-JOBD:APPA','Skills5','Statements5','PENDING',1608,1540),(1622,0,'2019-09-15 08:10:00.000000','Qualifications6','EMPB-JOBA:APPB','Skills6','Statements6','REJECTED',1609,1540),(1623,0,'2019-09-15 08:10:00.000000','Qualifications7','EMPB-JOBB:APPD','Skills7','Statements7','ACCEPTED',1610,1540);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditor`
--

DROP TABLE IF EXISTS `auditor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `firm` varchar(255) DEFAULT NULL,
  `responsibility_statement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_clqcq9lyspxdxcp6o4f3vkelj` (`user_account_id`),
  CONSTRAINT `FK_clqcq9lyspxdxcp6o4f3vkelj` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditor`
--

LOCK TABLES `auditor` WRITE;
/*!40000 ALTER TABLE `auditor` DISABLE KEYS */;
INSERT INTO `auditor` VALUES (1534,0,1533,'Firma 1','Algo que poner'),(1537,0,1536,'Firma 2','Algo que poner');
/*!40000 ALTER TABLE `auditor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditor_record`
--

DROP TABLE IF EXISTS `auditor_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditor_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(1024) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `auditor_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjx5w0xtdjllmdj2el2rlx4wdj` (`auditor_id`),
  KEY `FKcpwoo69w5dhtr8nvg0xhl9qv9` (`job_id`),
  CONSTRAINT `FKcpwoo69w5dhtr8nvg0xhl9qv9` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKjx5w0xtdjllmdj2el2rlx4wdj` FOREIGN KEY (`auditor_id`) REFERENCES `auditor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditor_record`
--

LOCK TABLES `auditor_record` WRITE;
/*!40000 ALTER TABLE `auditor_record` DISABLE KEYS */;
INSERT INTO `auditor_record` VALUES (1612,0,'Cuerpo del auditor1','2019-09-11 08:10:00.000000',_binary '','Titulo01',1534,1606),(1613,0,'Cuerpo del auditor2','2019-09-12 08:10:00.000000',_binary '','Titulo02',1537,1606),(1614,0,'Cuerpo del auditor3','2019-09-13 08:10:00.000000',_binary '','Titulo03',1534,1607),(1615,0,'Cuerpo del auditor4','2019-09-14 08:10:00.000000',_binary '','Titulo04',1534,1608),(1616,0,'Cuerpo del auditor5','2019-09-15 08:10:00.000000',_binary '','Titulo05',1537,1609);
/*!40000 ALTER TABLE `auditor_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated`
--

DROP TABLE IF EXISTS `authenticated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authenticated` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h52w0f3wjoi68b63wv9vwon57` (`user_account_id`),
  CONSTRAINT `FK_h52w0f3wjoi68b63wv9vwon57` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticated`
--

LOCK TABLES `authenticated` WRITE;
/*!40000 ALTER TABLE `authenticated` DISABLE KEYS */;
INSERT INTO `authenticated` VALUES (5,0,3),(1520,0,1518),(1523,0,1521),(1526,0,1524),(1529,0,1527),(1532,0,1530),(1535,0,1533),(1538,0,1536),(1541,0,1539),(1544,0,1542);
/*!40000 ALTER TABLE `authenticated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capi_bulletin`
--

DROP TABLE IF EXISTS `capi_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capi_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capi_bulletin`
--

LOCK TABLES `capi_bulletin` WRITE;
/*!40000 ALTER TABLE `capi_bulletin` DISABLE KEYS */;
/*!40000 ALTER TABLE `capi_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `challenge` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `goal_bronze` varchar(255) DEFAULT NULL,
  `goal_gold` varchar(255) DEFAULT NULL,
  `goal_silver` varchar(255) DEFAULT NULL,
  `reward_bronze` varchar(255) DEFAULT NULL,
  `reward_gold` varchar(255) DEFAULT NULL,
  `reward_silver` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (1556,0,'2019-12-31 23:00:00.000000','Login once a day for as many days as possible to receive a prize!','Login for 5 days straight!','Login for 30 days straight!','Login for 15 days straight!','1 day premium','10 days premium','5 days premium','Sample challenge 01'),(1557,0,'2019-12-04 23:00:00.000000','Post as many announcements as possible to receive a prize!','Post 5 announcements!','Post 20 announcements!','Post 10 announcements!','1 day premium','10 days premium','5 days premium','Sample challenge 02'),(1558,0,'2020-12-28 23:00:00.000000','Be a member for as long as possible to receive a prize!','Be a member for over a month!','Be a member for over a year!','Be a member for over 6 months!','1 week premium','Free premium','3 months premium','Sample challenge 03');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commercial_banner`
--

DROP TABLE IF EXISTS `commercial_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commercial_banner` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `card` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sponsor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd0k52g7lcacefcp62kb4p9aor` (`sponsor_id`),
  CONSTRAINT `FKd0k52g7lcacefcp62kb4p9aor` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commercial_banner`
--

LOCK TABLES `commercial_banner` WRITE;
/*!40000 ALTER TABLE `commercial_banner` DISABLE KEYS */;
INSERT INTO `commercial_banner` VALUES (1564,1,'1111111111111111','https://www.ofrendavirgendelpilar.com/wp-content/uploads/2018/09/rosa-roja-ofrenda.jpg','Flowers','https://www.flores.come',1522);
/*!40000 ALTER TABLE `commercial_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumer`
--

DROP TABLE IF EXISTS `consumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6cyha9f1wpj0dpbxrrjddrqed` (`user_account_id`),
  CONSTRAINT `FK_6cyha9f1wpj0dpbxrrjddrqed` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumer`
--

LOCK TABLES `consumer` WRITE;
/*!40000 ALTER TABLE `consumer` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customization_parameters`
--

DROP TABLE IF EXISTS `customization_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customization_parameters` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `spam_threshold` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customization_parameters`
--

LOCK TABLES `customization_parameters` WRITE;
/*!40000 ALTER TABLE `customization_parameters` DISABLE KEYS */;
INSERT INTO `customization_parameters` VALUES (1555,0,1);
/*!40000 ALTER TABLE `customization_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customization_parameters_spam_words`
--

DROP TABLE IF EXISTS `customization_parameters_spam_words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customization_parameters_spam_words` (
  `customization_parameters_id` int(11) NOT NULL,
  `spam_words` varchar(255) DEFAULT NULL,
  KEY `FKhcqquyqtys40tece78apjsbyt` (`customization_parameters_id`),
  CONSTRAINT `FKhcqquyqtys40tece78apjsbyt` FOREIGN KEY (`customization_parameters_id`) REFERENCES `customization_parameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customization_parameters_spam_words`
--

LOCK TABLES `customization_parameters_spam_words` WRITE;
/*!40000 ALTER TABLE `customization_parameters_spam_words` DISABLE KEYS */;
INSERT INTO `customization_parameters_spam_words` VALUES (1555,'cialis'),(1555,'million dollar'),(1555,'millon de dolares'),(1555,'you\'ve won'),(1555,'has ganado'),(1555,'nigeria'),(1555,'viagra'),(1555,'hard core'),(1555,'sex'),(1555,'sexo');
/*!40000 ALTER TABLE `customization_parameters_spam_words` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customization_parameters_spam_wordsen`
--

DROP TABLE IF EXISTS `customization_parameters_spam_wordsen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customization_parameters_spam_wordsen` (
  `customization_parameters_id` int(11) NOT NULL,
  `spam_wordsen` varchar(255) DEFAULT NULL,
  KEY `FKbhkqx27mqg6ab1q178e070cgc` (`customization_parameters_id`),
  CONSTRAINT `FKbhkqx27mqg6ab1q178e070cgc` FOREIGN KEY (`customization_parameters_id`) REFERENCES `customization_parameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customization_parameters_spam_wordsen`
--

LOCK TABLES `customization_parameters_spam_wordsen` WRITE;
/*!40000 ALTER TABLE `customization_parameters_spam_wordsen` DISABLE KEYS */;
INSERT INTO `customization_parameters_spam_wordsen` VALUES (16,'sex'),(16,'hard core'),(16,'viagra'),(16,'cialis'),(16,'nigeria'),(16,'you’ve won'),(16,'million dollar');
/*!40000 ALTER TABLE `customization_parameters_spam_wordsen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customization_parameters_spam_wordses`
--

DROP TABLE IF EXISTS `customization_parameters_spam_wordses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customization_parameters_spam_wordses` (
  `customization_parameters_id` int(11) NOT NULL,
  `spam_wordses` varchar(255) DEFAULT NULL,
  KEY `FKysc8qi3etv448vx3bp2amqna` (`customization_parameters_id`),
  CONSTRAINT `FKysc8qi3etv448vx3bp2amqna` FOREIGN KEY (`customization_parameters_id`) REFERENCES `customization_parameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customization_parameters_spam_wordses`
--

LOCK TABLES `customization_parameters_spam_wordses` WRITE;
/*!40000 ALTER TABLE `customization_parameters_spam_wordses` DISABLE KEYS */;
INSERT INTO `customization_parameters_spam_wordses` VALUES (16,'sexo'),(16,'hard core'),(16,'viagra'),(16,'cialis'),(16,'nigeria'),(16,'has ganado'),(16,'millon de dolares');
/*!40000 ALTER TABLE `customization_parameters_spam_wordses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptor`
--

DROP TABLE IF EXISTS `descriptor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descriptor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptor`
--

LOCK TABLES `descriptor` WRITE;
/*!40000 ALTER TABLE `descriptor` DISABLE KEYS */;
INSERT INTO `descriptor` VALUES (1600,0,'Description01'),(1601,0,'Description02'),(1602,0,'Description03'),(1603,0,'Description04'),(1604,0,'Description05'),(1605,0,'Description06');
/*!40000 ALTER TABLE `descriptor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descriptor_duty`
--

DROP TABLE IF EXISTS `descriptor_duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descriptor_duty` (
  `descriptor_id` int(11) NOT NULL,
  `dutys_id` int(11) NOT NULL,
  UNIQUE KEY `UK_gicb7at1idsamnu3xgj4i91vc` (`dutys_id`),
  KEY `FKqitedkrksd2w8qyp1fp5eao9f` (`descriptor_id`),
  CONSTRAINT `FKkm3m3388tiixfsn63295m8n13` FOREIGN KEY (`dutys_id`) REFERENCES `duty` (`id`),
  CONSTRAINT `FKqitedkrksd2w8qyp1fp5eao9f` FOREIGN KEY (`descriptor_id`) REFERENCES `descriptor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descriptor_duty`
--

LOCK TABLES `descriptor_duty` WRITE;
/*!40000 ALTER TABLE `descriptor_duty` DISABLE KEYS */;
INSERT INTO `descriptor_duty` VALUES (1600,1591),(1600,1592),(1601,1593),(1603,1594),(1603,1595),(1603,1596),(1604,1597),(1605,1598),(1605,1599);
/*!40000 ALTER TABLE `descriptor_duty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duty`
--

DROP TABLE IF EXISTS `duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duty` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `percentaje` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duty`
--

LOCK TABLES `duty` WRITE;
/*!40000 ALTER TABLE `duty` DISABLE KEYS */;
INSERT INTO `duty` VALUES (1591,0,'Description01',50.3,'Titulo01'),(1592,0,'Description02',43.3,'Titulo02'),(1593,0,'Description03',20.6,'Titulo03'),(1594,0,'Description04',15.8,'Titulo04'),(1595,0,'Description05',36.5,'Titulo05'),(1596,0,'Description06',5.5,'Titulo06'),(1597,0,'Description07',2.5,'Titulo07'),(1598,0,'Description08',20.5,'Titulo08'),(1599,0,'Description09',50.5,'Titulo09');
/*!40000 ALTER TABLE `duty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employer`
--

DROP TABLE IF EXISTS `employer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_na4dfobmeuxkwf6p75abmb2tr` (`user_account_id`),
  CONSTRAINT `FK_na4dfobmeuxkwf6p75abmb2tr` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employer`
--

LOCK TABLES `employer` WRITE;
/*!40000 ALTER TABLE `employer` DISABLE KEYS */;
INSERT INTO `employer` VALUES (1528,0,1527,'employer 1, Inc','Sector 1'),(1531,0,1530,'employer 2, Inc','Sector 2');
/*!40000 ALTER TABLE `employer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fernando_bulletin`
--

DROP TABLE IF EXISTS `fernando_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fernando_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fernando_bulletin`
--

LOCK TABLES `fernando_bulletin` WRITE;
/*!40000 ALTER TABLE `fernando_bulletin` DISABLE KEYS */;
/*!40000 ALTER TABLE `fernando_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1624);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investor_record`
--

DROP TABLE IF EXISTS `investor_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investor_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `investing_statement` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `stars` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investor_record`
--

LOCK TABLES `investor_record` WRITE;
/*!40000 ALTER TABLE `investor_record` DISABLE KEYS */;
INSERT INTO `investor_record` VALUES (1566,0,10,'Titulo01','Sector01',2),(1567,0,20.5,'Titulo02','Sector02',1),(1568,0,50.2,'Titulo03','Sector03',1),(1569,0,5,'Titulo04','Sector04',4),(1570,0,35.3,'Titulo05','Sector04',5);
/*!40000 ALTER TABLE `investor_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `more_info` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `salary_amount` double DEFAULT NULL,
  `salary_currency` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `descriptor_id` int(11) NOT NULL,
  `employer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7jmfdvs0b0jx7i33qxgv22h7b` (`reference`),
  KEY `FKfqwyynnbcsq0htxho3vchpd2u` (`descriptor_id`),
  KEY `FK3rxjf8uh6fh2u990pe8i2at0e` (`employer_id`),
  CONSTRAINT `FK3rxjf8uh6fh2u990pe8i2at0e` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`),
  CONSTRAINT `FKfqwyynnbcsq0htxho3vchpd2u` FOREIGN KEY (`descriptor_id`) REFERENCES `descriptor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1606,0,'2020-12-27 09:10:00.000000','http://acme.com','EMPA-JOBB',501.2,'EUR',_binary '','Titulo01',1600,1528),(1607,0,'2020-12-28 09:10:00.000000','http://acme.com','EMPA-JOBC',500,'EUR',_binary '','Titulo02',1601,1528),(1608,0,'2020-12-29 09:10:00.000000','http://acme.com','EMPA-JOBD',400,'EUR',_binary '','Titulo03',1602,1528),(1609,0,'2020-12-10 09:10:00.000000','http://acme.com','EMPB-JOBA',501.2,'EUR',_binary '','Titulo04',1603,1531),(1610,0,'2020-12-11 09:10:00.000000','http://acme.com','EMPB-JOBB',5000,'EUR',_binary '','Titulo05',1604,1531),(1611,0,'2020-12-12 09:10:00.000000','http://acme.com','EMPA-JOBX',5000,'EUR',_binary '\0','Titulo06',1605,1528);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luis_bulletin`
--

DROP TABLE IF EXISTS `luis_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luis_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luis_bulletin`
--

LOCK TABLES `luis_bulletin` WRITE;
/*!40000 ALTER TABLE `luis_bulletin` DISABLE KEYS */;
/*!40000 ALTER TABLE `luis_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKik4epe9dp5q6uenarfyia7xin` (`user_id`),
  CONSTRAINT `FKik4epe9dp5q6uenarfyia7xin` FOREIGN KEY (`user_id`) REFERENCES `authenticated` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1574,0,'Este es el cuerpo del mensaje','2019-09-06 07:30:00.000000','Un mensaje de algo',1520),(1575,0,'Este es el cuerpo del mensaje 2','2019-09-06 07:32:00.000000','Otro mensaje mas',1520),(1576,0,'Este es el cuerpo del mensaje 3','2019-09-06 07:40:00.000000','Aun mas mensajes',1520),(1577,0,'Buenos dias','2019-09-06 08:30:00.000000','Que tal',1520),(1578,0,'Holaa','2019-09-06 09:30:00.000000','Saludo',1520),(1579,0,'Este mensaje es solo para saludaros','2019-09-07 09:30:00.000000','Hola a todos',1529);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_tags`
--

DROP TABLE IF EXISTS `message_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_tags` (
  `message_id` int(11) NOT NULL,
  `tags` varchar(255) DEFAULT NULL,
  KEY `FKk6j00y1eiyu6qe5gad8rvefed` (`message_id`),
  CONSTRAINT `FKk6j00y1eiyu6qe5gad8rvefed` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_tags`
--

LOCK TABLES `message_tags` WRITE;
/*!40000 ALTER TABLE `message_tags` DISABLE KEYS */;
INSERT INTO `message_tags` VALUES (1574,'Menssage'),(1574,'Population'),(1574,'Algo mas que poner'),(1575,'Menssage'),(1575,'Population'),(1575,':)'),(1576,'Menssage'),(1576,'Population'),(1576,'Tres'),(1577,'Menssage'),(1577,'Population'),(1577,'Adios'),(1578,'Menssage'),(1578,'Hola'),(1578,'Por poner algo'),(1579,'Menssage'),(1579,'Hola'),(1579,'Saludo');
/*!40000 ALTER TABLE `message_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread`
--

DROP TABLE IF EXISTS `message_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread`
--

LOCK TABLES `message_thread` WRITE;
/*!40000 ALTER TABLE `message_thread` DISABLE KEYS */;
INSERT INTO `message_thread` VALUES (1580,0,'2019-09-03 07:30:00.000000','Hilo de mensajes'),(1581,0,'2019-09-05 07:30:00.000000','Comentarios'),(1582,0,'2019-09-03 07:30:00.000000','Vacio');
/*!40000 ALTER TABLE `message_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_thread_message`
--

DROP TABLE IF EXISTS `message_thread_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_thread_message` (
  `message_thread_id` int(11) NOT NULL,
  `messages_id` int(11) NOT NULL,
  UNIQUE KEY `UK_bx8ll7j8be93gcj4mnbmvm2rk` (`messages_id`),
  KEY `FKp1bkunf5gyu1vtt1q3f2djagy` (`message_thread_id`),
  CONSTRAINT `FKka0a2jm3m6obl7wa6586cqyp4` FOREIGN KEY (`messages_id`) REFERENCES `message` (`id`),
  CONSTRAINT `FKp1bkunf5gyu1vtt1q3f2djagy` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_thread_message`
--

LOCK TABLES `message_thread_message` WRITE;
/*!40000 ALTER TABLE `message_thread_message` DISABLE KEYS */;
INSERT INTO `message_thread_message` VALUES (1580,1574),(1580,1575),(1580,1576),(1581,1577),(1581,1578),(1582,1579);
/*!40000 ALTER TABLE `message_thread_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `non_commercial_banner`
--

DROP TABLE IF EXISTS `non_commercial_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `non_commercial_banner` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `jingle` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sponsor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpcpr0xb5k7s4rxv5pulstt5v9` (`sponsor_id`),
  CONSTRAINT `FKpcpr0xb5k7s4rxv5pulstt5v9` FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `non_commercial_banner`
--

LOCK TABLES `non_commercial_banner` WRITE;
/*!40000 ALTER TABLE `non_commercial_banner` DISABLE KEYS */;
INSERT INTO `non_commercial_banner` VALUES (1565,0,'patata','http://www.estadiodeportivo.com/elementosWeb/gestionCajas/EDE/Image/escudo-Real-Betis-2012.jpg','Manquepierda','https://www.betis.com',1525);
/*!40000 ALTER TABLE `non_commercial_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `reward_amount` double DEFAULT NULL,
  `reward_currency` varchar(255) DEFAULT NULL,
  `text` varchar(1024) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iex7e8fs0fh89yxpcnm1orjkm` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1550,0,'2020-12-27 09:10:00.000000','2019-10-27 09:10:00.000000',5001.2,'EUR','Description01','OADCD-55555','Titulo01'),(1551,0,'2020-10-27 09:10:00.000000','2019-09-21 08:10:00.000000',500,'EUR','Description02','OCCCc-55345','Titulo02'),(1552,0,'2020-12-30 09:10:00.000000','2019-10-26 08:10:00.000000',5001.2,'EUR','Description03','OACDC-14355','Titulo03'),(1553,0,'2020-11-27 09:10:00.000000','2019-10-25 08:10:00.000000',20.2,'EUR','Description04','OADCX-44445','Titulo04'),(1554,0,'2020-12-28 09:10:00.000000','2019-10-28 09:10:00.000000',501.2,'EUR','Description05','OADCW-75055','Titulo05');
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` (`user_account_id`),
  CONSTRAINT `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `ceo` varchar(255) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `incorporated` bit(1) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `stars` double DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `records` VALUES (1559,0,'Sergio','Description01',_binary '','sergio@gmail.com','Capi, Inc.','+34 66356995','Technology',5,'https://www.google.com'),(1560,0,'Juan','Description02',_binary '\0','capi@gmail.com','Laks, LLC','+912 (1231) 999549','Sports',4.3,'https://www.yahoo.com'),(1561,0,'Pepe','Description02',NULL,'capi@gmail.com','KimTe','(1231) 999549','Industrial',4.3,'https://www.yahoo.com'),(1562,0,'Rocío','Description02',_binary '','capi@gmail.com','Jaws, Inc.','999549','Security',NULL,'https://www.yahoo.com'),(1563,0,'Adri','Description10',_binary '','algo@gmail.com','Alguien, Inc.','999549','Security',NULL,'https://www.yahoo.com');
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `reward_amount` double DEFAULT NULL,
  `reward_currency` varchar(255) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9mxq3powq8tqctclj0fbi2nih` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1571,0,'2019-12-27 09:10:00.000000','Esta es una descripción de prueba','2019-10-27 09:10:00.000000',501.2,'EUR','RABCD-91234','Titulo01'),(1572,0,'2020-03-15 12:15:00.000000','¡Un coche por favor!','2019-11-03 09:10:00.000000',9999.99,'EUR','RABGH-98534','Quiero un coche de lujo'),(1573,0,'2020-09-03 07:30:00.000000','O una caravana','2019-09-03 07:30:00.000000',999.99,'EUR','RUIGH-98744','Para ser feliz quiero un camión');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shout`
--

DROP TABLE IF EXISTS `shout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shout` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shout`
--

LOCK TABLES `shout` WRITE;
/*!40000 ALTER TABLE `shout` DISABLE KEYS */;
/*!40000 ALTER TABLE `shout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sponsor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_20xk0ev32hlg96kqynl6laie2` (`user_account_id`),
  CONSTRAINT `FK_20xk0ev32hlg96kqynl6laie2` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sponsor`
--

LOCK TABLES `sponsor` WRITE;
/*!40000 ALTER TABLE `sponsor` DISABLE KEYS */;
INSERT INTO `sponsor` VALUES (1522,0,1521,'123456AX','Sponsor ej 1'),(1525,0,1524,NULL,'Sponsor ej 2');
/*!40000 ALTER TABLE `sponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `identity_email` varchar(255) DEFAULT NULL,
  `identity_name` varchar(255) DEFAULT NULL,
  `identity_surname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_castjbvpeeus0r8lbpehiu0e4` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,0,_binary '\0','john.doe@acme.com','John','Doe','$2a$05$.bZgYTtL.22Nvh/BokABXubc0NKMn1fJ/uDAjF194bfFgemiSTmhG','anonymous'),(3,0,_binary '','administrator1@acme.com','Administrator','Acme1.com','$2a$05$WUV9Oftr5nbx5MNNZe3Ko.V6zKo81AhIMk96qj5GJxlSX2rJ.Nar2','administrator01'),(1518,0,_binary '','administrator@acme.com','Administrator','Acme.com','$2a$05$m6ePE7cXXoDJDzdRcejS/uLXHnyXRtrtBxLFi0hyEANPj2RbBFf7e','administrator'),(1521,0,_binary '','sponsor1@acme.com','Sponsor','One','$2a$05$KNP6tIrGg66vBuO7JuH1Pet502ooVeB.Bd2nTNy19TY3oTPRr6./a','sponsor1'),(1524,0,_binary '','sponsor2@acme.com','Sponsor','One','$2a$05$PT0xWE1s/TL0D10qL4cN1uzVXj8Upfn8CtXWY.JI6x2lF/ZivIjaq','sponsor2'),(1527,0,_binary '','employer1@acme.com','Employer','One','$2a$05$ygW9eBw66Qmemgdr5Y81XuYkv5Ia4.PBbLe2PR3Lhr6.x8B9lUzvG','employer1'),(1530,0,_binary '','employer2@acme.com','Employer2','Two','$2a$05$GU07o1D9WYjXA/KshodCseg.OPZBdib3Gx99qgMP6LZbjxbN5ub9i','employer2'),(1533,0,_binary '','auditor1@acme.com','auditor','One','$2a$05$l2JhSe3UXeMdjvTap9V3ReMRio5mAV6JelgeUzQUjZhjcWiOZ/NYG','auditor1'),(1536,0,_binary '','auditor2@acme.com','auditor2','One','$2a$05$SfGviTEnUQmcUYgjny5e2uvc4Zn1dYZMGX3ZyVgt.OevVUx6Pv5Li','auditor2'),(1539,0,_binary '','worker1@acme.com','worker','One','$2a$05$GleNF/OjngWqnaZrd.ifR./vGXailCWBbWesSPqFYmy/EbIi0v6NW','worker1'),(1542,0,_binary '','worker2@acme.com','worker2','One','$2a$05$go7KodKHWkJS.1YSrC2qX.q./LDJ/4Sgbl5MHVTjltZtZNIfktmNm','worker2');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_involved`
--

DROP TABLE IF EXISTS `user_involved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_involved` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `message_thread_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKevpise8r0ofnf4xpw18mkgesw` (`message_thread_id`),
  KEY `FKn5kf90daeyb1rcq0soeax5tx3` (`user_id`),
  CONSTRAINT `FKevpise8r0ofnf4xpw18mkgesw` FOREIGN KEY (`message_thread_id`) REFERENCES `message_thread` (`id`),
  CONSTRAINT `FKn5kf90daeyb1rcq0soeax5tx3` FOREIGN KEY (`user_id`) REFERENCES `authenticated` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_involved`
--

LOCK TABLES `user_involved` WRITE;
/*!40000 ALTER TABLE `user_involved` DISABLE KEYS */;
INSERT INTO `user_involved` VALUES (1583,0,1580,1520),(1584,0,1581,1520),(1585,0,1582,1520),(1586,0,1582,1538),(1587,0,1582,1535),(1588,0,1582,1529),(1589,0,1582,1532),(1590,0,1582,1541);
/*!40000 ALTER TABLE `user_involved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `qualifications_record` varchar(255) DEFAULT NULL,
  `skills_record` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l5q1f33vs2drypmbdhpdgwfv3` (`user_account_id`),
  CONSTRAINT `FK_l5q1f33vs2drypmbdhpdgwfv3` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (1540,0,1539,'quealifications 1','skills 1, Inc'),(1543,0,1542,'quealifications 2','skills 2');
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-04 11:53:54
