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
-- Table structure for table `tbl_address`
--

DROP TABLE IF EXISTS `tbl_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_address` (
  `ADDR_CD` varchar(20) NOT NULL COMMENT '주소고유키',
  `ADDR_USER_CD` varchar(20) NOT NULL COMMENT '회원고유FK',
  `ZIPCODE` varchar(20) NOT NULL COMMENT '우편번호',
  `ADDRESS` varchar(50) NOT NULL COMMENT '주소',
  `ADDRESS_DETAIL` varchar(50) NOT NULL COMMENT '상세주소',
  PRIMARY KEY (`ADDR_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_address`
--

LOCK TABLES `tbl_address` WRITE;
/*!40000 ALTER TABLE `tbl_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comcode_master`
--

DROP TABLE IF EXISTS `tbl_comcode_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_comcode_master` (
  `COM_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '공통코드',
  `COM_NM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '공통코드명',
  `REG_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '등록자ID',
  `MOD_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '수정자ID',
  `REG_DATE` datetime DEFAULT NULL COMMENT '등록일자',
  `MOD_DATE` datetime DEFAULT NULL COMMENT '수정일자',
  PRIMARY KEY (`COM_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='공통코드';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comcode_master`
--

LOCK TABLES `tbl_comcode_master` WRITE;
/*!40000 ALTER TABLE `tbl_comcode_master` DISABLE KEYS */;
INSERT INTO `tbl_comcode_master` VALUES ('CO','색상','admin',NULL,'2020-08-21 18:48:36',NULL),('OC','아우터','admin',NULL,'2020-08-21 18:48:36',NULL);
/*!40000 ALTER TABLE `tbl_comcode_master` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `tbl_prod_best`
--

DROP TABLE IF EXISTS `tbl_prod_best`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_prod_best` (
  `PROD_CD` varchar(20) DEFAULT NULL,
  `EXPOSURE_START_PERIOD` datetime DEFAULT NULL,
  `EXPOSURE_END_PERIOD` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_prod_best`
--

LOCK TABLES `tbl_prod_best` WRITE;
/*!40000 ALTER TABLE `tbl_prod_best` DISABLE KEYS */;
INSERT INTO `tbl_prod_best` VALUES ('OC01000001','2020-08-24 16:44:11','2020-08-25 16:48:09'),('OC01000005','2020-08-24 16:44:16','2020-08-25 16:48:13'),('OC01000013','2020-08-24 16:44:20','2020-08-25 16:48:16'),('OC02000001','2020-08-24 16:44:23','2020-08-25 16:48:19'),('OC02000003','2020-08-24 16:44:27','2020-08-25 16:48:22');
/*!40000 ALTER TABLE `tbl_prod_best` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `tbl_prod_master`
--

DROP TABLE IF EXISTS `tbl_prod_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_prod_master` (
  `COM_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '공통마스터코드',
  `COM_SUB_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '공통서브코드',
  `SELL_PRICE` int DEFAULT NULL COMMENT '판매가',
  `PROD_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품코드',
  `PROD_NM` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품명',
  `USE_YN` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '판매여부',
  `PROD_MASTER_IMG_PATH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품대표이미지경로',
  `PROD_MASTER_IMG_NM` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '대표이미지파일명',
  `REG_DATE` datetime DEFAULT NULL COMMENT '등록일자',
  `REG_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '등록자ID',
  `MOD_DATE` datetime DEFAULT NULL COMMENT '수정일자',
  `MOD_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '수정자ID',
  `COST_PRICE` int DEFAULT NULL COMMENT '원가',
  PRIMARY KEY (`PROD_CD`),
  KEY `IDX_COM_SUB_CODE` (`COM_SUB_CD`) USING BTREE,
  KEY `IDX_COM_CODE` (`COM_CD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품마스터테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_prod_master`
--

LOCK TABLES `tbl_prod_master` WRITE;
/*!40000 ALTER TABLE `tbl_prod_master` DISABLE KEYS */;
INSERT INTO `tbl_prod_master` VALUES ('OC','OC01',89000,'OC01000001','트윈 배색 덕다운 숏패딩(그레이/블랙)','Y','/img/outer','0540080001712.gif','2020-08-21 18:53:40','admin',NULL,NULL,129000),('OC','OC01',70000,'OC01000002','인사일런스 에센셜 다운 자켓 GREY','Y','/img/outer','insilence.jpg','2020-08-21 18:53:40','admin',NULL,NULL,99000),('OC','OC01',99000,'OC01000003','트윈 배색 덕다운 오버 숏패딩','Y','/img/outer','overshort.jpg','2020-08-21 18:53:40','admin',NULL,NULL,140000),('OC','OC01',80000,'OC01000004','항공점퍼패딩','Y','/img/outer','pridshortpadding.jpg','2020-08-21 18:53:40','admin',NULL,NULL,100000),('OC','OC01',140000,'OC01000005','아디다스롱패딩','Y','/img/outer','adidas_pink_long.jpg','2020-08-21 18:53:40','admin',NULL,NULL,160000),('OC','OC01',890000,'OC01000006','캐나다구스 랭포드','Y','/img/outer','canada_langford.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1300000),('OC','OC01',990000,'OC01000007','캐나다구스 매그너','Y','/img/outer','canada_mac.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1570000),('OC','OC01',890000,'OC01000008','캐나다구스','Y','/img/outer','canada_red.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1100000),('OC','OC01',1130000,'OC01000009','몽클레어','Y','/img/outer','moncler_c.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1520000),('OC','OC01',1000000,'OC01000010','몽클레어 윌름','Y','/img/outer','moncler_willm.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1200000),('OC','OC01',380000,'OC01000011','노스페이스 롱패딩','Y','/img/outer','north_long_gray.jpg','2020-08-21 18:53:40','admin',NULL,NULL,450000),('OC','OC01',240000,'OC01000012','노스페이스700','Y','/img/outer','northface700.jpg','2020-08-21 18:53:40','admin',NULL,NULL,420000),('OC','OC01',130000,'OC01000013','플랙 숏패딩','Y','/img/outer','plac_short.jpg','2020-08-21 18:53:40','admin',NULL,NULL,200000),('OC','OC01',110000,'OC01000014','구김스 롱패딩','Y','/img/outer','googims_long.jpg','2020-08-21 18:53:40','admin',NULL,NULL,129000),('OC','OC02',170000,'OC02000001','꼼데가르송 가디건','Y','/img/outer','comme_gardigan.jpg','2020-08-21 18:53:40','admin',NULL,NULL,390000),('OC','OC02',170000,'OC02000002','폴로 베이직 가디건','Y','/img/outer','polo_gardigan.jpg','2020-08-21 18:53:40','admin',NULL,NULL,210000),('OC','OC02',170000,'OC02000003','폴로 베이직 가디건 블랙','Y','/img/outer','polo_gardigan_bl.jpg','2020-08-21 18:53:40','admin',NULL,NULL,210000),('OC','OC03',880000,'OC03000001','구찌 모직 블루종','Y','/img/outer','gucci_blue.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1480000),('OC','OC03',790000,'OC03000002','구찌 래빗 블루종','Y','/img/outer','gucci_rabit.jpg','2020-08-21 18:53:40','admin',NULL,NULL,1230000);
/*!40000 ALTER TABLE `tbl_prod_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_prod_size`
--

DROP TABLE IF EXISTS `tbl_prod_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_prod_size` (
  `PROD_SUB_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품서브코드',
  `PROD_SIZE` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품사이즈',
  `PROD_AMOUNT` decimal(20,10) DEFAULT '0.0000000000' COMMENT '상품수량',
  `PROD_SELL_AMOUNT` decimal(20,10) DEFAULT NULL COMMENT '상품판매수량',
  `REG_DATE` datetime DEFAULT NULL COMMENT '등록일자',
  `REG_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '등록자',
  PRIMARY KEY (`PROD_SUB_CD`,`PROD_SIZE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품재고수량';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_prod_size`
--

LOCK TABLES `tbl_prod_size` WRITE;
/*!40000 ALTER TABLE `tbl_prod_size` DISABLE KEYS */;
INSERT INTO `tbl_prod_size` VALUES ('OC0100000101','L',2.0000000000,0.0000000000,'2020-08-21 18:55:01','admin'),('OC0100000101','M',5.0000000000,0.0000000000,'2020-08-21 18:55:01','admin'),('OC0100000101','S',7.0000000000,2.0000000000,'2020-08-21 18:55:01','admin'),('OC0100000101','XL',1.0000000000,1.0000000000,'2020-08-21 18:55:01','admin'),('OC0100000102','L',3.0000000000,0.0000000000,'2020-08-21 18:55:01','admin'),('OC0100000102','M',5.0000000000,2.0000000000,'2020-08-21 18:55:01','admin'),('OC0100000102','S',4.0000000000,1.0000000000,'2020-08-21 18:55:01','admin');
/*!40000 ALTER TABLE `tbl_prod_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_prod_sub`
--

DROP TABLE IF EXISTS `tbl_prod_sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_prod_sub` (
  `PROD_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품코드',
  `PROD_SUB_CD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품서브코드',
  `PROD_COLOR_CD` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '색상타입코드',
  `PROD_COLOR_NM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품색상명',
  `REG_DATE` datetime DEFAULT NULL COMMENT '상품등록일자',
  `REG_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '등록자ID',
  `MOD_DATE` date DEFAULT NULL COMMENT '상품수정일자',
  `MOD_USER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품수정일자',
  `PROD_PREVIEW_IMG_PATH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품미리보기이미지경로',
  `PROD_PREVIEW_IMG_NM` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '상품미리보기이미지명',
  PRIMARY KEY (`PROD_CD`,`PROD_SUB_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품상세테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_prod_sub`
--

LOCK TABLES `tbl_prod_sub` WRITE;
/*!40000 ALTER TABLE `tbl_prod_sub` DISABLE KEYS */;
INSERT INTO `tbl_prod_sub` VALUES ('OC01000001','OC0100000101','BLK','블랙','2020-08-21 18:56:17','admin',NULL,NULL,NULL,NULL),('OC01000001','OC0100000102','GRY','그레이','2020-08-21 18:56:17','admin',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_prod_sub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_user` (
  `USER_CD` varchar(20) NOT NULL COMMENT '회원코드',
  `USER_ID` varchar(50) NOT NULL COMMENT '회원ID',
  `USER_PASSWORD` varchar(30) NOT NULL COMMENT '회원PW',
  `USER_EMAIL` varchar(50) NOT NULL COMMENT '회원EMAIL',
  `USER_NAME` varchar(30) NOT NULL COMMENT '회원명',
  `USER_PHONE` varchar(20) NOT NULL COMMENT '회원연락처',
  `USER_BIRTH` date NOT NULL COMMENT '회원생년월일',
  `REG_DATE` datetime NOT NULL COMMENT '회원등록일자',
  `MODE_DATE` datetime DEFAULT NULL COMMENT '회원등록일자',
  PRIMARY KEY (`USER_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-29 12:30:48
