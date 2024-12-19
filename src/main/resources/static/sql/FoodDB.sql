-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fooddb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `UserID` int NOT NULL,
  `FoodID` int NOT NULL,
  `Quantity` int NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`UserID`,`FoodID`),
  KEY `cart_ibfk_2` (`FoodID`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`FoodID`) REFERENCES `food` (`FoodID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,3,1,15.00,'炸酱面'),(3,11,5,12.00,'特色炒饭');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `FoodID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Available` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`FoodID`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'皮蛋瘦肉粥','香气扑鼻，口感细腻，温暖又滋补！',25.60,'1.jpg',1),(2,'清炒时蔬','色彩鲜艳，营养丰富，保持食材的原汁原味。',18.00,'2.jpg',1),(3,'炸酱面','面条劲道，酱料浓郁，带着一丝家的味道。',15.00,'3.jpg',1),(4,'肉丝茄子','软嫩入味，色香味俱佳，令人回味无穷。',10.00,'4.jpg',1),(5,'西红柿炒鸡蛋','经典家常，酸甜可口，清爽又下饭。',12.00,'5.jpg',1),(6,'香油抄手','皮薄馅多，香滑入味，回味无穷。',13.00,'6.jpg',1),(7,'酸豆角盖饭','酸爽开胃，配上米饭，口感层次丰富。',14.00,'7.jpg',1),(8,'创意炒饭','米粒松散，搭配多样食材，色香味俱全。',24.00,'8.jpg',1),(9,'重庆小面','麻辣鲜香，面条滑润，挑战你的味蕾。',9.00,'9.jpg',1),(10,'米粉汤','清爽的汤底，柔软的米粉，吃上一口满是温暖。',8.00,'10.jpg',1),(11,'特色炒饭','香气扑鼻，食材丰富，满足你对美味的所有期待。',12.00,'11.jpg',1),(12,'木须肉盖饭','鲜美的猪肉丝与鸡蛋的完美结合，味道浓郁。',13.00,'12.jpg',1),(13,'西红柿打卤面','汤汁浓郁，酸爽的西红柿，搭配劲道的面条。',20.00,'13.jpg',1),(14,'拉面','面条韧性十足，汤头鲜美，滋味独特。',17.00,'14.jpg',1),(15,'刀削面','手工刀削的面条，质地坚韧，汤汁浓郁。',13.00,'15.jpg',1),(16,'土豆丝盖饭','金黄酥脆的土豆丝，搭配白米饭，口感独特。',25.00,'16.jpg',1);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(100) DEFAULT NULL,
  `FoodName` varchar(100) DEFAULT NULL,
  `Quantity` int NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `OrderDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `Status` varchar(50) DEFAULT '制作中',
  `UserID` int DEFAULT NULL,
  `FoodID` int DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `orders_ibfk_1` (`UserID`),
  KEY `orders_ibfk_2` (`FoodID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`FoodID`) REFERENCES `food` (`FoodID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,'zhangsan','宫保鸡丁',1,18.00,'2024-12-14 16:41:37','已完成',1,3),(3,'liSi','麻婆豆腐',3,15.00,'2024-12-14 16:41:37','已完成',1,4),(4,'zhangsan','鸭血粉丝汤',2,40.00,'2024-12-17 10:56:28','已完成',1,5),(5,NULL,'清炒时蔬',2,18.00,'2024-12-17 12:26:25','已完成',1,2),(6,NULL,'香油抄手',2,13.00,'2024-12-17 12:26:25','已完成',1,6),(7,NULL,'酸豆角盖饭',1,14.00,'2024-12-17 12:26:25','已完成',1,7),(8,NULL,'清炒时蔬',1,18.00,'2024-12-17 12:26:49','已完成',1,2),(9,NULL,'木须肉盖饭',3,13.00,'2024-12-17 12:26:49','已完成',1,12),(10,NULL,'皮蛋瘦肉粥',3,25.50,'2024-12-17 12:28:11','已完成',1,1),(11,NULL,'香油抄手',3,13.00,'2024-12-17 12:28:11','已完成',1,6),(12,NULL,'酸豆角盖饭',2,14.00,'2024-12-17 12:28:11','已完成',1,7),(13,'wwww','特色炒饭A',1,12.00,'2024-12-17 12:28:11','已完成',1,11),(14,NULL,'土豆丝盖饭',1,25.00,'2024-12-17 12:28:11','已完成',1,16),(15,NULL,'肉丝茄子',3,10.00,'2024-12-17 12:31:50','已完成',1,4),(16,NULL,'酸豆角盖饭',3,14.00,'2024-12-17 12:31:50','已完成',1,7),(17,NULL,'创意炒饭',2,24.00,'2024-12-17 12:31:50','已完成',1,8),(18,NULL,'米粉汤',3,8.00,'2024-12-17 12:31:50','已完成',1,10),(19,NULL,'炸酱面',3,15.00,'2024-12-17 12:38:54','已完成',1,3),(20,NULL,'肉丝茄子',3,10.00,'2024-12-17 12:38:54','已完成',1,4),(21,NULL,'酸豆角盖饭',1,14.00,'2024-12-17 12:38:54','已完成',1,7),(22,NULL,'米粉汤',1,8.00,'2024-12-17 12:38:54','已完成',1,10),(23,NULL,'清炒时蔬',3,18.00,'2024-12-17 14:33:11','已完成',1,2),(25,NULL,'清炒时蔬',1,18.00,'2024-12-17 15:14:21','已完成',1,2),(27,NULL,'炸酱面',2,15.00,'2024-12-17 20:47:30','制作中',1,3),(28,NULL,'清炒时蔬',2,18.00,'2024-12-17 20:49:34','已完成',1,2),(29,NULL,'炸酱面',1,15.00,'2024-12-17 20:49:34','已完成',1,3),(30,NULL,'清炒时蔬',1,18.00,'2024-12-17 20:49:55','已完成',1,2),(31,NULL,'炸酱面',1,15.00,'2024-12-17 20:49:55','制作中',1,3),(32,NULL,'炸酱面',2,15.00,'2024-12-17 21:19:27','制作中',1,3),(33,NULL,'炸酱面',1,15.00,'2024-12-17 22:14:33','已完成',8,3),(34,NULL,'清炒时蔬',1,18.00,'2024-12-17 23:14:55','已完成',8,2),(35,NULL,'肉丝茄子',1,10.00,'2024-12-17 23:14:55','制作中',8,4),(36,NULL,'酸豆角盖饭',2,14.00,'2024-12-17 23:22:32','制作中',8,7);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Role` varchar(20) DEFAULT '客户',
  `CreatedAt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'zhangsan','123456','zhangsan@example.com','13812345679','客户','2024-12-14 20:52:38'),(3,'admin','admin','admin@example.com','13700000000','管理员','2024-12-14 20:52:38'),(7,'liuwang','wdw','aaaaa233@gmail.com','123213213','客户','2024-12-17 22:05:07'),(8,'zlk','317418','12321323@qq.com','12823782368','客户','2024-12-17 22:14:14');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-18  8:15:08
