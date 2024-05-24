-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (arm64)
--
-- Host: 127.0.0.1    Database: zeraki_language_learning
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_pk2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Kiswahili lessons','Kiswahili lessons');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `lesson` int DEFAULT NULL,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `exercise_pk2` (`id`),
  KEY `exercise_lesson_id_fk` (`lesson`),
  CONSTRAINT `exercise_lesson_id_fk` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Kitenzi kivumilishi','Kitenzi kivumilishi',NULL,NULL),(2,'Kitenzi kivumilishi','Kitenzi kivumilishi',NULL,NULL),(3,'Kitenzi kivumilishi','Kitenzi kivumilishi',NULL,NULL),(4,'Kitenzi Kisizitishi','Kitenzi Kisizitishi',NULL,NULL),(5,'Kitenzi Kisizitishi','Kitenzi Kisizitishi',1,NULL),(6,'Nomino ni nini','Nomino ni nini',2,NULL),(7,'Aina za nomino','Aina za nomino',2,NULL);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `category` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lesson_pk2` (`id`),
  KEY `lesson_category_id_fk` (`category`),
  CONSTRAINT `lesson_category_id_fk` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'Vitenzi','Vitenzi',NULL,1),(2,'Nomino','Nomino za kiswahili',NULL,1);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress_exercise`
--

DROP TABLE IF EXISTS `progress_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progress_exercise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` enum('PENDING','STARTED','COMPLETED') DEFAULT 'PENDING',
  `started_date` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `user_progress` int DEFAULT NULL,
  `exercise` int DEFAULT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `progress_exercise_pk2` (`id`),
  KEY `progress_exercise_exercise_id_fk` (`exercise`),
  KEY `progress_exercise_user_progress_id_fk` (`user_progress`),
  CONSTRAINT `progress_exercise_exercise_id_fk` FOREIGN KEY (`exercise`) REFERENCES `exercise` (`id`),
  CONSTRAINT `progress_exercise_user_progress_id_fk` FOREIGN KEY (`user_progress`) REFERENCES `user_progress` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress_exercise`
--

LOCK TABLES `progress_exercise` WRITE;
/*!40000 ALTER TABLE `progress_exercise` DISABLE KEYS */;
INSERT INTO `progress_exercise` VALUES (1,'STARTED',NULL,NULL,1,NULL,NULL),(2,'STARTED',NULL,NULL,2,NULL,NULL),(4,'STARTED',NULL,NULL,4,NULL,NULL),(6,'STARTED',NULL,NULL,6,NULL,NULL),(7,'STARTED',NULL,NULL,7,NULL,NULL),(8,'COMPLETED','2024-05-24 07:02:32','2024-05-24 07:03:11',8,NULL,80),(9,'COMPLETED','2024-05-24 07:46:34','2024-05-24 07:46:52',9,NULL,10),(10,'COMPLETED',NULL,'2024-05-24 07:47:06',9,NULL,10);
/*!40000 ALTER TABLE `progress_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_pk2` (`id`),
  UNIQUE KEY `user_pk3` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'string','string','string','2024-05-23 22:07:43','$2a$10$BMepUuZd9LD36mKauwafw.qgT6BRsXuP.SKcXXvu4qqnQUPFVamQi'),(2,'Paul','Obiero','paulobiero147@gmail.com','2024-05-24 01:25:55','$2a$10$4ayVGuE/c8zc/VNO.GWcZeXHK8TskySjtFyei.RqL3Vw4D36Unoje');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_progress`
--

DROP TABLE IF EXISTS `user_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_progress` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int DEFAULT NULL,
  `lesson` int DEFAULT NULL,
  `status` enum('PENDING','COMPLETED') DEFAULT 'PENDING',
  `date_started` datetime DEFAULT NULL,
  `date_completed` datetime DEFAULT NULL,
  `score` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_progress_pk2` (`id`),
  KEY `user_progress_lesson_id_fk` (`lesson`),
  KEY `user_progress_user_id_fk` (`user`),
  CONSTRAINT `user_progress_lesson_id_fk` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `user_progress_user_id_fk` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_progress`
--

LOCK TABLES `user_progress` WRITE;
/*!40000 ALTER TABLE `user_progress` DISABLE KEYS */;
INSERT INTO `user_progress` VALUES (1,NULL,NULL,NULL,'2024-05-24 06:42:25',NULL,NULL),(2,NULL,NULL,'PENDING','2024-05-24 06:44:59',NULL,NULL),(4,NULL,NULL,'PENDING','2024-05-24 06:51:23',NULL,NULL),(6,NULL,NULL,'PENDING','2024-05-24 06:57:23',NULL,NULL),(7,1,1,'PENDING','2024-05-24 07:00:11',NULL,NULL),(8,1,1,'COMPLETED','2024-05-24 07:02:05','2024-05-24 07:03:41',NULL),(9,1,2,'COMPLETED','2024-05-24 07:45:07','2024-05-24 07:47:06',NULL);
/*!40000 ALTER TABLE `user_progress` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-24  8:14:33
