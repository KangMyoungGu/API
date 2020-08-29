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
-- Table structure for table `tbl_prod_intro`
--

DROP TABLE IF EXISTS `tbl_prod_intro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_prod_intro` (
  `PROD_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품서브코드',
  `PROD_INTRO_IMG_PATH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품상세정보이미지경로',
  `PROD_INTRO_IMG_NM` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품상세정보이미지명',
  `SORT_SEQ` int NOT NULL COMMENT '정렬순서',
  `USE_YN` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '사용여부',
  `REG_DATE` datetime DEFAULT NULL COMMENT '등록일자',
  `REG_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '등록자ID',
  `MOD_DATE` datetime DEFAULT NULL COMMENT '수정일자',
  `MOD_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '수정자ID',
  PRIMARY KEY (`PROD_CD`,`SORT_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품상세소개정보테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_prod_intro`
--

LOCK TABLES `tbl_prod_intro` WRITE;
/*!40000 ALTER TABLE `tbl_prod_intro` DISABLE KEYS */;
INSERT INTO `tbl_prod_intro` VALUES ('OC01000002','/img/outer_info','insilence_info_1.jpg',1,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_2.jpg',2,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_3.jpg',3,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_4.jpg',4,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_5.jpg',5,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_6.jpg',6,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_7.jpg',7,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_8.jpg',8,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_9.jpg',9,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_10.jpg',10,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_11.jpg',11,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_12.jpg',12,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_13.jpg',13,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_14.jpg',14,'Y','2020-08-26 16:09:21','admin',NULL,NULL),('OC01000002','/img/outer_info','insilence_info_15.jpg',15,'Y','2020-08-26 16:09:21','admin',NULL,NULL);
/*!40000 ALTER TABLE `tbl_prod_intro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-29 12:19:36
