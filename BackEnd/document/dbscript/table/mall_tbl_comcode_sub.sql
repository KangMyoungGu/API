CREATE DATABASE  IF NOT EXISTS `mall` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mall`;
-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 210.219.182.74    Database: mall
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_comcode_sub`
--

DROP TABLE IF EXISTS `tbl_comcode_sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_comcode_sub` (
  `COM_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'MASTER공통코드',
  `COM_SUB_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '공통서브코드',
  `COM_SUB_NM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '서브공통코드명',
  `REG_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '등록자ID',
  `MOD_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '수정자ID',
  `REG_DATE` datetime DEFAULT NULL COMMENT '등록일자',
  `MOD_DATE` datetime DEFAULT NULL COMMENT '수정일자',
  PRIMARY KEY (`COM_CD`,`COM_SUB_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='공통코드서브';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comcode_sub`
--

LOCK TABLES `tbl_comcode_sub` WRITE;
/*!40000 ALTER TABLE `tbl_comcode_sub` DISABLE KEYS */;
INSERT INTO `tbl_comcode_sub` VALUES ('CO','BLK','블랙','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','BLU','파랑','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','GRE','초록','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','GRY','그레이','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','NAV','네이비','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','ORA','주황','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','PNK','핑크','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','RED','빨강','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','VIO','보라','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','WHI','화이트','admin',NULL,'2020-08-21 18:52:50',NULL),('CO','YEL','노랑','admin',NULL,'2020-08-21 18:52:50',NULL),('OC','OC01','패딩','admin',NULL,'2020-08-21 18:52:50',NULL),('OC','OC02','가디건','admin',NULL,'2020-08-21 18:52:50',NULL),('OC','OC03','자켓','admin',NULL,'2020-08-21 18:52:50',NULL);
/*!40000 ALTER TABLE `tbl_comcode_sub` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-29 12:19:37
