-- MySQL dump 10.13  Distrib 8.3.0, for macos13.6 (arm64)
--
-- Host: localhost    Database: uk_medicine
-- ------------------------------------------------------
-- Server version	11.3.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `medi_history`
--

DROP TABLE IF EXISTS `medi_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medi_history` (
  `history_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ' 검색기록 키 값 ',
  `search_data` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medi_history`
--

LOCK TABLES `medi_history` WRITE;
/*!40000 ALTER TABLE `medi_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `medi_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medi_material`
--

DROP TABLE IF EXISTS `medi_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medi_material` (
  `material_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '재료 키 값 ',
  `comment` varchar(255) DEFAULT NULL,
  `material_nm` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  PRIMARY KEY (`material_id`),
  UNIQUE KEY `medi_material_UN` (`material_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='사용하는 약재 재료';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medi_material`
--

LOCK TABLES `medi_material` WRITE;
/*!40000 ALTER TABLE `medi_material` DISABLE KEYS */;
INSERT INTO `medi_material` VALUES (1,NULL,'진피',NULL,NULL),(2,NULL,'후박',NULL,NULL),(3,NULL,'창출',NULL,NULL),(4,NULL,'감초',NULL,NULL),(5,NULL,'생강',NULL,NULL),(6,NULL,'백작약',NULL,NULL),(7,NULL,'백지',NULL,NULL),(8,NULL,'오미자',NULL,NULL),(12,NULL,'황기','2024-01-18 23:54:02','2024-01-18 23:54:02'),(14,NULL,'백출','2024-01-18 23:54:22','2024-01-18 23:54:22'),(15,NULL,'당귀신','2024-01-18 23:54:31','2024-01-18 23:54:31'),(16,NULL,'승마','2024-01-18 23:54:40','2024-01-18 23:54:40'),(17,NULL,'시호','2024-01-18 23:54:44','2024-01-18 23:54:44'),(18,NULL,'맥문동','2024-01-18 23:54:49','2024-01-18 23:54:49'),(19,NULL,'꿀','2024-01-18 23:55:03','2024-01-18 23:55:03'),(20,NULL,'숙지황','2024-01-18 23:55:18','2024-01-18 23:55:18'),(21,NULL,'당귀','2024-01-18 23:55:26','2024-01-18 23:55:26'),(22,NULL,'천궁','2024-01-18 23:55:31','2024-01-18 23:55:31'),(23,NULL,'육계','2024-01-18 23:55:36','2024-01-18 23:55:36'),(24,NULL,'대조','2024-01-18 23:55:43','2024-01-18 23:55:43'),(25,NULL,'백복령','2024-01-18 23:55:57','2024-01-18 23:55:57'),(26,NULL,'산약','2024-01-18 23:56:52','2024-01-18 23:56:52'),(27,NULL,'산수유','2024-01-18 23:56:59','2024-01-18 23:56:59'),(28,NULL,'택사','2024-01-18 23:57:04','2024-01-18 23:57:04'),(29,NULL,'목단피','2024-01-18 23:57:08','2024-01-18 23:57:08'),(30,NULL,'마황','2024-01-18 23:57:15','2024-01-18 23:57:15'),(31,NULL,'법반하','2024-01-18 23:57:25','2024-01-18 23:57:25'),(32,NULL,'세신','2024-01-18 23:57:31','2024-01-18 23:57:31'),(33,NULL,'건강','2024-01-18 23:57:37','2024-01-18 23:57:37'),(34,NULL,'계지','2024-01-18 23:57:42','2024-01-18 23:57:42'),(35,NULL,'자감초','2024-01-18 23:57:45','2024-01-18 23:57:45'),(36,NULL,'길경','2024-01-18 23:57:53','2024-01-18 23:57:53'),(37,NULL,'지각','2024-01-18 23:57:57','2024-01-18 23:57:57'),(38,NULL,'반하','2024-01-18 23:58:20','2024-01-18 23:58:20'),(39,NULL,'계피','2024-01-18 23:58:25','2024-01-18 23:58:25'),(40,NULL,'총백','2024-01-18 23:58:39','2024-01-18 23:58:39'),(42,NULL,'박하','2024-01-19 22:45:58',NULL),(46,NULL,'인삼','2024-02-28 18:11:19','2024-02-28 18:11:19');
/*!40000 ALTER TABLE `medi_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medi_recipe`
--

DROP TABLE IF EXISTS `medi_recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medi_recipe` (
  `recipe_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '레시피 키 값',
  `recipe_nm` varchar(100) DEFAULT '이름 없음' COMMENT '레시피 이름',
  `comment` varchar(100) DEFAULT '추가 설명이 없습니다' COMMENT '레시피 설명',
  `update_date` datetime DEFAULT NULL COMMENT '레시피 수정 날짜',
  `regist_date` datetime DEFAULT NULL COMMENT '레시피 등록 날짜 ',
  PRIMARY KEY (`recipe_id`),
  UNIQUE KEY `medi_recipe_UN` (`recipe_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medi_recipe`
--

LOCK TABLES `medi_recipe` WRITE;
/*!40000 ALTER TABLE `medi_recipe` DISABLE KEYS */;
INSERT INTO `medi_recipe` VALUES (1,'대금음자','추가 설명이 없습니다',NULL,NULL),(32,'쌍화탕',NULL,'2024-02-28 18:42:59','2024-02-28 18:42:59'),(33,'십전대보탕',NULL,'2024-02-28 18:44:56','2024-02-28 18:44:56'),(34,'평위산',NULL,'2024-02-28 18:45:38','2024-02-28 18:45:38'),(35,'육미지황탕',NULL,'2024-02-28 18:46:19','2024-02-28 18:46:19'),(36,'보중익기탕',NULL,'2024-02-28 18:47:30','2024-02-28 18:47:30'),(37,'소청룡탕',NULL,'2024-02-28 18:48:20','2024-02-28 18:48:20'),(38,'오적산',NULL,'2024-02-28 18:50:33','2024-02-28 18:50:33'),(39,'소요산',NULL,'2024-02-28 18:51:29','2024-02-28 18:51:29');
/*!40000 ALTER TABLE `medi_recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medi_recipe_spec`
--

DROP TABLE IF EXISTS `medi_recipe_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medi_recipe_spec` (
  `spec_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '기본키 값 ',
  `recipe_id` bigint(20) NOT NULL,
  `material_id` bigint(20) NOT NULL COMMENT '재료 키값',
  `material_mount` float DEFAULT NULL COMMENT '재료 양',
  PRIMARY KEY (`spec_id`),
  KEY `medi_recipe_spec_FK` (`material_id`),
  KEY `medi_recipe_spec_FK_1` (`recipe_id`),
  CONSTRAINT `medi_recipe_spec_FK` FOREIGN KEY (`material_id`) REFERENCES `medi_material` (`material_id`),
  CONSTRAINT `medi_recipe_spec_FK_1` FOREIGN KEY (`recipe_id`) REFERENCES `medi_recipe` (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='레시피 상세항목';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medi_recipe_spec`
--

LOCK TABLES `medi_recipe_spec` WRITE;
/*!40000 ALTER TABLE `medi_recipe_spec` DISABLE KEYS */;
INSERT INTO `medi_recipe_spec` VALUES (1,1,1,12),(2,1,2,2.8),(3,1,3,2.8),(4,1,4,2.8),(5,1,5,3),(70,32,4,3),(71,32,5,3),(72,32,6,10),(73,32,12,4),(74,32,20,4),(75,32,21,4),(76,32,22,4),(77,32,23,3),(78,32,24,3),(79,33,4,4),(80,33,5,3),(81,33,6,4),(82,33,12,4),(83,33,14,4),(84,33,20,4),(85,33,21,4),(86,33,22,4),(87,33,23,4),(88,33,24,3),(89,33,25,4),(90,33,46,4),(91,34,1,5.6),(92,34,2,4),(93,34,3,8),(94,34,4,2.4),(95,34,5,3),(96,34,24,3),(97,35,20,16),(98,35,25,6),(99,35,26,8),(100,35,27,8),(101,35,28,6),(102,35,29,6),(103,36,1,2),(104,36,4,4),(105,36,12,6),(106,36,14,4),(107,36,15,2),(108,36,16,1.2),(109,36,17,1.2),(110,36,46,4),(111,37,6,6),(112,37,8,6),(113,37,30,6),(114,37,31,6),(115,37,32,4),(116,37,33,4),(117,37,34,4),(118,37,35,4),(119,38,1,4),(120,38,2,3.2),(121,38,3,8),(122,38,4,2.4),(123,38,5,3),(124,38,6,3.2),(125,38,7,2.8),(126,38,21,3.2),(127,38,22,2.8),(128,38,25,3.2),(129,38,30,4),(130,38,33,3.2),(131,38,36,3.2),(132,38,37,3.2),(133,38,38,2.8),(134,38,39,2.8),(135,38,40,2),(136,39,4,2),(137,39,5,3),(138,39,6,4),(139,39,14,4),(140,39,17,4),(141,39,18,4),(142,39,21,4),(143,39,25,4),(144,39,42,2);
/*!40000 ALTER TABLE `medi_recipe_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'uk_medicine'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-01 19:52:03
