-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.31-0+wheezy1

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Denis','Ritchi'),(2,'Brian','Kernigan'),(3,'Suzanne','Collins'),(4,'Oscar','Wilde'),(5,'Smitrii','Ivnovich');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Unix for Professionals',1321),(2,'Windows sucks',2),(3,'Dorian Grey',100),(4,'Hunger Games',10),(5,'Mockingjay',20),(6,'Catching Fire',20),(7,'451',20);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_tags`
--

DROP TABLE IF EXISTS `books_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_tags` (
  `id_book` int(11) NOT NULL,
  `id_tag` int(11) NOT NULL,
  KEY `id_book` (`id_book`),
  KEY `id_tag` (`id_tag`),
  CONSTRAINT `books_tags_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `books_tags_ibfk_2` FOREIGN KEY (`id_tag`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_tags`
--

LOCK TABLES `books_tags` WRITE;
/*!40000 ALTER TABLE `books_tags` DISABLE KEYS */;
INSERT INTO `books_tags` VALUES (2,1),(2,2),(2,3),(3,3),(3,2),(4,2),(4,1),(5,1),(5,3),(6,3),(7,3),(1,1),(1,5),(1,3);
/*!40000 ALTER TABLE `books_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id_comment` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `id_book` (`id_book`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (18,3,1,'2013-10-17 08:17:44','GREAT BOOK!!!!!!!!!!'),(19,4,1,'2013-10-17 08:17:48','GREAT BOOK!!!!!!!!!!'),(21,3,1,'2013-10-17 08:17:51','GREAT BOOK!!!!!!!!!!'),(22,2,1,'2013-10-17 08:17:52','GREAT BOOK!!!!!!!!!!'),(25,2,1,'2013-10-17 08:17:55','GREAT BOOK!!!!!!!!!!'),(26,3,1,'2013-10-17 08:17:56','GREAT BOOK!!!!!!!!!!'),(27,4,1,'2013-10-17 08:17:57','GREAT BOOK!!!!!!!!!!'),(29,3,1,'2013-10-17 08:18:00','GREAT BOOK!!!!!!!!!!'),(30,2,1,'2013-10-17 08:18:01','GREAT BOOK!!!!!!!!!!'),(41,5,1,'2013-10-21 08:11:55','111'),(44,1,1,'2013-10-21 04:00:00','1111');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Horrorr'),(2,'Programming'),(3,'Admin'),(4,'Fantasy');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_books`
--

DROP TABLE IF EXISTS `genre_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_genre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_book` (`id_book`),
  KEY `id_genre` (`id_genre`),
  CONSTRAINT `genre_books_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `genre_books_ibfk_2` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_books`
--

LOCK TABLES `genre_books` WRITE;
/*!40000 ALTER TABLE `genre_books` DISABLE KEYS */;
INSERT INTO `genre_books` VALUES (3,2,2),(4,3,2),(5,4,2),(6,5,2),(7,6,2),(8,7,2),(170,1,1);
/*!40000 ALTER TABLE `genre_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_book` (`id_book`),
  CONSTRAINT `images_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (13,1,'../images/unix_1.jpg'),(14,1,'../images/unix_2.jpg'),(15,2,'../images/win_1.jpg'),(16,2,'../images/win_2.jpg'),(17,3,'../images/dorian_1.jpg'),(18,3,'../images/dorian_2.jpg'),(19,3,'../images/dorian_3.jpg'),(20,4,'../images/games_1.jpg'),(21,4,'../images/games_2.jpg'),(22,4,'../images/games_3.jpg'),(24,2,'../images/win_3.jpg'),(25,1,'../images/unix_3.jpg'),(26,5,'../images/coika_1.jpg'),(27,5,'../images/coika_2.jpg'),(28,5,'../images/coika_3.jpg'),(29,6,'../images/plamya_1.jpg'),(30,6,'../images/plamya_2.jpg'),(31,6,'../images/plamya_3.jpg'),(32,7,'../images/451_1.jpg'),(33,7,'../images/451_2.jpg'),(34,7,'../images/451_3.jpg');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `library` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_author` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_book` (`id_book`),
  KEY `id_author` (`id_author`),
  CONSTRAINT `library_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `library_ibfk_2` FOREIGN KEY (`id_author`) REFERENCES `authors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `library`
--

LOCK TABLES `library` WRITE;
/*!40000 ALTER TABLE `library` DISABLE KEYS */;
INSERT INTO `library` VALUES (2,2,2),(4,4,3),(122,3,2),(123,3,1),(148,1,1);
/*!40000 ALTER TABLE `library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_book` (`id_book`),
  CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,1,5),(2,1,5),(3,1,5),(4,1,4),(5,2,4),(6,2,4),(7,2,4);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'MANY MANY YEARS AGO...'),(2,'SITE WAS CREATING'),(12,'wowoww'),(13,'mynme');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'Cool'),(2,'Bad'),(3,'Awesome'),(5,'rter');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taked_books`
--

DROP TABLE IF EXISTS `taked_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taked_books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_book` (`id_book`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `taked_books_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `taked_books_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `taked_books_ibfk_3` FOREIGN KEY (`id_book`) REFERENCES `books` (`id`),
  CONSTRAINT `taked_books_ibfk_4` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taked_books`
--

LOCK TABLES `taked_books` WRITE;
/*!40000 ALTER TABLE `taked_books` DISABLE KEYS */;
INSERT INTO `taked_books` VALUES (1,1,1,'2013-09-30 06:35:18'),(2,1,2,'2012-08-09 02:22:22'),(3,1,1,'2013-10-23 07:55:31'),(4,1,1,'2013-10-23 07:55:53'),(5,1,1,'2013-10-23 07:57:31'),(6,1,1,'2013-10-23 07:57:37'),(7,1,1,'2013-10-23 07:58:00'),(8,1,1,'2013-10-23 07:58:22'),(9,1,1,'2013-10-23 07:58:54'),(10,1,1,'2013-10-23 07:59:14'),(11,1,1,'2013-10-23 07:59:44'),(12,1,1,'2013-10-23 07:59:46'),(13,1,1,'2013-10-23 08:00:00'),(14,1,1,'2013-10-23 08:00:10'),(15,1,1,'2013-10-23 08:00:24'),(16,1,1,'2013-10-23 08:00:38'),(17,1,1,'2013-10-23 08:00:39'),(18,1,1,'2013-10-23 08:00:39'),(19,1,1,'2013-10-23 08:00:40'),(20,1,1,'2013-10-23 08:00:40'),(21,2,1,'2013-10-23 08:43:23'),(22,2,1,'2013-10-23 08:43:29'),(23,2,1,'2013-10-23 09:07:56'),(24,2,1,'2013-10-23 10:38:33'),(25,2,1,'2013-10-23 10:38:58'),(26,2,1,'2013-10-23 10:39:08'),(27,2,1,'2013-10-23 10:39:08'),(28,2,1,'2013-10-23 10:39:09'),(29,2,1,'2013-10-23 10:39:09'),(30,2,1,'2013-10-23 10:39:10'),(31,2,1,'2013-10-23 10:39:10');
/*!40000 ALTER TABLE `taked_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `privileged` int(11) DEFAULT NULL,
  `hash_pass` varchar(32) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Denis','Ritchi',0,'8b3f75b14bbf49fe25052992f06b07b9','mailinf@example.com','WTF?'),(2,'Ken','Thompson',1,'ddd1d18bdd503c4d885028262b1ed08e','mailinf2@example.com','Unix HACKER'),(5,'gfg','hgh',0,'373633ec8af28e5afaf6e5f4fd87469b','hg@mail.ru','hgh'),(6,'gfgh','hhhhh',0,'c1181aacf646b97f0a0a782db351a405','gfgf@mail.ru','hhh'),(7,'hhh','hhhh',0,'a3aca2964e72000eea4c56cb341002a4','gfg@mail.ru','hhh'),(8,'second_','second_',0,'8b3f75b14bbf49fe25052992f06b07b9','mailinf@example.com','copy user for try order'),(9,'dima','Osipov',0,'b706835de79a2b4e80506f582af3676a','hghh@mail.ru','net'),(10,'Dima','Krav',0,'c352bcc743777b5e5adc96bf204ecf15','1123@mial.ru','12312'),(11,'Meaw','Cat',1,'d077f244def8a70e5ea758bd8352fcd8','admin_cat@example.org','This is real cool cat!;)'),(12,'What','Dog',0,'06d80eb0c50b49a509b49f2424e8c805','dog@example.org','Just doog !;)');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-24 23:47:27
