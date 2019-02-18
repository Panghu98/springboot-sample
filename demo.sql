-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: db_library
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Sys_Role`
--

DROP TABLE IF EXISTS `Sys_Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sys_Role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sys_Role`
--

LOCK TABLES `Sys_Role` WRITE;
/*!40000 ALTER TABLE `Sys_Role` DISABLE KEYS */;
INSERT INTO `Sys_Role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `Sys_Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sys_User`
--

DROP TABLE IF EXISTS `Sys_User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sys_User` (
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` int(11) NOT NULL,
  `id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sys_User`
--

LOCK TABLES `Sys_User` WRITE;
/*!40000 ALTER TABLE `Sys_User` DISABLE KEYS */;
INSERT INTO `Sys_User` VALUES ('abel','abel',2,''),('admin','admin',1,'');
/*!40000 ALTER TABLE `Sys_User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sys_permission`
--

DROP TABLE IF EXISTS `Sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `url` varchar(200) NOT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sys_permission`
--

LOCK TABLES `Sys_permission` WRITE;
/*!40000 ALTER TABLE `Sys_permission` DISABLE KEYS */;
INSERT INTO `Sys_permission` VALUES (1,'ROLE_HOME','home','/',NULL),(2,'ROLE_ADMIN','ABel','/admin',NULL);
/*!40000 ALTER TABLE `Sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sys_permission_role`
--

DROP TABLE IF EXISTS `Sys_permission_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sys_permission_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `permission_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sys_permission_role`
--

LOCK TABLES `Sys_permission_role` WRITE;
/*!40000 ALTER TABLE `Sys_permission_role` DISABLE KEYS */;
INSERT INTO `Sys_permission_role` VALUES (1,1,1),(2,1,2),(3,2,1);
/*!40000 ALTER TABLE `Sys_permission_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sys_role_user`
--

DROP TABLE IF EXISTS `Sys_role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sys_role_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sys_user_id` bigint(20) unsigned NOT NULL,
  `sys_role_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sys_role_user`
--

LOCK TABLES `Sys_role_user` WRITE;
/*!40000 ALTER TABLE `Sys_role_user` DISABLE KEYS */;
INSERT INTO `Sys_role_user` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `Sys_role_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-18 20:06:30
