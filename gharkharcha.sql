-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2019 at 06:14 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

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

-- --------------------------------------------------------

--
-- Table structure for table `expdaily`
--

CREATE TABLE `expdaily` (
  `ExpDailyID` int(10) NOT NULL,
  `CategoryName` varchar(256) DEFAULT NULL,
  `CategoryPrice` int(10) DEFAULT NULL,
  `AddedOn` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `RentID` int(20) NOT NULL,
  `RentPrice` int(20) NOT NULL,
  `Month` datetime(6) DEFAULT CURRENT_TIMESTAMP(6),
  `PaidDate` datetime(6) DEFAULT CURRENT_TIMESTAMP(6),
  `PaidStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`RentID`, `RentPrice`, `Month`, `PaidDate`, `PaidStatus`) VALUES
(1, 242, '0000-00-00 00:00:00.000000', '0000-00-00 00:00:00.000000', 0),
(2, 3450, NULL, NULL, 0),
(3, 4500, '2019-08-27 09:07:32.803182', '2019-08-27 09:07:32.803182', 0),
(4, 34324, '2019-08-27 09:09:02.998990', '2019-08-27 09:09:02.998990', 1);

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
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `RentID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
