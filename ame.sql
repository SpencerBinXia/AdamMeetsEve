-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: AdamMeetsEve
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `OwnerSSN` char(11) NOT NULL,
  `CardNumber` char(16) NOT NULL,
  `AcctNum` char(30) NOT NULL,
  `AcctCreationDate` date DEFAULT NULL,
  PRIMARY KEY (`OwnerSSN`,`CardNumber`,`AcctNum`),
  CONSTRAINT `Account_ibfk_1` FOREIGN KEY (`OwnerSSN`) REFERENCES `User` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES ('555-55-5555','349454276731232','23456','2012-09-07'),('555-55-5555','5186330464994532','12345','2013-10-07'),('666-66-6666','5192383525185287','34567','2013-09-23'),('777-77-7777','5144751168293870','45678','2014-05-28'),('888-88-8888','5167593514262698','56789','2014-04-22'),('999-99-9999','4482704287348312','67891','2011-10-07');
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Date`
--

DROP TABLE IF EXISTS `Date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Date` (
  `Profile1` char(20) NOT NULL,
  `Profile2` char(20) NOT NULL,
  `CustRep` char(11) DEFAULT NULL,
  `Date_Time` datetime NOT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `GeoLocation` varchar(100) DEFAULT NULL,
  `BookingFee` int(11) DEFAULT NULL,
  `Comments` varchar(30) DEFAULT NULL,
  `User1Rating` int(11) DEFAULT NULL,
  `User2Rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`Profile1`,`Profile2`,`Date_Time`),
  KEY `Profile2` (`Profile2`),
  KEY `CustRep` (`CustRep`),
  CONSTRAINT `Date_ibfk_1` FOREIGN KEY (`Profile1`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `Date_ibfk_2` FOREIGN KEY (`Profile2`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `Date_ibfk_3` FOREIGN KEY (`CustRep`) REFERENCES `Employee` (`SSN`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Date`
--

LOCK TABLES `Date` WRITE;
/*!40000 ALTER TABLE `Date` DISABLE KEYS */;
INSERT INTO `Date` VALUES ('Brenna_Berlin','DesiraeBerg','333-33-3333','2014-10-06 12:21:06','The Mall',NULL,36,'Comments Here',2,3),('Fletcher2013','VazquezFromAlajuela','333-33-3333','2014-10-06 04:30:52','Ruvos Restaurant',NULL,43,'The food was delicious!',3,1),('Isabelle2013','DesiraeBerg','222-22-2222','2014-10-04 21:39:42','Port Jeff Cinema',NULL,65,'Comments Here',4,5),('Isabelle2014','VazquezFromAlajuela','222-22-2222','2014-10-06 21:49:30','The Mall',NULL,91,'Comments Here',3,3),('VazquezFromAlajuela','Brenna_Berlin','444-44-4444','2014-10-06 05:34:04','Turkish Restaurant',NULL,69,'Comments Here',4,4),('VazquezFromAlajuela','DesiraeBerg','222-22-2222','2014-12-01 03:00:00','Port Harbor',NULL,81,'No Comment',4,4),('VazquezFromAlajuela','Isabelle2014','444-44-4444','2014-12-03 07:00:00','Port Jeff Cinema','Port Jefferson, NY',50,'Comments Here',3,2);
/*!40000 ALTER TABLE `Date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `SSN` char(11) NOT NULL,
  `Role` varchar(50) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `HourlyRate` int(11) DEFAULT NULL,
  PRIMARY KEY (`SSN`),
  CONSTRAINT `Employee_ibfk_1` FOREIGN KEY (`SSN`) REFERENCES `Person` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES ('111-11-1111','Manager','2014-10-04',200),('222-22-2222','CustRep','2014-10-04',150),('333-33-3333','CustRep','2014-10-04',100),('444-44-4444','CustRep','2014-10-04',75);
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Likes`
--

DROP TABLE IF EXISTS `Likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Likes` (
  `Liker` char(20) NOT NULL,
  `Likee` char(20) NOT NULL,
  `Date_Time` datetime NOT NULL,
  PRIMARY KEY (`Liker`,`Likee`,`Date_Time`),
  KEY `Likee` (`Likee`),
  CONSTRAINT `Likes_ibfk_1` FOREIGN KEY (`Liker`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `Likes_ibfk_2` FOREIGN KEY (`Likee`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Likes`
--

LOCK TABLES `Likes` WRITE;
/*!40000 ALTER TABLE `Likes` DISABLE KEYS */;
INSERT INTO `Likes` VALUES ('VazquezFromAlajuela','Brenna_Berlin','2014-10-06 21:13:02'),('Brenna_Berlin','DesiraeBerg','2014-10-05 05:05:08'),('Brenna_Berlin','DesiraeBerg','2014-10-05 11:02:05'),('Isabelle2013','DesiraeBerg','2014-10-06 23:06:12'),('Isabelle2014','DesiraeBerg','2014-10-07 21:04:09'),('DesiraeBerg','Isabelle2014','2014-12-01 01:00:00'),('Fletcher2013','VazquezFromAlajuela','2014-10-06 03:46:48'),('Isabelle2013','VazquezFromAlajuela','2014-10-08 09:15:49'),('Isabelle2014','VazquezFromAlajuela','2014-10-06 05:28:39');
/*!40000 ALTER TABLE `Likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `SSN` char(11) NOT NULL,
  `Password` char(20) DEFAULT NULL,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Street` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `Zipcode` int(11) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Telephone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES ('111-11-1111','111@11','Veronica','Alvarado','45 Rockefeller Plaza','New York','New York',10111,'Fusce@velitPellentesque.net','(612) 506-2244'),('222-22-2222','222@22','Bo','Osborne','45 Rockefeller Plaza','New York','New York',10111,'mattis.Integer.eu@elit.org','(592) 765-8277'),('333-33-3333','333@33','Hashim','Ross','350 5th Ave','New York','New York',10118,'vulputate@Curae.co.uk','(276) 634-6949'),('444-44-4444','444@44','Shaine','Terrell','350 5th Ave','New York','New York',10118,'tincidunt.nibh@risus.com','(600) 803-9508'),('555-55-5555','555@55','Isabelle','Odonnell','Schomburg Apartments, 350 Circle Road','Stony Brook','New York',11790,'magna.tellus.faucibus@amet.edu','(934) 241-3862'),('666-66-6666','666@66','Fletcher','Trujillo','700 Health Sciences Dr','Stony Brook','New York',11790,'elementum.dui.quis@utlacus.net','(990) 760-1480'),('777-77-7777','777@77','Malachi','Vazquez','700 Health Sciences Dr','Stony Brook','New York',11790,'tellus.lorem.eu@atlacus.org','(226) 193-8257'),('888-88-8888','888@88','Brenna','Cross','Schomburg Apartments, 350 Circle Road','Stony Brook','New York',11790,'sed.turpis@vehiculaaliquet.com','(968) 409-7641'),('999-99-9999','999@99','Desirae','Berg','116th St & Broadway','New York','New York',10027,'vitae@magnased.com','(237) 321-3189');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profile`
--

DROP TABLE IF EXISTS `Profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profile` (
  `ProfileID` char(20) NOT NULL,
  `OwnerSSN` char(11) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `DatingAgeRangeStart` int(11) DEFAULT NULL,
  `DatingAgeRangeEnd` int(11) DEFAULT NULL,
  `DatinGeoRange` int(11) DEFAULT NULL,
  `M_F` varchar(10) DEFAULT NULL,
  `Hobbies` varchar(1000) DEFAULT NULL,
  `Height` double DEFAULT NULL,
  `Weight` int(11) DEFAULT NULL,
  `HairColor` varchar(20) DEFAULT NULL,
  `CreationDate` datetime NOT NULL,
  `LastModDate` datetime NOT NULL,
  `GeoLocation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ProfileID`),
  KEY `OwnerSSN` (`OwnerSSN`),
  CONSTRAINT `Profile_ibfk_1` FOREIGN KEY (`OwnerSSN`) REFERENCES `User` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profile`
--

LOCK TABLES `Profile` WRITE;
/*!40000 ALTER TABLE `Profile` DISABLE KEYS */;
INSERT INTO `Profile` VALUES ('Brenna_Berlin','888-88-8888',19,19,21,8,'Female','Dance, Acting',6,180,'Blonde','2014-10-04 20:20:55','2014-10-07 12:21:58','Stony Brook, NY'),('DesiraeBerg','999-99-9999',20,17,25,5,'Male','Water Sports, Football',5.6,200,'Red','2014-10-04 19:13:18','2014-10-04 15:54:48','Stony Brook, NY'),('Fletcher2013','666-66-6666',25,20,28,18,'Female','Reading, Basketball',5.6,150,'Brown','2014-10-04 19:21:37','2014-10-07 01:25:55','Port Jefferson, NY'),('Fletcher_Trujillo','666-66-6666',23,19,30,8,'Female','Shopping, Volleyball',5.6,150,'Brown','2014-10-04 18:26:49','2014-10-05 00:42:03','Port Jefferson, NY'),('Isabelle2013','555-55-5555',22,20,22,29,'Female','Shopping, Dance, Mountain Claiming',5.7,120,'Black','2014-10-04 00:37:12','2014-10-04 17:08:38','Port Jefferson, NY'),('Isabelle2014','555-55-5555',22,20,25,5,'Female','Shopping, Cooking',5.7,110,'Black','2014-10-04 22:43:25','2014-10-09 11:51:19','Port Jefferson, NY'),('VazquezFromAlajuela','777-77-7777',26,20,28,15,'Male','Hunting,Running',5.7,170,'Black','2014-10-04 17:13:30','2014-10-07 04:16:43','Port Jefferson, NY');
/*!40000 ALTER TABLE `Profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Referral`
--

DROP TABLE IF EXISTS `Referral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Referral` (
  `ProfileA` char(20) NOT NULL,
  `ProfileB` char(20) NOT NULL,
  `ProfileC` char(20) NOT NULL,
  `Date_Time` datetime NOT NULL,
  PRIMARY KEY (`ProfileA`,`ProfileB`,`ProfileC`,`Date_Time`),
  KEY `ProfileB` (`ProfileB`),
  KEY `ProfileC` (`ProfileC`),
  CONSTRAINT `Referral_ibfk_1` FOREIGN KEY (`ProfileA`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `Referral_ibfk_2` FOREIGN KEY (`ProfileB`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `Referral_ibfk_3` FOREIGN KEY (`ProfileC`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Referral`
--

LOCK TABLES `Referral` WRITE;
/*!40000 ALTER TABLE `Referral` DISABLE KEYS */;
INSERT INTO `Referral` VALUES ('Isabelle2014','Fletcher2013','VazquezFromAlajuela','2014-10-07 09:56:08'),('Brenna_Berlin','Fletcher_Trujillo','Isabelle2014','2014-12-09 15:07:44');
/*!40000 ALTER TABLE `Referral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SuggestedBy`
--

DROP TABLE IF EXISTS `SuggestedBy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SuggestedBy` (
  `CustRep` char(11) NOT NULL,
  `Profile1` char(20) NOT NULL,
  `Profile2` char(20) NOT NULL,
  `Date_Time` datetime NOT NULL,
  PRIMARY KEY (`CustRep`,`Profile1`,`Profile2`,`Date_Time`),
  KEY `Profile1` (`Profile1`),
  KEY `Profile2` (`Profile2`),
  CONSTRAINT `SuggestedBy_ibfk_1` FOREIGN KEY (`Profile1`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `SuggestedBy_ibfk_2` FOREIGN KEY (`Profile2`) REFERENCES `Profile` (`ProfileID`) ON DELETE CASCADE,
  CONSTRAINT `SuggestedBy_ibfk_3` FOREIGN KEY (`CustRep`) REFERENCES `Employee` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SuggestedBy`
--

LOCK TABLES `SuggestedBy` WRITE;
/*!40000 ALTER TABLE `SuggestedBy` DISABLE KEYS */;
INSERT INTO `SuggestedBy` VALUES ('222-22-2222','Fletcher2013','DesiraeBerg','2014-10-05 15:07:44');
/*!40000 ALTER TABLE `SuggestedBy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `SSN` char(11) NOT NULL,
  `PPP` varchar(50) DEFAULT NULL,
  `Rating` int(11) DEFAULT NULL,
  `DateOfLastAct` datetime DEFAULT NULL,
  PRIMARY KEY (`SSN`),
  CONSTRAINT `User_ibfk_1` FOREIGN KEY (`SSN`) REFERENCES `Person` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('555-55-5555','Super-User',3,'2014-10-07 05:53:13'),('666-66-6666','Good-User',3,'2014-10-05 05:27:28'),('777-77-7777','Good-User',4,'2014-10-08 22:37:07'),('888-88-8888','User-User',3,'2014-10-04 09:10:12'),('999-99-9999','User-User',2,'2014-10-05 18:28:02');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-19 17:01:32
