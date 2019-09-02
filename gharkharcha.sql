-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2019 at 01:05 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gharkharcha`
--

-- --------------------------------------------------------

--
-- Table structure for table `electricity`
--

CREATE TABLE `electricity` (
  `ElectricityID` int(10) NOT NULL,
  `FirstRead` int(10) DEFAULT NULL,
  `SecondRead` int(10) DEFAULT NULL,
  `AddedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electricity`
--

INSERT INTO `electricity` (`ElectricityID`, `FirstRead`, `SecondRead`, `AddedOn`) VALUES
(11, 123, 129, NULL),
(19, 129, 140, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `expdaily`
--

CREATE TABLE `expdaily` (
  `ExpDailyID` int(10) NOT NULL,
  `CategoryName` varchar(256) DEFAULT NULL,
  `CategoryPrice` int(10) DEFAULT NULL,
  `AddedOn` datetime(6) DEFAULT current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expdaily`
--

INSERT INTO `expdaily` (`ExpDailyID`, `CategoryName`, `CategoryPrice`, `AddedOn`) VALUES
(17, 'Bus Fare', 45, '2019-09-02 16:48:32.602173');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `RentID` int(20) NOT NULL,
  `RentPrice` int(20) NOT NULL,
  `Month` datetime(6) DEFAULT current_timestamp(6),
  `PaidDate` datetime(6) DEFAULT current_timestamp(6),
  `PaidStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`RentID`, `RentPrice`, `Month`, `PaidDate`, `PaidStatus`) VALUES
(19, 4534, '2019-09-02 16:43:26.057334', '2019-09-02 16:43:26.057334', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electricity`
--
ALTER TABLE `electricity`
  ADD PRIMARY KEY (`ElectricityID`);

--
-- Indexes for table `expdaily`
--
ALTER TABLE `expdaily`
  ADD PRIMARY KEY (`ExpDailyID`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`RentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `electricity`
--
ALTER TABLE `electricity`
  MODIFY `ElectricityID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `expdaily`
--
ALTER TABLE `expdaily`
  MODIFY `ExpDailyID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `RentID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
