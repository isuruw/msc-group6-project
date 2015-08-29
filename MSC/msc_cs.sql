-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2015 at 10:28 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `msc_cs`
--
CREATE DATABASE IF NOT EXISTS `msc_cs`
-- --------------------------------------------------------

--
-- Table structure for table `acl_class`
--

CREATE TABLE IF NOT EXISTS `acl_class` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `class` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `class` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `acl_entry`
--

CREATE TABLE IF NOT EXISTS `acl_entry` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `acl_object_identity` bigint(20) unsigned NOT NULL,
  `ace_order` int(10) unsigned NOT NULL,
  `sid` bigint(20) unsigned NOT NULL,
  `mask` int(11) NOT NULL,
  `granting` tinyint(1) NOT NULL,
  `audit_success` tinyint(1) NOT NULL,
  `audit_failure` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `acl_entry_idx_1` (`acl_object_identity`,`ace_order`),
  KEY `fk_{9984B2BA-E902-45B5-B809-7EE3A53AEF3C}` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `acl_object_identity`
--

CREATE TABLE IF NOT EXISTS `acl_object_identity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `object_id_class` bigint(20) unsigned NOT NULL,
  `object_id_identity` bigint(20) unsigned NOT NULL,
  `parent_object` bigint(20) unsigned DEFAULT NULL,
  `owner_sid` bigint(20) unsigned DEFAULT NULL,
  `entries_inheriting` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `acl_object_identity_idx_1` (`object_id_class`,`object_id_identity`),
  KEY `fk_{05A5291E-AF04-4F22-9715-C3E903F01C60}` (`parent_object`),
  KEY `fk_{280CDE13-F85B-41E6-B653-F1002A5F5F1B}` (`owner_sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `acl_sid`
--

CREATE TABLE IF NOT EXISTS `acl_sid` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `principal` tinyint(1) NOT NULL,
  `sid` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `acl_sid_idx_1` (`sid`,`principal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_no` varchar(255) NOT NULL,
  `street_name1` varchar(255) NOT NULL,
  `street_name2` varchar(255) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_city1_idx` (`city_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `booking_ref_no` varchar(10) NOT NULL,
  `booking_date` datetime NOT NULL,
  `customer_id` int(11) NOT NULL,
  `payment_details_id` int(11) NOT NULL,
  `loading_port_id` int(11) NOT NULL,
  `unloading_port_id` int(11) NOT NULL,
  `collection_address_id` int(11) NOT NULL,
  `delivery_address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `booking_ref_no_UNIQUE` (`booking_ref_no`),
  KEY `fk_booking_customer1` (`customer_id`),
  KEY `fk_booking_payment_details1` (`payment_details_id`),
  KEY `fk_booking_port1` (`loading_port_id`),
  KEY `fk_booking_port2` (`unloading_port_id`),
  KEY `fk_booking_address1` (`collection_address_id`),
  KEY `fk_booking_address2` (`delivery_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_city_country1_idx` (`country_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `code`, `name`, `description`, `is_active`, `country_id`) VALUES
(1, 'city001', 'Shanghai', NULL, 1, 9),
(2, 'city002', 'Shenzhen', NULL, 1, 9),
(3, 'city003', 'Ningbo-Zhoushan', NULL, 1, 9),
(4, 'city004', 'Qingdao', NULL, 1, 9),
(5, 'city005', 'Guangzhou', NULL, 1, 9),
(6, 'city006', 'Tianjin', NULL, 1, 9),
(7, 'city007', 'Kelang', NULL, 1, 24),
(8, 'city008', 'Kaohsiung', NULL, 1, 10),
(9, 'city009', 'Hamburg', NULL, 1, 111),
(10, 'city010', 'Antwerp', NULL, 1, 100),
(11, 'CITY-011', 'Hambantota', NULL, 1, 37);

-- --------------------------------------------------------

--
-- Table structure for table `commodity`
--

CREATE TABLE IF NOT EXISTS `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `width` float NOT NULL,
  `height` float NOT NULL,
  `weight` float NOT NULL,
  `qty` float NOT NULL,
  `length` float NOT NULL,
  `is_hazardous` tinyint(4) NOT NULL DEFAULT '0',
  `commodity_category_id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_commodity_commodity_category1` (`commodity_category_id`),
  KEY `fk_commodity_booking1` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `commodity_category`
--

CREATE TABLE IF NOT EXISTS `commodity_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `commodity_category`
--

