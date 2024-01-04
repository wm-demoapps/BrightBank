-- MySQL dump 10.13  Distrib 5.6.51, for Linux (x86_64)
--
-- Host: localhost    Database: BrightBankDB
-- ------------------------------------------------------
-- Server version	5.6.51

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
-- Table structure for table `ListTransaction`
--

DROP TABLE IF EXISTS `ListTransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListTransaction` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `sourceType` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ListTransaction`
--

LOCK TABLES `ListTransaction` WRITE;
/*!40000 ALTER TABLE `ListTransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `ListTransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ListTransactions`
--

DROP TABLE IF EXISTS `ListTransactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListTransactions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `transactiontype` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ListTransactions`
--

LOCK TABLES `ListTransactions` WRITE;
/*!40000 ALTER TABLE `ListTransactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `ListTransactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MERCHANT_DETAILS`
--

DROP TABLE IF EXISTS `MERCHANT_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MERCHANT_DETAILS` (
  `MERCHANT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MERCHANT_NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CATEGORY` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MERCHANT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MERCHANT_DETAILS`
--

LOCK TABLES `MERCHANT_DETAILS` WRITE;
/*!40000 ALTER TABLE `MERCHANT_DETAILS` DISABLE KEYS */;
INSERT INTO `MERCHANT_DETAILS` VALUES (1,'Vintage Vision','Household'),(2,'Decor My Way','Household'),(3,'Light Me Up','Household'),(4,'Decor Me','Household'),(5,'Royal Wood','Household'),(6,'Converse','Clothing'),(7,'Trend Clothing','Clothing'),(8,'Little Locust','Clothing'),(9,'Hayden & McKay','Clothing'),(10,'Jam Collective','Clothing'),(11,'Personal','Personal'),(12,'First-Choice Shippers','Transportation'),(13,'Secure Logistics','Transportation'),(14,'Ninety-Nine Express','Transportation'),(15,'FedEx Freight','Transportation'),(16,'Personal Loan','Loans'),(17,'Education Loan','Loans'),(18,'Vehicle Loan','Loans'),(19,'Flexi Loan','Loans'),(20,'Home Loan','Loans'),(21,'Regular','Savings'),(22,'Student Savings','Savings'),(23,'Money Market','Savings'),(24,'High-Yield','Savings'),(25,'Clubur','Entertainment'),(26,'Dramaly','Entertainment'),(27,'FictionUp','Entertainment'),(28,'RicherVoice','Entertainment'),(29,'Evyleen','Entertainment'),(30,'WishExtreme','Entertainment');
/*!40000 ALTER TABLE `MERCHANT_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_preferences`
--

DROP TABLE IF EXISTS `account_preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_preferences` (
  `account_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `spend_limit` int(11) DEFAULT NULL,
  `allow_online_transactions` bit(1) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_preferences`
--

LOCK TABLES `account_preferences` WRITE;
/*!40000 ALTER TABLE `account_preferences` DISABLE KEYS */;
INSERT INTO `account_preferences` VALUES ('110011063175675918',1200,'');
/*!40000 ALTER TABLE `account_preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cssproperty`
--

DROP TABLE IF EXISTS `cssproperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cssproperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cssvariable` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cssproperty`
--

LOCK TABLES `cssproperty` WRITE;
/*!40000 ALTER TABLE `cssproperty` DISABLE KEYS */;
INSERT INTO `cssproperty` VALUES (1,'--brand-primary','Primary'),(2,'--brand-primary-2','Primary-2'),(3,'--brand-secondary','Secondary'),(4,'--brand-secondary-2','secondary 2'),(5,'--brand-danger','Danger'),(6,'--brand-danger-2','Danger-2'),(7,'--btn-gradient-1','Button Primary gradient stopper 1'),(8,'--btn-gradient-2','button primary gradient stopper 2'),(9,'--brand-tertiary','Tertiary'),(10,'--brand-info','Info'),(11,'--info-bg-gradient','Info Background Gradient'),(12,'--active-bg-gradient','Active Background Gradient'),(13,'--text-color-2','Text Color 2'),(14,'--text-muted','Text muted'),(15,'--bg-highlight','Background Highlight'),(16,'--active-text-gradient','Active Text Gradient'),(17,'--active-bg-gradient-o','Active Background Gradient Opacity'),(18,'--spl-bg-stopper-1','Special Background Stopper 1'),(19,'--spl-bg-stopper-2','Special Background Stopper 2'),(20,'--special-bg-text','Special Background Text'),(21,'--spl-label-border','Special border'),(22,'--border-color-3','Border color 3'),(23,'--left-panel-link-active-color','Left Panel Link Active Color'),(24,'--left-panel-icon-color','Left panel icon color'),(25,'--left-panel-icon-active-color','left panel icon active color'),(26,'--left-panel-link-color','left panel link color'),(27,'--primary-text-gradient','Primary text gradient'),(28,'--btn-border-radius-base','Button border radius'),(29,'--border-radius-base','Border radius base'),(30,'--left-panel-link-active-bg','Left panel link active background'),(31,'--btn-secondary-text-color','secondary button text color'),(32,'--brand-primary-o','brand primary with opacity'),(33,'--brand-primary-o-2','brand primary 2 with opacity'),(34,'--left-panel-link-border','Left panel link border color'),(35,'--left-panel-link-active-indicator','Left panel link active indicator color'),(36,'--font-weight-base','Font Family with base weight'),(37,'--font-weight-medium','Font Family with weight medium'),(38,'--font-weight-semibold','Font Family with weight semibold'),(39,'New','New');
/*!40000 ALTER TABLE `cssproperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goal_form_fields`
--

DROP TABLE IF EXISTS `goal_form_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goal_form_fields` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goal_form_fields`
--

LOCK TABLES `goal_form_fields` WRITE;
/*!40000 ALTER TABLE `goal_form_fields` DISABLE KEYS */;
INSERT INTO `goal_form_fields` VALUES (7,'Goal Name','text',''),(8,'Goal Amount','double',''),(9,'Goal Time','double',''),(10,'Saving Frequency','text',''),(11,'Recurring Debit Day','date',''),(12,'Recurring Debit Account','double',''),(21,'Is Autodebit Enabled','boolean',''),(24,'Description','text',NULL),(34,'Goal Time','Double',''),(35,'Goal Time','Double',''),(36,'Goal Time','Double',''),(37,'Goal Time','Double',''),(38,'Goal Time','Double',''),(39,'Goal Time','Double',''),(40,'Goal Time','Double','');
/*!40000 ALTER TABLE `goal_form_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goal_transactions`
--

DROP TABLE IF EXISTS `goal_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goal_transactions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `goal_id` int(11) DEFAULT NULL,
  `paid_on` timestamp NULL DEFAULT NULL,
  `debited_account_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_wealth_goals_TO_goal_UISCH` (`goal_id`),
  CONSTRAINT `FK_wealth_goals_TO_goal_UISCH` FOREIGN KEY (`goal_id`) REFERENCES `wealth_goals` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goal_transactions`
--

LOCK TABLES `goal_transactions` WRITE;
/*!40000 ALTER TABLE `goal_transactions` DISABLE KEYS */;
INSERT INTO `goal_transactions` VALUES (1,1,'2023-03-01 06:57:51',NULL,1200),(2,1,'2023-03-01 03:57:51',NULL,1200),(3,1,'2023-03-01 03:57:51',NULL,1200),(4,23,'2023-03-01 06:57:51',NULL,12000),(5,24,'2023-03-01 06:57:51',NULL,8000);
/*!40000 ALTER TABLE `goal_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saving_frequency`
--

DROP TABLE IF EXISTS `saving_frequency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saving_frequency` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `display_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_saving_frequency_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saving_frequency`
--

LOCK TABLES `saving_frequency` WRITE;
/*!40000 ALTER TABLE `saving_frequency` DISABLE KEYS */;
INSERT INTO `saving_frequency` VALUES (1,'Weekly','Weekly',''),(2,'Fortnightly','Fortnightly','\0'),(3,'Monthly','Monthly','');
/*!40000 ALTER TABLE `saving_frequency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme_config`
--

DROP TABLE IF EXISTS `theme_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme_config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `theme_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme_config`
--

LOCK TABLES `theme_config` WRITE;
/*!40000 ALTER TABLE `theme_config` DISABLE KEYS */;
INSERT INTO `theme_config` VALUES (1,'Green',2);
/*!40000 ALTER TABLE `theme_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themedetail`
--

DROP TABLE IF EXISTS `themedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `themedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cssproperty_id` int(11) NOT NULL,
  `cssvalue` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `themetype_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Props_TO_themedetailsu8g9P` (`cssproperty_id`),
  KEY `FK_ThemeMode_TO_themedetun39j` (`themetype_id`),
  CONSTRAINT `FK_Props_TO_themedetailsu8g9P` FOREIGN KEY (`cssproperty_id`) REFERENCES `cssproperty` (`id`),
  CONSTRAINT `FK_ThemeMode_TO_themedetun39j` FOREIGN KEY (`themetype_id`) REFERENCES `themetype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themedetail`
--

LOCK TABLES `themedetail` WRITE;
/*!40000 ALTER TABLE `themedetail` DISABLE KEYS */;
INSERT INTO `themedetail` VALUES (1,1,'#457162',2),(2,2,'#457162',2),(3,3,'#457162',2),(4,4,'#457162',2),(5,5,'#fb587b',2),(6,6,'#fb587b',2),(7,1,'#656df9',1),(8,2,'#ee6390',1),(9,3,'rgba(255, 111, 81, 1)',1),(10,4,'rgba(255, 150, 66, 1)',1),(11,5,'#ec477c',1),(12,6,'#fb587b',1),(13,7,'#6a7fff',1),(14,8,'#9a5aff',1),(15,7,'#6da0cd',2),(16,8,'#6da0cd',2),(17,9,'#457162',2),(18,9,'#ff7250',1),(19,10,'#6da0cd',2),(20,11,NULL,2),(21,12,'linear-gradient(179deg, var(--brand-primary) 50%, var(--brand-primary-2) 111%)',2),(22,13,NULL,2),(23,14,'rgba(136, 136, 136, 1)',2),(24,15,'linear-gradient(101deg, rgba(4, 150, 105, 0.1) 10%, rgba(127, 201, 70, 0.1) 114%)',2),(25,16,'linear-gradient(143deg, var(--brand-secondary) 50%, var(--brand-secondary-2) 105%)',2),(26,17,'linear-gradient(316deg, rgba(246, 169, 26, 0.15), rgba(243, 90, 3, 0.1))',2),(27,18,'rgba(4, 150, 105, 0.1)',2),(28,19,'rgba(127, 201, 70, 0.1)',2),(29,20,'#457162',2),(30,21,'#357361',2),(31,22,'rgba(53, 115, 97, 0.2)',2),(32,23,'#222222',2),(33,10,'#7684fc',1),(34,11,'linear-gradient(140deg, var(--brand-info-2) 8%, var(--brand-info-2-o) 100%)',1),(35,12,'linear-gradient(179deg, var(--brand-primary) 50%, var(--brand-primary-2) 111%)',1),(36,13,'rgba(53, 54, 59, 0.9)',1),(37,14,'rgba(115, 119, 122, 1)',1),(38,15,'rgba(123, 152, 250, 0.1)',1),(39,16,'linear-gradient(143deg, var(--brand-primary) 50%, var(--brand-primary-2) 105%)',1),(40,17,'linear-gradient(123deg, var(--brand-primary-o) 50%, var(--brand-primary-o-2) 111%)',1),(41,18,'#5176f2',1),(42,19,'#97afff',1),(43,20,'#ffffff',1),(44,21,'rgba(255, 255, 255, 0.4)',1),(45,22,'rgba(247, 247, 247, 0.2)',1),(46,23,'#656df9',1),(47,24,'#858ea6',1),(48,25,'var(--primary-text-gradient)',1),(49,24,'rgba(61, 108, 131, 0.5)',2),(50,25,'linear-gradient(143deg, var(--brand-secondary) 50%, var(--brand-secondary-2) 105%)',2),(51,26,'#888888',2),(52,26,'#9da2a8',1),(53,27,'linear-gradient(143deg, var(--brand-primary) 50%, var(--brand-primary-2) 105%)',1),(54,27,'linear-gradient(143deg, var(--brand-primary) 50%, var(--brand-primary-2) 105%)',2),(82,28,'6px',1),(83,28,'6px',2),(84,29,'6px',2),(85,29,'6px',1),(86,1,'#005151',4),(87,2,'#30cebb',4),(88,3,'#ffc600',4),(89,4,'#ffc600',4),(90,5,'#C10B1E',4),(91,6,'#C10B1E',4),(92,7,'#30cebb',4),(93,8,'#30cebb',4),(94,9,NULL,4),(95,10,NULL,4),(96,11,NULL,4),(97,12,NULL,4),(98,13,NULL,4),(99,14,NULL,4),(100,15,NULL,4),(101,16,NULL,4),(102,17,'linear-gradient(123deg, rgba(48, 206, 187, 0.12) 50%, rgba(255, 198, 0, 0.15) 111%)',4),(103,18,'#005151',4),(104,19,'#30cebb',4),(105,20,NULL,4),(106,21,NULL,4),(107,22,NULL,4),(108,23,'#005151',4),(109,24,NULL,4),(110,25,NULL,4),(111,26,NULL,4),(112,27,NULL,4),(113,28,'22px',4),(114,29,'6px',4),(115,30,'linear-gradient(140deg, rgba(48, 206, 187, 0.05) 50%, rgba(255, 198, 0, 0.05) 111%)',4),(116,31,'#005151',4),(117,32,'rgba(0, 81, 81, 0.15)',4),(118,33,'rgba(48, 206, 187,  0.15)',4),(119,30,'transparent',2),(120,31,NULL,2),(121,32,'rgba(0, 82, 204, 0.12)',2),(122,33,NULL,2),(123,34,'transparent',2),(124,35,'#f97d6c',2),(125,30,'linear-gradient(140deg, rgba(101, 109, 249, 0.05) 50%, rgba(238, 99, 144, 0.05) 111%)',1),(126,31,'#ffffff',1),(127,32,'rgba(101, 109, 249, 0.12)',1),(128,33,'rgba(238, 99, 144, 0.15)',1),(129,34,'#f4f4f4',1),(130,35,'linear-gradient(179deg, var(--brand-primary) 50%, var(--brand-primary-2) 111%)',1),(131,36,NULL,2),(132,37,NULL,2),(133,38,NULL,2),(134,34,NULL,4),(135,35,'linear-gradient(179deg, var(--brand-primary) 50%, var(--brand-primary-2) 111%)',4),(136,36,'\'Volte-Regular\'',4),(137,37,'\'Volte-Medium\'',4),(138,38,'\'Volte-Semibold\'',4),(139,36,'Lexend-Regular',1),(140,37,NULL,1),(141,38,NULL,1),(142,39,NULL,2),(143,39,'#ff0000',4);
/*!40000 ALTER TABLE `themedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themetype`
--

DROP TABLE IF EXISTS `themetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `themetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isdefault` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thumbnail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themetype`
--

LOCK TABLES `themetype` WRITE;
/*!40000 ALTER TABLE `themetype` DISABLE KEYS */;
INSERT INTO `themetype` VALUES (1,'\0','Blue(Gradient)',NULL),(2,'\0','Green',NULL),(4,NULL,'Teal Green',NULL);
/*!40000 ALTER TABLE `themetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `nationality` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `residence_country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aprtment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'Joe','','Root','2016-08-23','US','USA','jot.root@wm.com','+1 890 8292 899','sample 3','sample  4','sample','sample 1','sample 2','sample 5'),(2,'Brett','Smith','brettsmith','1985-12-22','US','USA','bretsmith@abc.com','8908292899','Newry','Down','United Kingdom','Armagh Rd','B-56','BT356DN');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wealth_goal_category`
--

DROP TABLE IF EXISTS `wealth_goal_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wealth_goal_category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `display_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_wealth_goal_category_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wealth_goal_category`
--

LOCK TABLES `wealth_goal_category` WRITE;
/*!40000 ALTER TABLE `wealth_goal_category` DISABLE KEYS */;
INSERT INTO `wealth_goal_category` VALUES (1,'Auto','Auto','fa-car',''),(2,'Home','Home','fa-home',''),(3,'Child\'s Education','Child\'s Education','fa-graduation-cap',''),(4,'Vacation','Vacation','wi-flight',''),(5,'Wedding','Wedding','bb-wedding-rings','');
/*!40000 ALTER TABLE `wealth_goal_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wealth_goals`
--

DROP TABLE IF EXISTS `wealth_goals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wealth_goals` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goal_category_id` int(11) DEFAULT NULL,
  `time_to_goal` int(11) DEFAULT NULL,
  `saving_frequency_id` int(11) DEFAULT NULL,
  `recurring_day` date DEFAULT NULL,
  `recurring_debit_amount` int(11) DEFAULT NULL,
  `is_auto_debit_enabled` bit(1) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `recuring_debit_account_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_saving_frequency_TO_wR59oo` (`saving_frequency_id`),
  KEY `FK_wealth_goal_category_M2WLF` (`goal_category_id`),
  CONSTRAINT `FK_saving_frequency_TO_wR59oo` FOREIGN KEY (`saving_frequency_id`) REFERENCES `saving_frequency` (`ID`),
  CONSTRAINT `FK_wealth_goal_category_M2WLF` FOREIGN KEY (`goal_category_id`) REFERENCES `wealth_goal_category` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wealth_goals`
--

LOCK TABLES `wealth_goals` WRITE;
/*!40000 ALTER TABLE `wealth_goals` DISABLE KEYS */;
INSERT INTO `wealth_goals` VALUES (1,'Auto Loan',1,3,1,'2023-03-05',1750,'','2023-03-01 03:08:08','wmuser@wm.com','109482596988616712',800000,NULL),(2,'Home Loan',2,2,3,'2023-03-10',4167,'','2023-03-01 03:16:50','wmuser@wm.com','109144539485765641',500000,NULL),(23,'Auto Loan',1,3,1,'2023-03-05',1750,'','2023-03-01 03:08:08','james.franklin@gmail.com','109998516775878666',800000,NULL),(24,'Home Loan',2,2,3,'2023-03-10',4167,'','2023-03-01 03:16:50','james.franklin@gmail.com','109996604571516938',500000,NULL),(25,'Bali trip',4,5,3,'2023-06-12',417,'','2023-03-12 09:28:43','joe.root@gmail.com','110011051330633737',25000,''),(26,'Buy a car',1,1,3,'2023-06-10',13316,'','2023-03-13 11:40:50','joe.root@gmail.com','110011063175675918',159786,''),(27,'Home',2,2,3,'2023-04-09',10115,NULL,'2023-03-13 02:42:09','john.vick@wm.com','110010055072088078',242759,''),(30,'Buy a bike',5,0,1,'2023-03-19',0,'','2023-03-13 09:52:02','wmuser@wm.com','110008709048565774',0,''),(31,'New',1,4,1,'2023-03-19',2077,NULL,'2023-03-13 10:49:26','wmuser@wm.com','109998915339157514',434171,''),(33,'Setting New Goal',1,2,1,'2023-03-20',941,'','2023-03-14 09:23:01','wmuser@wm.com','109998821197545482',97817,''),(34,'Asset',2,3,1,'2023-05-29',321,'','2023-03-14 05:10:49','joe.root@gmail.com','110011051330633737',50000,''),(43,'Car Savings',1,2,3,'2023-06-05',1250,NULL,'2023-05-08 02:48:00','patrick.george@example.com','108452552189739019',30000,''),(48,'Education loan',3,2,3,'2023-06-10',417,NULL,'2023-05-22 04:00:35','joe.root@gmail.com','110383657387425805',10000,''),(49,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','',NULL,NULL),(50,'Jordan Vacation',4,1,3,'2023-10-01',417,'','2023-09-05 04:55:08','wmuser@wm.com','109998818239119374',5000,''),(51,'car goal',1,3,3,'2023-11-01',5556,'','2023-10-09 04:40:31','lin.user@wm.com','111203753678930001',200000,''),(52,'Wedding Savings',5,2,3,'2023-11-05',2083,NULL,'2023-10-26 11:53:27','tom.davis@gmail.com','111299726983037032',50000,''),(53,'Car Purchase',1,4,3,'2023-11-11',1875,NULL,'2023-10-26 11:55:17','tom.davis@gmail.com','111299733827092585',90000,''),(54,'Car Purchase',1,4,3,'2023-11-11',1875,NULL,'2023-10-26 11:55:18','tom.davis@gmail.com','111299733827092585',90000,''),(55,'Vacaton',4,1,1,'2023-11-20',0,NULL,'2023-11-17 02:58:52','john.v@wm.com','108878024247607304',10,''),(56,'verification',1,2,3,'2023-12-01',4865,NULL,'2023-11-27 11:41:41','john.v@wm.com','111453011205357730',116755,''),(57,'Summer break',4,1,1,'2023-12-19',192,NULL,'2023-12-18 04:04:56','tom.davis@gmail.com','111299726983037032',10000,''),(58,'travel amount',1,3,1,'2023-12-24',2072,'','2023-12-18 09:31:32','samcurran@gmail.com','111602218657316875',323232,''),(59,'Wedding Plan',5,5,3,'2024-01-09',34,NULL,'2023-12-18 09:33:17','samcurran@gmail.com','111602128931913741',2020,''),(60,'Goa Trip',4,1,1,'2023-12-26',1166,NULL,'2023-12-19 12:36:18','samcurran@gmail.com','111605731989127183',60606,''),(61,'Trips',NULL,1,3,'2024-01-01',10,NULL,'2023-12-20 03:08:51','samcurran@gmail.com','111605916049932304',120,''),(62,'Apartment',2,5,3,'2024-01-05',1759,NULL,'2024-01-03 04:22:07','tom.davis@gmail.com','111299726983037032',105567,'');
/*!40000 ALTER TABLE `wealth_goals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-04 10:20:55
