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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-29 12:19:37
