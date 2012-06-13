-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 07, 2012 at 06:36 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `boxmate`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `accountLevel` int(11) DEFAULT '0',
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `accountLevel`, `firstName`, `lastName`, `address`, `emailAddress`, `phoneNumber`) VALUES
(1, 'zseguin', 'password', 10, 'Zachary', 'Seguin', '[HOUSE NUMBER : ''429'', STREET NAME : ''Cardigan'', STREET SUFIX : ''Place'', PROVINCE : ''London'', COUNTRY : ''Ontario'', POSTAL CODE : ''N6M 1J6'']', 'zseguin@me.com', '(519) 668-3141'),
(2, 'joseph.ingrasio', 'NoPasswordExists', 0, 'Joseph', 'Ingrasio', '[HOUSE NUMBER : ''234'', STREET NAME : ''MacArthur'', STREET SUFIX : ''Blvd.'', PROVINCE : ''Ontario'', COUNTRY : '''', POSTAL CODE : ''HJFGHJ'']', 'joeingrasio@coldmail.com', '(519) 534-4564');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