INSERT INTO `commodity_category` (`id`, `code`, `name`, `description`, `is_active`) VALUES
(4, 'CC-001', 'Vegetables', 'Hmmm', 0),
(5, 'CC-002', 'Electronic', 'Electronic', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `container`
--

CREATE TABLE IF NOT EXISTS `container` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `container_type_id` int(11) NOT NULL,
  `shipping_company_id` int(11) NOT NULL,
  `frieght_plan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_container_container_type1_idx` (`container_type_id`),
  KEY `fk_container_shipping_company1` (`shipping_company_id`),
  KEY `fk_container_frieght_plan1` (`frieght_plan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `container`
--

INSERT INTO `container` (`id`, `code`, `name`, `is_active`, `container_type_id`, `shipping_company_id`, `frieght_plan_id`) VALUES
(1, 'CON-001', 'Seamon', 1, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `container_type`
--

CREATE TABLE IF NOT EXISTS `container_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `container_type`
--

INSERT INTO `container_type` (`id`, `code`, `name`) VALUES
(1, 'CT-001', 'Dry storage container'),
(2, 'CT-002', 'Flat rack container'),
(3, 'CT-003', 'Open top container'),
(4, 'CT-004', 'Tunnel container'),
(5, 'CT-005', 'Open side storage container'),
(6, 'CT-006', 'Double doors container'),
(7, 'CT-007', 'Refrigerated ISO containers'),
(8, 'CT-008', 'Insulated or thermal containers'),
(9, 'CT-009', 'Tanks'),
(10, 'CT-010', 'Cargo storage roll container'),
(11, 'CT-011', 'Half height containers'),
(12, 'CT-012', 'Car carriers'),
(13, 'CT-013', 'Intermediate bulk shift containers'),
(14, 'CT-014', 'Drums'),
(15, 'CT-015', 'Special purpose containers'),
(16, 'CT-016', 'Swap bodies');

-- --------------------------------------------------------

--
-- Table structure for table `continent`
--

CREATE TABLE IF NOT EXISTS `continent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `continent`
--

INSERT INTO `continent` (`id`, `code`, `name`) VALUES
(1, 'continent001', 'Asia'),
(2, 'continent002', 'Africa'),
(3, 'continent003', 'Europe'),
(4, 'continent004', 'North America'),
(5, 'continent005', 'South America'),
(6, 'continent006', 'Antarctica'),
(7, 'continent007', 'Australia');

-- --------------------------------------------------------

--
-- Table structure for table `conversation`
--

CREATE TABLE IF NOT EXISTS `conversation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ref_no` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `is_viewed` tinyint(4) NOT NULL,
  `contact_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_conversation_contact1_idx` (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL,
  `continent_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_country_continent1_idx` (`continent_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=196 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `code`, `name`, `description`, `display_name`, `is_active`, `continent_id`) VALUES
(1, 'country001', 'Afghanistan', NULL, 'Afghanistan', 1, 1),
(2, 'country002', 'Armenia ', NULL, 'Armenia ', 1, 1),
(3, 'country003', 'Azerbaijan', NULL, 'Azerbaijan', 1, 1),
(4, 'country004', 'Bahrain', NULL, 'Bahrain', 1, 1),
(5, 'country005', 'Bangladesh', NULL, 'Bangladesh', 1, 1),
(6, 'country006', 'Bhutan', NULL, 'Bhutan', 1, 1),
(7, 'country007', 'Brunei ', NULL, 'Brunei ', 1, 1),
(8, 'country008', 'Cambodia', NULL, 'Cambodia', 1, 1),
(9, 'country009', 'China', NULL, 'China', 1, 1),
(10, 'country010', 'Taiwan', NULL, 'Taiwan', 1, 1),
(11, 'country011', 'East Timor ', NULL, 'East Timor ', 1, 1),
(12, 'country012', 'India', NULL, 'India', 1, 1),
(13, 'country013', 'Indonesia ', NULL, 'Indonesia ', 1, 1),
(14, 'country014', 'Iran', NULL, 'Iran', 1, 1),
(15, 'country015', 'Iraq', NULL, 'Iraq', 1, 1),
(16, 'country016', 'Israel', NULL, 'Israel', 1, 1),
(17, 'country017', 'Palestine', NULL, 'Palestine', 1, 1),
(18, 'country018', 'Japan', NULL, 'Japan ', 1, 1),
(19, 'country019', 'Jordan', NULL, 'Jordan', 1, 1),
(20, 'country020', 'Kazakhstan ', NULL, 'Kazakhstan ', 1, 1),
(21, 'country021', 'Kuwait', NULL, 'Kuwait', 1, 1),
(22, 'country022', 'Laos', NULL, 'Laos', 1, 1),
(23, 'country023', 'Lebanon', NULL, 'Lebanon', 1, 1),
(24, 'country024', 'Malaysia ', NULL, 'Malaysia ', 1, 1),
(25, 'country025', 'Maldives', NULL, 'Maldives', 1, 1),
(26, 'country026', 'Mongolia', NULL, 'Mongolia', 1, 1),
(27, 'country027', 'Myanmar', NULL, 'Myanmar', 1, 1),
(28, 'country028', 'Nepal', NULL, 'Nepal', 1, 1),
(29, 'country029', 'North Korea', NULL, 'North Korea', 1, 1),
(30, 'country030', 'Oman ', NULL, 'Oman ', 1, 1),
(31, 'country031', 'Pakistan', NULL, 'Pakistan', 1, 1),
(32, 'country032', 'Philippines ', NULL, 'Philippines ', 1, 1),
(33, 'country033', 'Qatar', NULL, 'Qatar', 1, 1),
(34, 'country034', 'Russia ', NULL, 'Russia ', 1, 1),
(35, 'country035', 'Saudi Arabia', NULL, 'Saudi Arabia', 1, 1),
(36, 'country036', 'Singapore', NULL, 'Singapore', 1, 1),
(37, 'country037', 'Sri Lanka ', NULL, 'Sri Lanka ', 1, 1),
(38, 'country038', 'Syria', NULL, 'Syria', 1, 1),
(39, 'country039', 'Tajikistan', NULL, 'Tajikistan', 1, 1),
(40, 'country040', 'Thailand', NULL, 'Thailand', 1, 1),
(41, 'country041', 'Turkey', NULL, 'Turkey', 1, 1),
(42, 'country042', 'Turkmenistan', NULL, 'Turkmenistan', 1, 1),
(43, 'country043', 'United Arab Emirates', NULL, 'United Arab Emirates', 1, 1),
(44, 'country044', 'Uzbekistan ', NULL, 'Uzbekistan ', 1, 1),
(45, 'country045', 'Vietnam', NULL, 'Vietnam', 1, 1),
(46, 'country046', 'Yemen', NULL, 'Yemen', 1, 1),
(47, 'country047', 'Algeria', NULL, 'Algeria', 1, 2),
(48, 'country048', 'Angola', NULL, 'Angola', 1, 2),
(49, 'country049', 'Benin', NULL, 'Benin', 1, 2),
(50, 'country050', 'Botswana', NULL, 'Botswana', 1, 2),
(51, 'country051', 'Burkina Faso', NULL, 'Burkina Faso', 1, 2),
(52, 'country052', 'Cameroon', NULL, 'Cameroon', 1, 2),
(53, 'country053', 'Cape Verde', NULL, 'Cape Verde', 1, 2),
(54, 'country054', 'Chad', NULL, 'Chad', 1, 2),
(55, 'country055', 'Comoros', NULL, 'Comoros', 1, 2),
(56, 'country056', 'Republic of the Congo', NULL, 'Republic of the Congo', 1, 2),
(57, 'country057', 'Democratic Republic of the Congo ', NULL, 'Democratic Republic of the Congo ', 1, 2),
(58, 'country058', 'Côte d''Ivoire', NULL, 'Côte d''Ivoire', 1, 2),
(59, 'country059', 'Djibouti', NULL, 'Djibouti', 1, 2),
(60, 'country060', 'Egypt', NULL, 'Egypt', 1, 2),
(61, 'country061', 'Equatorial Guinea', NULL, 'Equatorial Guinea', 1, 2),
(62, 'country062', 'Eritrea', NULL, 'Eritrea', 1, 2),
(63, 'country063', 'Ethiopia', NULL, 'Ethiopia', 1, 2),
(64, 'country064', 'Gabon', NULL, 'Gabon', 1, 2),
(65, 'country065', 'The Gambia ', NULL, 'The Gambia ', 1, 2),
(66, 'country066', 'Ghana ', NULL, 'Ghana ', 1, 2),
(67, 'country067', 'Guinea', NULL, 'Guinea', 1, 2),
(68, 'country068', 'Guinea', NULL, 'Guinea', 1, 2),
(69, 'country069', 'Kenya', NULL, 'Kenya', 1, 2),
(70, 'country070', 'Lesotho', NULL, 'Lesotho', 1, 2),
(71, 'country071', 'Liberia', NULL, 'Liberia', 1, 2),
(72, 'country072', 'Madagascar', NULL, 'Madagascar', 1, 2),
(73, 'country073', 'Malawi', NULL, 'Malawi', 1, 2),
(74, 'country074', 'Mali ', NULL, 'Mali ', 1, 2),
(75, 'country075', 'Mauritania', NULL, 'Mauritania', 1, 2),
(76, 'country076', 'Mauritius', NULL, 'Mauritius', 1, 2),
(77, 'country077', 'Morocco', NULL, 'Morocco', 1, 2),
(78, 'country078', 'Mozambique', NULL, 'Mozambique', 1, 2),
(79, 'country079', 'Namibia', NULL, 'Namibia', 1, 2),
(80, 'country080', 'Niger', NULL, 'Niger', 1, 2),
(81, 'country081', 'Nigeria', NULL, 'Nigeria', 1, 2),
(82, 'country082', 'Rwanda', NULL, 'Rwanda', 1, 2),
(83, 'country083', 'São Tomé and Príncipe', NULL, 'São Tomé and Príncipe', 1, 2),
(84, 'country084', 'Senegal ', NULL, 'Senegal ', 1, 2),
(85, 'country085', 'Seychelles', NULL, 'Seychelles', 1, 2),
(86, 'country086', 'Sierra Leone', NULL, 'Sierra Leone', 1, 2),
(87, 'country087', 'Somalia', NULL, 'Somalia', 1, 2),
(88, 'country088', 'South Africa', NULL, 'South Africa', 1, 2),
(89, 'country089', 'South Sudan', NULL, 'South Sudan', 1, 2),
(90, 'country090', 'Sudan', NULL, 'Sudan', 1, 2),
(91, 'country091', 'Swaziland', NULL, 'Swaziland', 1, 2),
(92, 'country092', 'Togo', NULL, 'Togo', 1, 2),
(93, 'country093', 'Tunisia', NULL, 'Tunisia', 1, 2),
(94, 'country094', 'Zambia', NULL, 'Zambia', 1, 2),
(95, 'country095', 'Zimbabwe', NULL, 'Zimbabwe', 1, 2),
(96, 'country096', 'Albania', NULL, 'Albania', 1, 3),
(97, 'country097', 'Andorra', NULL, 'Andorra', 1, 3),
(98, 'country098      ', 'Austria', NULL, 'Austria', 1, 3),
(99, 'country099', 'Belarus', NULL, 'Belarus', 1, 3),
(100, 'country100', 'Belgium', NULL, 'Belgium', 1, 3),
(101, 'country101', 'Bosnia and Herzegovina', NULL, 'Bosnia and Herzegovina', 1, 3),
(102, 'country102', 'Bulgaria', NULL, 'Bulgaria', 1, 3),
(103, 'country103', 'Croatia', NULL, 'Croatia', 1, 3),
(104, 'country104', 'Cyprus', NULL, 'Cyprus', 1, 3),
(105, 'country105', 'Czech Republic', NULL, 'Czech Republic', 1, 3),
(106, 'country106', 'Denmark', NULL, 'Denmark', 1, 3),
(107, 'country107', 'Estonia', NULL, 'Estonia', 1, 3),
(108, 'country108', 'Finland', NULL, 'Finland', 1, 3),
(109, 'country109', 'France ', NULL, 'France ', 1, 3),
(110, 'country110', 'Georgia ', NULL, 'Georgia ', 1, 3),
(111, 'country111', 'Germany', NULL, 'Germany', 1, 3),
(112, 'country112', 'Greece', NULL, 'Greece', 1, 3),
(113, 'country113', 'Hungary', NULL, 'Hungary', 1, 3),
(114, 'country114', 'Iceland', NULL, 'Iceland', 1, 3),
(115, 'country115', 'Republic of Ireland', NULL, 'Republic of Ireland', 1, 3),
(116, 'country116', 'Italy', NULL, 'Italy', 1, 3),
(117, 'country117', 'Latvia', NULL, 'Latvia', 1, 3),
(118, 'country118', 'Liechtenstein', NULL, 'Liechtenstein', 1, 3),
(119, 'country119', 'Lithuania', NULL, 'Lithuania', 1, 3),
(120, 'country120', 'Luxembourg', NULL, 'Luxembourg', 1, 3),
(121, 'country121', 'Malta', NULL, 'Malta', 1, 3),
(122, 'country122', 'Moldova', NULL, 'Moldova', 1, 3),
(123, 'country123', 'Monaco', NULL, 'Monaco', 1, 3),
(124, 'country124', 'Montenegro', NULL, 'Montenegro', 1, 3),
(125, 'country125', 'Netherlands', NULL, 'Netherlands', 1, 3),
(126, 'country126', 'Norway', NULL, 'Norway', 1, 3),
(127, 'country127', 'Poland', NULL, 'Poland', 1, 3),
(128, 'country128', 'Portugal', NULL, 'Portugal', 1, 3),
(129, 'country129', 'Romania', NULL, 'Romania', 1, 3),
(130, 'country130', 'Russia', NULL, 'Russia', 1, 3),
(131, 'country131', 'San Marino', NULL, 'San Marino', 1, 3),
(132, 'country132', 'Serbia', NULL, 'Serbia', 1, 3),
(133, 'country133', 'Slovakia', NULL, 'Slovakia', 1, 3),
(134, 'country134', 'Slovenia', NULL, 'Slovenia', 1, 3),
(135, 'country135', 'Spain', NULL, 'Spain', 1, 3),
(136, 'country136', 'Sweden', NULL, 'Sweden', 1, 3),
(137, 'country137', 'Switzerland', NULL, 'Switzerland', 1, 3),
(138, 'country138', 'Turkey', NULL, 'Turkey', 1, 3),
(139, 'country139', 'Ukraine', NULL, 'Ukraine', 1, 3),
(140, 'country140', 'England', NULL, 'England', 1, 3),
(141, 'country141', 'Scotland', NULL, 'Scotland', 1, 3),
(142, 'country142', 'Wales', NULL, 'Wales', 1, 3),
(143, 'country143', 'Vatican City ', NULL, 'Vatican City ', 1, 3),
(144, 'country144', 'Canada', NULL, 'Canada ', 1, 4),
(145, 'country145', 'Mexico', NULL, 'Mexico', 1, 4),
(146, 'country146', 'America', 'United States of America', 'America', 1, 4),
(147, 'country147', 'Antigua and Barbuda', NULL, 'Antigua and Barbuda', 1, 5),
(148, 'country148', 'Bahamas', NULL, 'Bahamas', 1, 5),
(149, 'country149', 'Barbados', NULL, 'Barbados', 1, 5),
(150, 'country150', 'Belize', NULL, 'Belize', 1, 5),
(151, 'country151', 'Costa Rica', NULL, 'Costa Rica', 1, 5),
(152, 'country152', 'Cuba', NULL, 'Cuba', 1, 5),
(153, 'country153', 'Dominica', NULL, 'Dominica', 1, 5),
(154, 'country154', 'Dominican Republic', NULL, 'Dominican Republic', 1, 5),
(155, 'country155', 'El Salvador', NULL, 'El Salvador', 1, 5),
(156, 'country156', 'Grenada', NULL, 'Grenada', 1, 5),
(157, 'country157', 'Guatemala', NULL, 'Guatemala', 1, 5),
(158, 'country158', 'Haiti', NULL, 'Haiti', 1, 5),
(159, 'country159', 'Honduras', NULL, 'Honduras', 1, 5),
(160, 'country160', 'Jamaica', NULL, 'Jamaica', 1, 5),
(161, 'country161', 'Nicaragua ', NULL, 'Nicaragua ', 1, 5),
(162, 'country162', 'Panama', NULL, 'Panama', 1, 5),
(163, 'country163', 'Puerto Rico', NULL, 'Puerto Rico', 1, 5),
(164, 'country164', 'Saint Kitts and Nevis', NULL, 'Saint Kitts and Nevis', 1, 5),
(165, 'country165', 'Saint Lucia', NULL, 'Saint Lucia', 1, 5),
(166, 'country166', 'Saint Vincent and the Grenadines', NULL, 'Saint Vincent and the Grenadines', 1, 5),
(167, 'country167', 'Trinidad and Tobago', NULL, 'Trinidad and Tobago', 1, 5),
(168, 'country168', 'Turks and Caicos', NULL, 'Turks and Caicos', 1, 5),
(169, 'country169', 'Argentina ', NULL, 'Argentina ', 1, 5),
(170, 'country170', 'Bolivia', NULL, 'Bolivia', 1, 5),
(171, 'country171', 'Brazil', NULL, 'Brazil', 1, 5),
(172, 'country172', 'Chile', NULL, 'Chile', 1, 5),
(173, 'country173', 'Colombia', NULL, 'Colombia', 1, 5),
(174, 'country174', 'Ecuador', NULL, 'Ecuador', 1, 5),
(175, 'country175', 'French Guiana', NULL, 'French Guiana', 1, 5),
(176, 'country176', 'Guyana', NULL, 'Guyana', 1, 5),
(177, 'country177', 'Paraguay', NULL, 'Paraguay', 1, 5),
(178, 'country178', 'Peru', NULL, 'Peru', 1, 5),
(179, 'country179', 'Suriname ', NULL, 'Suriname ', 1, 5),
(180, 'country180', 'Uruguay', NULL, 'Uruguay', 1, 5),
(181, 'country181', 'Venezuela', NULL, 'Venezuela', 1, 5),
(182, 'country182', 'Australia', NULL, 'Australia', 1, 7),
(183, 'country183', 'New Zealand', NULL, 'New Zealand', 1, 7),
(184, 'country184', 'Fiji', NULL, 'Fiji', 1, 7),
(185, 'country185', 'Papua New Guinea', NULL, 'Papua New Guinea', 1, 7),
(186, 'country186', 'Solomon Islands', NULL, 'Solomon Islands', 1, 7),
(187, 'country187', 'Vanuatu', NULL, 'Vanuatu', 1, 7),
(188, 'country188', 'Kiribati', NULL, 'Kiribati', 1, 7),
(189, 'country189', 'Marshall Islands ', NULL, 'Marshall Islands ', 1, 7),
(190, 'country190', 'Micronesia', NULL, 'Micronesia', 1, 7),
(191, 'country191', 'Nauru', NULL, 'Nauru', 1, 7),
(192, 'country192', 'Palau ', NULL, 'Palau ', 1, 7),
(193, 'country193', 'Samoa', NULL, 'Samoa', 1, 7),
(194, 'country194', 'Tonga', NULL, 'Tonga', 1, 7),
(195, 'country195', 'Tuvalu', NULL, 'Tuvalu', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(255) NOT NULL,
  `business_reg_no` varchar(15) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telephone_no` varchar(15) NOT NULL,
  `fax_no` varchar(15) DEFAULT NULL,
  `user_note` varchar(255) DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `business_reg_no_UNIQUE` (`business_reg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer_address`
--

CREATE TABLE IF NOT EXISTS `customer_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_address_customer1_idx` (`customer_id`),
  KEY `fk_customer_address_address1_idx` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `frieght_plan`
--

CREATE TABLE IF NOT EXISTS `frieght_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `departure_port_time` datetime DEFAULT NULL,
  `destination_port_time` datetime DEFAULT NULL,
  `departure_port_id` int(11) DEFAULT NULL,
  `destination_port_id` int(11) DEFAULT NULL,
  `ship_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_shipment_ship1` (`ship_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `frieght_plan`
--

INSERT INTO `frieght_plan` (`id`, `code`, `name`, `departure_port_time`, `destination_port_time`, `departure_port_id`, `destination_port_id`, `ship_id`) VALUES
(9, 'FP-001', 'First', '2013-12-31 23:59:59', '2013-12-31 23:59:59', 1, 10, 1),
(11, 'FP-002', 'Second', '2013-12-31 23:59:59', '2013-12-31 23:59:59', 1, 10, 4);

-- --------------------------------------------------------

--
-- Table structure for table `frieght_plan_port`
--

CREATE TABLE IF NOT EXISTS `frieght_plan_port` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `port_order` int(11) NOT NULL,
  `expected_date_departure` datetime DEFAULT NULL,
  `expected_time_arrival` datetime DEFAULT NULL,
  `port_id` int(11) NOT NULL,
  `frieght_plan_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_freigt_plan_port_port1` (`port_id`),
  KEY `fk_frieght_plan_port_frieght_plan1` (`frieght_plan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `frieght_plan_port`
--

INSERT INTO `frieght_plan_port` (`id`, `port_order`, `expected_date_departure`, `expected_time_arrival`, `port_id`, `frieght_plan_id`) VALUES
(1, 1, '2013-12-31 23:59:59', '2013-12-31 23:59:59', 5, 9),
(3, 1, '2013-12-31 23:59:59', '2013-12-31 23:59:59', 2, 11),
(4, 2, '2013-12-31 23:59:59', '2013-12-31 23:59:59', 4, 11),
(5, 3, '2013-12-31 23:59:59', '2013-12-31 23:59:59', 7, 11),
(6, 4, '2013-12-31 23:59:59', '2013-12-31 23:59:59', 9, 11);

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `image_map`
--

CREATE TABLE IF NOT EXISTS `image_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) NOT NULL,
  `table_field_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_image_map_image1` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `display_name` varchar(255) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `display_name_UNIQUE` (`display_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_desc` text NOT NULL,
  `message_time` varchar(255) NOT NULL,
  `conversation_id` int(11) NOT NULL,
  `system_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_message_conversation1_idx` (`conversation_id`),
  KEY `fk_message_system_user1_idx` (`system_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `payment_details`
--

CREATE TABLE IF NOT EXISTS `payment_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `payment_date` datetime NOT NULL,
  `payment_mode_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_details_payment_mode1` (`payment_mode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `payment_mode`
--

CREATE TABLE IF NOT EXISTS `payment_mode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `port`
--

CREATE TABLE IF NOT EXISTS `port` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_port_city1_idx` (`city_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `port`
--

INSERT INTO `port` (`id`, `code`, `name`, `longitude`, `latitude`, `is_active`, `city_id`) VALUES
(1, 'PORT-001', 'Shanghai Port', 122.0647, 30.6264, 1, 1),
(2, 'PORT-002', 'Shenzhen Port', 113.8833, 22.5, 1, 2),
(3, 'PORT-003', 'Ningbo-Zhoushan Port', 121.55, 29.8667, 1, 3),
(4, 'PORT-004', 'Qingdao Port', 120.317, 36.0833, 1, 4),
(5, 'PORT-005', 'Guangzhou Harbor', 113.4378, 23.0939, 1, 5),
(6, 'PORT-006', 'Tianjin Harbor', 117.7875, 38.9758, 1, 6),
(7, 'PORT-007', 'Port Kelang', 101.4, 3, 1, 7),
(8, 'PORT-008', 'Kaohsiung Harbor', 120.2792, 22.6133, 1, 8),
(9, 'PORT-009', 'Hamburg Port', 9.9661, 53.5461, 1, 9),
(10, 'PORT-010', 'Antwerp Harbor', 4.3367, 51.27, 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `ship`
--

CREATE TABLE IF NOT EXISTS `ship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imo_no` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gross_register_tonnage` double NOT NULL,
  `net_register_tonnage` double NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `ship_category_id` int(11) NOT NULL,
  `shipping_company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`imo_no`),
  KEY `fk_ship_ship_category1` (`ship_category_id`),
  KEY `fk_ship_shipping_company1` (`shipping_company_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Net register tonnage (NRT) is the volume of cargo the vessel' AUTO_INCREMENT=5 ;

--
-- Dumping data for table `ship`
--

INSERT INTO `ship` (`id`, `imo_no`, `name`, `gross_register_tonnage`, `net_register_tonnage`, `is_active`, `ship_category_id`, `shipping_company_id`) VALUES
(1, 'IMO-001', 'Janet', 60000, 50000, 1, 1, 1),
(2, 'IMO-002', 'Rose', 60000, 50000, 1, 2, 2),
(4, 'IMO-003', 'Jasmine', 6000, 4000, 0, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `shipping_company`
--

CREATE TABLE IF NOT EXISTS `shipping_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(255) NOT NULL,
  `business_reg_no` varchar(255) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `business_reg_no_UNIQUE` (`business_reg_no`),
  KEY `fk_shipping_company_address1` (`address_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `shipping_company`
--

INSERT INTO `shipping_company` (`id`, `business_name`, `business_reg_no`, `is_active`, `address_id`) VALUES
(1, 'Ceyline Group of Companies', 'SHIP-COMP-001', 1, NULL),
(2, 'Mercantile Shipping Agencies', 'SHIP-COMP-002', 1, NULL),
(3, 'Setmil Group of Companies', 'SHIP-COMP-003', 1, NULL),
(4, 'McLarens Holdings Ltd', 'SHIP-COMP-004', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ship_category`
--

CREATE TABLE IF NOT EXISTS `ship_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `ship_category`
--

INSERT INTO `ship_category` (`id`, `code`, `type`) VALUES
(1, 'SC-001', 'Container'),
(2, 'SC-002', 'Refer Ship'),
(3, 'SC-003', 'Bulk Carrier'),
(4, 'SC-004', 'General Cargo'),
(5, 'SC-005', 'Oil Tanker'),
(6, 'SC-006', 'Gas Tanker'),
(7, 'SC-007', 'Car Carrier'),
(8, 'SC-008', 'Cruise Liner'),
(9, 'SC-009', 'Heavy Cargo'),
(10, 'SC-010', 'Chemical Tanker');

-- --------------------------------------------------------

--
-- Table structure for table `subscriber`
--

CREATE TABLE IF NOT EXISTS `subscriber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `joined_datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `system_user`
--

CREATE TABLE IF NOT EXISTS `system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `current_ip_address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `joined_date` datetime DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL,
  `system_user_role_id` int(11) NOT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_system_user_system_user_role_idx` (`system_user_role_id`),
  KEY `fk_system_user_country1` (`country_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `system_user`
--

INSERT INTO `system_user` (`id`, `name`, `username`, `password`, `image`, `current_ip_address`, `email`, `joined_date`, `is_active`, `system_user_role_id`, `country_id`) VALUES
(1, 'Sasanka Amarasiri', 'cs_sasanka', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'sasa_dssc@yahoo.com', '2015-08-01 07:21:44', 1, 1, 37),
(2, 'Isuru Wimalasundara', 'cs_isuru', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'isuru@gmail.com', '2015-08-02 07:21:44', 1, 1, 37),
(3, 'Frank Martin', 'cs_frank', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'frank@gmail.com', '2015-08-03 07:21:44', 1, 2, 140),
(4, 'Jason Statham', 'cs_jason', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'jason@gmail.com', '2015-08-04 07:21:44', 1, 2, 142),
(5, 'Jack Sparrow', 'cs_jack', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'jack@gmail.com', '2015-08-05 06:21:44', 1, 3, 146),
(6, 'Johnny Depp', 'cs_jonny', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'johnny@gmail.com', '2015-08-05 07:21:44', 1, 3, 146),
(7, 'Jonty Rhodes', 'cs_jonty', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'jonty@gmail.com', '2015-08-06 07:21:44', 1, 4, 88),
(8, 'Andy Flower', 'cs_andy', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'andy@gmail.com', '2015-08-07 07:21:44', 1, 4, 95),
(9, 'Kamal Perera', 'cs_kamal', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'ad@gmail.com', '2015-08-08 07:21:44', 1, 2, 1),
(11, 'Kusal Rasika', 'cs_kusal', '1ab5e4b533686ac23a2291f5e9a3e361', NULL, NULL, 'sasa_dssc@yahoo.com', '2015-08-09 07:21:44', 0, 3, 1),
(14, 'New User', 'cs_new', '123', NULL, NULL, 'sasa_dssc1@yahoo.com', '2015-08-26 07:21:44', 0, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `system_user_role`
--

CREATE TABLE IF NOT EXISTS `system_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `display_role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `system_user_role`
--

INSERT INTO `system_user_role` (`id`, `role_name`, `display_role_name`) VALUES
(1, 'ROLE_MSC_ADMIN', 'MSC Admin'),
(2, 'ROLE_CARGO_MANAGER', 'Cargo Manager'),
(3, 'ROLE_SHIP_MANAGER', 'Ship Manager'),
(4, 'ROLE_LOCAL_AGENT_MANAGER', 'Local Agent Manager');

-- --------------------------------------------------------

--
-- Table structure for table `user_role_assignor`
--

CREATE TABLE IF NOT EXISTS `user_role_assignor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assignor_role_id` int(11) NOT NULL,
  `assignee_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_assigner_system_user_role1` (`assignor_role_id`),
  KEY `fk_user_role_assigner_system_user_role2` (`assignee_role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `user_role_assignor`
--

INSERT INTO `user_role_assignor` (`id`, `assignor_role_id`, `assignee_role_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 2),
(6, 3, 3),
(7, 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `workflow`
--

CREATE TABLE IF NOT EXISTS `workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `cargo_manager_updated_time` datetime DEFAULT NULL,
  `ship_manager_updated_time` datetime DEFAULT NULL,
  `local_agent_manager_updated_time` datetime DEFAULT NULL,
  `booking_id` int(11) NOT NULL,
  `cargo_manager_id` int(11) NOT NULL,
  `ship_manager_id` int(11) NOT NULL,
  `local_agent_manager_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_workflow1_booking1` (`booking_id`),
  KEY `fk_workflow_system_user1` (`cargo_manager_id`),
  KEY `fk_workflow_system_user2` (`ship_manager_id`),
  KEY `fk_workflow_system_user3` (`local_agent_manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `acl_entry`
--
ALTER TABLE `acl_entry`
  ADD CONSTRAINT `fk_{5D6482DF-61C9-49E2-B309-574D020F46AC}` FOREIGN KEY (`acl_object_identity`) REFERENCES `acl_object_identity` (`id`),
  ADD CONSTRAINT `fk_{9984B2BA-E902-45B5-B809-7EE3A53AEF3C}` FOREIGN KEY (`sid`) REFERENCES `acl_sid` (`id`);

--
-- Constraints for table `acl_object_identity`
--
ALTER TABLE `acl_object_identity`
  ADD CONSTRAINT `fk_{05A5291E-AF04-4F22-9715-C3E903F01C60}` FOREIGN KEY (`parent_object`) REFERENCES `acl_object_identity` (`id`),
  ADD CONSTRAINT `fk_{280CDE13-F85B-41E6-B653-F1002A5F5F1B}` FOREIGN KEY (`owner_sid`) REFERENCES `acl_sid` (`id`),
  ADD CONSTRAINT `fk_{E56482A8-B2B3-4F5C-8399-11F76F7E0BF9}` FOREIGN KEY (`object_id_class`) REFERENCES `acl_class` (`id`);

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `fk_address_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `fk_booking_address1` FOREIGN KEY (`collection_address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_booking_address2` FOREIGN KEY (`delivery_address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_booking_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_booking_payment_details1` FOREIGN KEY (`payment_details_id`) REFERENCES `payment_details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_booking_port1` FOREIGN KEY (`loading_port_id`) REFERENCES `port` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_booking_port2` FOREIGN KEY (`unloading_port_id`) REFERENCES `port` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `fk_city_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `commodity`
--
ALTER TABLE `commodity`
  ADD CONSTRAINT `fk_commodity_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_commodity_commodity_category1` FOREIGN KEY (`commodity_category_id`) REFERENCES `commodity_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `container`
--
ALTER TABLE `container`
  ADD CONSTRAINT `fk_container_container_type1` FOREIGN KEY (`container_type_id`) REFERENCES `container_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_container_frieght_plan1` FOREIGN KEY (`frieght_plan_id`) REFERENCES `frieght_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_container_shipping_company1` FOREIGN KEY (`shipping_company_id`) REFERENCES `shipping_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `conversation`
--
ALTER TABLE `conversation`
  ADD CONSTRAINT `fk_conversation_contact1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `country`
--
ALTER TABLE `country`
  ADD CONSTRAINT `fk_country_continent1` FOREIGN KEY (`continent_id`) REFERENCES `continent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `customer_address`
--
ALTER TABLE `customer_address`
  ADD CONSTRAINT `fk_customer_address_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_customer_address_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `frieght_plan`
--
ALTER TABLE `frieght_plan`
  ADD CONSTRAINT `fk_shipment_ship1` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `frieght_plan_port`
--
ALTER TABLE `frieght_plan_port`
  ADD CONSTRAINT `fk_freigt_plan_port_port1` FOREIGN KEY (`port_id`) REFERENCES `port` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_frieght_plan_port_frieght_plan1` FOREIGN KEY (`frieght_plan_id`) REFERENCES `frieght_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `image_map`
--
ALTER TABLE `image_map`
  ADD CONSTRAINT `fk_image_map_image1` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `fk_message_conversation1` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_message_system_user1` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `payment_details`
--
ALTER TABLE `payment_details`
  ADD CONSTRAINT `fk_payment_details_payment_mode1` FOREIGN KEY (`payment_mode_id`) REFERENCES `payment_mode` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `port`
--
ALTER TABLE `port`
  ADD CONSTRAINT `fk_port_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ship`
--
ALTER TABLE `ship`
  ADD CONSTRAINT `fk_ship_shipping_company1` FOREIGN KEY (`shipping_company_id`) REFERENCES `shipping_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ship_ship_category1` FOREIGN KEY (`ship_category_id`) REFERENCES `ship_category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `shipping_company`
--
ALTER TABLE `shipping_company`
  ADD CONSTRAINT `fk_shipping_company_address1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `system_user`
--
ALTER TABLE `system_user`
  ADD CONSTRAINT `fk_system_user_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_system_user_system_user_role` FOREIGN KEY (`system_user_role_id`) REFERENCES `system_user_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_role_assignor`
--
ALTER TABLE `user_role_assignor`
  ADD CONSTRAINT `fk_user_role_assigner_system_user_role1` FOREIGN KEY (`assignor_role_id`) REFERENCES `system_user_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_role_assigner_system_user_role2` FOREIGN KEY (`assignee_role_id`) REFERENCES `system_user_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `workflow`
--
ALTER TABLE `workflow`
  ADD CONSTRAINT `fk_workflow1_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_workflow_system_user1` FOREIGN KEY (`cargo_manager_id`) REFERENCES `system_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_workflow_system_user2` FOREIGN KEY (`ship_manager_id`) REFERENCES `system_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_workflow_system_user3` FOREIGN KEY (`local_agent_manager_id`) REFERENCES `system_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
