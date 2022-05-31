-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2022 at 10:38 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ustep_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `crs_id` int(11) NOT NULL,
  `course_title` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`crs_id`, `course_title`) VALUES
(1, 'BSIT'),
(2, 'BSMB'),
(3, 'BS-TLE'),
(4, 'BEED'),
(5, 'BSARMT'),
(6, 'DIT'),
(7, 'BSF-Fishes Processing\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `rec_id` int(11) NOT NULL,
  `stud_no_id` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `course` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `s_year_id` int(11) NOT NULL,
  `sem_no_id` int(11) NOT NULL,
  `taken` int(11) DEFAULT NULL,
  `subject_id` int(11) NOT NULL,
  `grades` int(11) NOT NULL,
  `stat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`rec_id`, `stud_no_id`, `name`, `course`, `s_year_id`, `sem_no_id`, `taken`, `subject_id`, `grades`, `stat`) VALUES
(7, 32, 'asdasdasdasd', 'BSIT', 1, 1, NULL, 2, 2, 1),
(10, 32, 'asdasdasdasd', 'BSMB', 1, 1, NULL, 2, 2, 1),
(14, 32, 'asdasdasdasd', 'BSIT', 1, 1, NULL, 3, 1, 1),
(15, 32, 'asdasdasdasd', 'BSIT', 1, 1, NULL, 1, 1, 1),
(16, 32, 'asdasdasdasd', 'BSIT', 1, 1, NULL, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `grading`
--

CREATE TABLE `grading` (
  `grd_id` int(11) NOT NULL,
  `grds` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `grading`
--

INSERT INTO `grading` (`grd_id`, `grds`) VALUES
(1, '2.3'),
(2, '2.6');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `access` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `uname` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `pword` varchar(250) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `name`, `access`, `uname`, `pword`) VALUES
(1, 'admin', '', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `mark`
--

CREATE TABLE `mark` (
  `mark_id` int(11) NOT NULL,
  `marking` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `mark`
--

INSERT INTO `mark` (`mark_id`, `marking`) VALUES
(1, 'Passed'),
(2, 'Failed'),
(3, 'Summer'),
(4, 'Drop');

-- --------------------------------------------------------

--
-- Table structure for table `remark`
--

CREATE TABLE `remark` (
  `rem_id` int(11) NOT NULL,
  `rmrk` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `remark`
--

INSERT INTO `remark` (`rem_id`, `rmrk`) VALUES
(1, 'Graduate'),
(2, 'New Student'),
(3, 'Old Student'),
(4, 'Under Graduate'),
(5, 'Repeater'),
(6, 'Returnee'),
(7, 'Transferee');

-- --------------------------------------------------------

--
-- Table structure for table `schl_year`
--

CREATE TABLE `schl_year` (
  `sy_id` int(11) NOT NULL,
  `sy_year` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `schl_year`
--

INSERT INTO `schl_year` (`sy_id`, `sy_year`) VALUES
(1, '2016-2017'),
(2, '2015-2016');

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `sem_id` int(11) NOT NULL,
  `semester_description` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`sem_id`, `semester_description`) VALUES
(1, '1st year - 1st Semester'),
(2, '1st year - second Semester'),
(3, '2nd year - 1st Semester'),
(4, '2nd year - 2nd Semester'),
(5, '3rd year - 1st Semester'),
(6, '3rd year - 2nd Semester'),
(7, '4th year- 1st Semester'),
(8, '4th year - 2nd Semester'),
(9, 'Summer');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE `student_info` (
  `stud_no` int(11) NOT NULL,
  `stud_id` bigint(100) DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` bigint(20) DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `course_id` int(11) NOT NULL,
  `remarks_id` int(11) NOT NULL,
  `elementary` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `high_school` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `college` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BOR` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`stud_no`, `stud_id`, `name`, `birthday`, `address`, `gender`, `status`, `contact`, `email`, `course_id`, `remarks_id`, `elementary`, `high_school`, `college`, `BOR`) VALUES
(1, 32, 'asdasdasdasd', '2022-05-06', 'dsadasdsa', 'Male', 'Single', 36853678678, 'dasdasdasd', 1, 2, 'asdasdasd', 'asdasdasd', 'University of Science and Technology of Southern Philippines', NULL),
(2, 2018100335, 'Jobet Casquejo', '1998-05-22', 'sadasd', 'Male', 'Single', 123123123, 'asdasdas', 1, 3, 'asdasd', 'asdasd', 'University of Science and Technology of Southern Philippines', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `subject_No` int(11) NOT NULL,
  `crse_id` int(11) DEFAULT NULL,
  `sems_id` int(11) DEFAULT NULL,
  `Subject_Code` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Credits` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`subject_No`, `crse_id`, `sems_id`, `Subject_Code`, `Description`, `Credits`) VALUES
(1, 1, 1, 'IT 10', 'IT Fundamentals', 4),
(2, 1, 1, 'IT 11', 'Office Productivity Tools 1', 4),
(3, 1, 1, 'MATH 13A', 'College Algebra', 5),
(4, 1, 1, 'ENG 11', 'Study & Thinking Skills', 3),
(5, 1, 1, 'FIL 11', 'Sining ng Pakikipagtalastan', 3),
(6, 1, 1, 'PE 10', 'Physical Fitness', 2),
(7, 1, 1, 'NSTP 10', 'ROTC/CWTS/LTS 1', 3),
(8, 1, 1, 'DRWG 10A', 'Fundamentals of Drawing ', 2),
(9, 1, 2, 'IT 12', 'IT Fundamentals 2', 4),
(10, 1, 2, 'IT 13', 'Electronics 2', 4),
(11, 1, 2, 'MATH 17', 'Plane Trigonometry', 3),
(12, 1, 2, 'ENGL 20', 'Writing Across Disciplines ', 3),
(13, 1, 2, 'CHEM 10A', 'General Chemistry 1', 3),
(14, 1, 2, 'FIL 20', 'Pagbasa at Pagsulat Tungo sa Pananaliksik', 3),
(15, 1, 2, 'PE 20', 'Rhythmic Activities', 2),
(16, 1, 2, 'NSTP 20', 'ROTC/CWTS/LTS 2', 3),
(17, 1, 3, 'IT 20', 'Fundamentals of Web Design', 3),
(18, 1, 3, 'IT 21', 'Data Structures and Algorithms', 4),
(19, 1, 3, 'IT 22', 'PC Hardware and Software', 3),
(20, 1, 3, 'MATH 61', 'Discrete Mathematics ', 3),
(21, 1, 3, 'ENGL 30', 'Speech & Oral Communication', 3),
(22, 1, 3, 'HUM 11B', 'Logic & Ethics', 3),
(23, 1, 3, 'SS 10A', 'New Constitution ', 3),
(24, 1, 3, 'CADD 10B', 'Basic CADD', 2),
(25, 1, 3, 'PE 30', 'Individual/Dual Games', 2),
(26, 1, 4, 'IT 23', 'System Analysis and Design', 4),
(27, 1, 4, 'IT 24', 'Operating System', 4),
(28, 1, 4, 'IT 25', 'CCNA 1 Networking Basics', 4),
(29, 1, 4, 'PHYS 11', 'General Physics 1-Mechanics and Heat', 4),
(30, 1, 4, 'ENG 40', 'Technical Writing & Reporting', 3),
(31, 1, 4, 'SS 20A', 'Rizal Life, Works & Writing', 3),
(32, 1, 4, 'PE 40A', 'Team Sports ', 2),
(33, 1, 5, 'IT 30', 'Database Management 1', 4),
(34, 1, 5, 'IT 31', 'Linux Installation and Administration', 3),
(35, 1, 5, 'IT 32', 'CCNA 2: Routers and Routing Basics', 4),
(36, 1, 5, 'IT 33', 'Computer Interfacing ', 4),
(37, 1, 5, 'ENVI 10', 'Environmental Science ', 3),
(38, 1, 5, 'ENGL 54', 'Culture, Arts & Literature', 3),
(39, 1, 5, 'HUM 30', 'Introduction to Philosophy', 3),
(40, 1, 6, 'IT 34', 'Database Management 2', 4),
(41, 1, 6, 'IT 35', 'Object Oriented Programming 1', 4),
(42, 1, 6, 'IT 36', 'Management Information System', 3),
(43, 1, 6, 'IT 37', 'CCNA 3:Switching Basic and Intermediate Routing ', 4),
(44, 1, 6, 'IT 38', 'Elective 1', 4),
(45, 1, 6, 'MATH36', 'Probability & Statistics', 3),
(46, 1, 6, 'Summer IT 39', 'Internship 1', 3),
(47, 1, 7, 'IT 40', 'Project Design/Study', 4),
(48, 1, 7, 'IT 41', 'Object Oriented Programming 2', 4),
(49, 1, 7, 'IT 42', 'CCNA 4:WAN Technologies', 4),
(50, 1, 7, 'IT 43', 'Elective 2', 4),
(51, 1, 7, 'SS 13', 'Philippine History', 3),
(52, 1, 7, 'SS 30', 'General Economics Taxation & Agrarian Reform', 3),
(53, 1, 7, 'PHYSC 20', 'Applied Psychology', 3),
(54, 1, 8, 'IT 44', 'Project Implementation', 5),
(55, 1, 8, 'IT 45', 'Internship 2', 3),
(56, 1, 8, 'IT 46', 'Field Trips/Seminars', 1),
(57, 2, 1, 'ENG 10', 'Study & Thinking Skills', 3),
(58, 2, 1, 'Math 10', 'Col.Algebra & Plane Trigo.', 6),
(59, 2, 1, 'CHEM 10', 'General and Inorganic Chemistry', 4),
(60, 2, 1, 'MB 12', 'Eco. Of Marine Plants & Ani.', 4),
(61, 2, 1, 'PE 10', 'Physical Fitness', 2),
(62, 2, 1, 'NSTP 1', 'Nat.Serv. Training Prog.', 3),
(63, 2, 2, 'ENG 20', 'Writing Across Discipline ', 3),
(64, 2, 2, 'CHEM 12', 'Quali/Quanti Chemistry', 4),
(65, 2, 2, 'MB 14', 'Marine Vertebrates', 4),
(66, 2, 2, 'CSC 1', 'Computer 1', 3),
(67, 2, 2, 'PHYSICS 10', 'Gen. Physics 1', 3),
(68, 2, 2, 'PE 20', 'Rhythmic Activities', 2),
(69, 2, 2, 'NSTP 2', 'Nat.Serv. Training Prog.', 3),
(70, 2, 3, 'ENG 30', 'Oral & Written Communication', 3),
(71, 2, 3, 'MATH 30', 'Diff. Calculus w/Anal. Geo.', 5),
(72, 2, 3, 'GIS 1', 'Geo. Info.System 1', 3),
(73, 2, 3, 'MB 16', 'Intro to Marine Biodiversity', 4),
(74, 2, 3, 'MB 18', 'Marine Invertebrates', 4),
(75, 2, 3, 'SOC.SCI 10', 'New Constitution', 3),
(76, 2, 3, 'PE 30', 'Individual/Dual Games', 2),
(77, 2, 4, 'ENG 50', 'Intro to Literature', 3),
(78, 2, 4, 'MATH 31', 'Integral Calculus', 5),
(79, 2, 4, 'GIS 2', 'Geo. Info.System 2', 3),
(80, 2, 4, 'PHYSICS 11', 'General Physics 2', 3),
(81, 2, 4, 'SOC.SCI 20', 'Rizal\'s Life, Works & Writings', 3),
(82, 2, 4, 'HUM 10', 'Logic & Ethics', 3),
(83, 2, 4, 'PD 10', 'Essence of Personality', 1),
(84, 2, 5, 'ENG 40', 'Technical Writing & Reporting', 3),
(85, 2, 5, 'MB 22', 'Marine Ecosystem', 4),
(86, 2, 5, 'MB 24', 'Phys. & Morpho. Of Mar. Anim.', 4),
(87, 2, 5, 'MB 26', 'Phys 1 & Chem 1 Oceanog.', 4),
(88, 2, 5, 'MB 28', 'Mariculture', 4),
(89, 2, 5, 'SOC.SCI 30', 'Gen. Econ. Agr. Ref. & Taxation', 3),
(90, 2, 5, 'PD 20', 'Soc. Graces & Soc. Relation', 1),
(91, 2, 5, 'HUM 20', 'Culture, Art & Literature', 3),
(92, 2, 6, 'ENG 60', 'Effective Speech ', 3),
(93, 2, 6, 'MB 30', 'Marine Bio Modeling 1', 4),
(94, 2, 6, 'MB 32', 'Marine Natural Products ', 4),
(95, 2, 6, 'MB 34', 'Biological Research Method', 3),
(96, 2, 6, 'MB 36', 'Marine Fishes', 4),
(97, 2, 6, 'MB 38', 'Genetics, Evol. & Systematic', 3),
(98, 2, 6, 'SOC.SCI 40', 'Applied Psychology', 3),
(99, 2, 9, 'OJT         ', ' Supervised On-the-Job-Training ', 12),
(100, 2, 7, 'MB 40', 'Integrated CRM', 4),
(101, 2, 7, 'MB 42', 'General Microbiology', 4),
(102, 2, 7, 'MB 44', 'Marine Mammals', 4),
(103, 2, 7, 'MB 46', 'Geo. Mappings', 3),
(104, 2, 7, 'MB 48', 'Marine Bio Modeling 2', 3),
(105, 2, 8, 'MB 50', 'Biotechnology', 3),
(106, 2, 8, 'MB 52', 'Undergraduate Thesis', 6),
(107, 3, 1, 'TLE 10', 'Foods 1-Food Selection, Preparation & Cooking', 4),
(108, 3, 1, 'TLE 21', 'Fishery Arts', 4),
(109, 3, 1, 'EDU 10', 'The Teaching Profession', 3),
(110, 3, 1, 'ENGL 11', 'Study & Thinking Skills', 3),
(111, 3, 1, 'FIL 10', 'Komunikasyon sa Akademikong Filipino', 3),
(112, 3, 1, 'MATH 10A', 'Fundamentals of Mathematics', 3),
(113, 3, 1, 'CHEM 10A', 'General Chemistry 1', 3),
(114, 3, 1, 'PE 10', 'Physical Fitness', 2),
(115, 3, 2, 'TLE 11', 'Foods 2 â€“ Baking', 4),
(116, 3, 2, 'TLE 30', 'Architectural Drafting', 4),
(117, 3, 2, 'EDU 20', 'Child & Adolescent Development', 3),
(118, 3, 2, 'EDU 70', 'Field Study 1-Learnerâ€™s Development & Environment', 1),
(119, 3, 2, 'ENGL 12', 'Development Reading 1', 3),
(120, 3, 2, 'ENGL 20', 'Writing Across Disciplines ', 3),
(121, 3, 2, 'FIL 20', 'Pagbasa at Pagsulat Tungo sa Pananaliksik', 3),
(122, 3, 2, 'MATH 11', 'Contemporary Mathematics', 3),
(123, 3, 2, 'PE 20', 'Rhythmic Activities', 2),
(124, 3, 3, 'TLE 20A', 'Agricultural Arts 1', 4),
(125, 3, 3, 'TLE 80', 'Basic Electricity', 4),
(126, 3, 3, 'EDU 40', 'Facilitating Learning', 3),
(127, 3, 3, 'EDU 71', 'Field Study 2 â€“ On Being a Teacher', 1),
(128, 3, 3, 'FIL 30', 'Masining na Pagpapahayag', 3),
(129, 3, 3, 'MATH 12', 'Business Mathematics', 3),
(130, 3, 3, 'PSYC 10', 'General Psychology', 3),
(131, 3, 3, 'PE 30', 'Individual/Dual Games', 2),
(132, 3, 3, 'NSTP 10', 'ROTC/CWTS/LTS 1', 3),
(133, 3, 4, 'TLE 50', 'Graphics Science & Arts', 4),
(134, 3, 4, 'EDU 41', 'Principles of Teaching 1', 3),
(135, 3, 4, 'EDU 60', 'Assessment of Student Learning 1', 3),
(136, 3, 4, 'EDU 72', 'Field Study 3-Experiencing Teaching Learning Process', 1),
(137, 3, 4, 'ENTREP 10', 'Entrepreneurship', 3),
(138, 3, 4, 'RES 10', 'Introduction to Educational Research', 3),
(139, 3, 4, 'BIO 11', 'Biological Science', 3),
(140, 3, 4, 'PE 40A', 'Team Sports ', 2),
(141, 3, 4, 'TLE 90', 'Basic Electronics', 4),
(142, 3, 4, 'JEEP 01', 'English Proficiency Start 01', 4),
(143, 3, 4, 'NSTP 20', 'ROTC/CWTS/LTS 2', 3),
(144, 3, 5, 'TLE 12', 'Foods 3 â€“ Food Processing', 4),
(145, 3, 5, 'TLE 60', 'Basic Carpentry & Plumbing', 4),
(146, 3, 5, 'TLE 70', 'Metal works & Welding', 4),
(147, 3, 5, 'EDU 31', 'Curriculum Development', 3),
(148, 3, 5, 'EDU 42', 'Principles of Teaching 2', 3),
(149, 3, 5, 'EDU 61', 'Assessment of Student Learning 2', 3),
(150, 3, 5, 'EDU 73', 'Field Study 4 â€“ Learning Assessment Strategies', 1),
(151, 3, 5, 'RES 20', 'Research Statistics', 3),
(152, 3, 5, 'JEEP 02', 'English Proficiency Start 02', 4),
(153, 3, 6, 'TLE 20B', 'Agricultural Arts 2', 4),
(154, 3, 6, 'TLE 40A', 'Clothing & Grooming 1', 4),
(155, 3, 6, 'TLE 51', 'Handicrafts', 4),
(156, 3, 6, 'EDU 50', 'Educational Technology 1', 3),
(157, 3, 6, 'EDU 74', 'Field Study 5 â€“ Tech. in the Learning Environment', 1),
(158, 3, 6, 'EDU 80', 'Special Topics', 3),
(159, 3, 6, 'ENGL 51', 'Philippine Literature', 3),
(160, 3, 6, 'ENGL 54', 'Culture, Arts & Literature', 3),
(161, 3, 6, 'JEEP 03', 'English Proficiency Accelerate 01', 4),
(162, 3, 6, 'SS 10A', 'New Constitution ', 3),
(163, 3, 7, 'TLE 41', 'Clothing & Grooming 2', 4),
(164, 3, 7, 'EDU 30', 'Social Dimensions of Education', 3),
(165, 3, 7, 'EDU 51', 'Educational Technology 2', 3),
(166, 3, 7, 'EDU 75', 'Field Study 6 â€“ Exploring the Curriculum ', 1),
(167, 3, 7, 'ENGL 52', 'World Literature', 3),
(168, 3, 7, 'ENV110', 'Environmental Science', 3),
(169, 3, 7, 'SS 30', 'General Economics Taxation & Agrarian Reform', 3),
(170, 3, 7, 'SS 20A', 'Rizal Life, Works & Writing', 3),
(171, 3, 7, 'JEEP 04', 'English Proficiency Accelerate 02', 4),
(172, 3, 7, 'HUM 11B', 'Logic & Ethics', 3),
(173, 3, 8, 'EDU 90A', 'Student Teaching', 6),
(174, 3, 8, 'EDU 91', 'Seminars on Problems Met', 3),
(175, 4, 1, ' English 101', 'Study and Thinking Skills', 3),
(176, 4, 1, ' English 100', 'English Grammar and Language Skills', 3),
(177, 4, 1, ' Math 101', 'Fundamentals of Mathematics', 3),
(178, 4, 1, ' Filipino 10', 'Sining ng Pakikipagtalastasan', 3),
(179, 4, 1, ' Soc. Sci.10', 'General Psychology', 3),
(180, 4, 1, ' Pol Sci. 10', 'Politics, Governance w/ Phil. Constitution', 3),
(181, 4, 1, ' Bio 100', 'Intro to Biological Science', 3),
(182, 4, 1, ' PE 101', 'Self-Testing Activities', 2),
(183, 4, 1, ' NSTP 101', 'CWTS/ROTC/CTS', 3),
(184, 4, 2, ' English 102', 'Writing for Academic Purposes', 3),
(185, 4, 2, ' Filipino 10', 'Pagbasa\'t Pagsulat sa Iba\'t Ibang Disiplina', 3),
(186, 4, 2, ' Ed 121', 'Child and Adolesecent Development', 3),
(187, 4, 2, ' Math 102', 'Contemporary Math', 3),
(188, 4, 2, ' Phy. Sci. 1', 'Earth Science', 3),
(189, 4, 2, ' Ed 122', 'Developmental Reading', 3),
(190, 4, 2, ' PE 102', 'Fundamentals of Rhythmic Activities', 2),
(191, 4, 2, ' NSTP 102', 'CWTS/ROTC/CTS', 3),
(192, 4, 9, ' Lit 101', 'Philippine Literature', 3),
(193, 4, 9, ' Soc. Sci.10', 'Phil.History, Roots and Development', 3),
(194, 4, 9, '  Soc. Sci. ', 'Basic Econ., Taxation and Agrarian Reform', 3),
(195, 4, 3, ' Ed 123', 'Facilitating Learning', 3),
(196, 4, 3, ' Ed 122', 'Developmental Reading', 3),
(197, 4, 3, ' Ed 124', 'Social Dimensions of Education', 3),
(198, 4, 3, 'ICT 101', 'Basic ICT Application', 3),
(199, 4, 3, 'English 103', 'Interactive Engl.,Listening and Speaking and Grammar', 3),
(200, 4, 3, ' Filipino 10', 'Masining na Pagpapahayag', 3),
(201, 4, 3, ' Filipino 10', 'Ang Panitikan ng Pilipinas', 3),
(202, 4, 3, ' PE 103', 'Recreational Outdoor Activities', 2),
(203, 4, 4, ' Ed 128', 'The Teaching Profession', 3),
(204, 4, 4, ' Ed 126', 'Principles of Teaching 1', 4),
(205, 4, 4, ' Ed 127', 'Educational Technology 1', 4),
(206, 4, 4, ' Hum 101', 'Music and Arts', 3),
(207, 4, 4, ' English 104', 'The Teaching of Children\'s Literature', 3),
(208, 4, 4, ' Math 103', 'Advanced Algebra and Trigonometry', 3),
(209, 4, 4, ' Sci. 103', 'Inorganic Chemistry', 3),
(210, 4, 4, ' PE 104', 'Fundamentals Skills in Games and Sports', 2),
(211, 4, 9, 'Lit 102', 'Masterpieces of World Literature', 0),
(212, 4, 9, ' Soc. Sci 12', 'Society Culture w/ Family Planning', 3),
(213, 4, 9, ' Soc. Sci. 1', 'Life and Works of Rizal', 3),
(214, 4, 5, ' Ed 129', 'Principles of Teaching 2', 4),
(215, 4, 5, ' Ed 130', 'Educational Technology 2', 4),
(216, 4, 5, ' Ed 131', 'Teaching Multigrade Clases', 3),
(217, 4, 5, ' Hum 102', 'Logic', 3),
(218, 4, 5, ' English 105', 'Introduction to Linguistics', 3),
(219, 4, 5, ' Filipino 10', 'Mga Anyong Kontem. Panitikan', 3),
(220, 4, 5, ' Math 104', 'Plane and Solid Geometry', 3),
(221, 4, 5, ' Sci. 104', 'Physics for Health Science', 3),
(222, 4, 5, ' FS 1', 'The Learners Development & Development', 1),
(223, 4, 5, ' FS 2', 'Experiencing the Teaching Learning Process', 1),
(224, 4, 5, ' FS 3', 'Technology in the Learning  Environment', 1),
(225, 4, 6, ' Ed 132', 'Assessment of Learning 1', 4),
(226, 4, 6, ' Ed 133', 'Curriculum Development', 3),
(227, 4, 6, ' Eng 106', 'The Structure of English', 3),
(228, 4, 6, ' Filipino106', 'Pagpapahalagang Pampanitikan', 3),
(229, 4, 6, ' Math 105', 'Analytical Geometry and Intro to Calculus', 3),
(230, 4, 6, ' Sci. 105', 'Ecology', 3),
(231, 4, 6, ' Soc. Sci. 1', 'Basic Geography', 3),
(232, 4, 6, ' FS 4', 'Understanding Curriculum Development', 1),
(233, 4, 6, ' FS 5', 'Learning Assesment Strategies', 1),
(234, 4, 6, ' FS 6', 'On Becoming a Teacher', 1),
(235, 4, 7, ' Ed 134', 'Assessment of Learning 2', 3),
(236, 4, 7, ' English 107', 'English for Specific Purposes', 3),
(237, 4, 7, ' Math 106', 'Problem Solving', 3),
(238, 4, 7, ' Sci. 106', 'Astronomy', 3),
(239, 4, 7, ' Soc. Sci. 1', 'Geographical and Natural Resources', 3),
(240, 4, 7, ' Val. Ed 101', 'Values Education', 3),
(241, 4, 7, ' Ed 115', 'Teachnical Multicultural Classroom', 3),
(242, 4, 7, ' Mape 101', 'Foundation of MAPE', 3),
(243, 4, 8, ' Ed 19', 'On-Campus Teaching', 6),
(244, 4, 8, ' Ed 20', 'Off-Campus Teaching', 6),
(245, 5, 1, 'ENG 10', 'Study & Thinking Skills', 3),
(246, 5, 1, 'MATH 10', 'Col.Algebra & Plane Trigo.', 6),
(247, 5, 1, 'BIO 10', 'General Aquatic Biology', 4),
(248, 5, 1, 'CHEM 10', 'General and Inorganic Chemistry', 4),
(249, 5, 1, 'AR 111', 'Aquatic Ecology', 3),
(250, 5, 1, 'PE 10', 'Physical Fitness', 2),
(251, 5, 1, 'NSTP 1', 'Nat.Serv. Training Prog.', 3),
(252, 5, 2, 'ENG 20', 'Writing Across Discipline ', 3),
(253, 5, 2, 'MATH 30', 'Diff. Calculus w/Anal. Geo.', 5),
(254, 5, 2, 'CHEM 20', 'Organic Chemistry', 4),
(255, 5, 2, 'AR 112', 'Aquatic Vert. & Invert.', 3),
(256, 5, 2, 'PHYS 10', 'Gen. Physics 1', 3),
(257, 5, 2, 'PE 20', 'Rhythmic Activities', 2),
(258, 5, 2, 'NSTP 2', 'Nat.Serv. Training Prog. 2', 3),
(259, 5, 3, 'ENG 30', 'Oral & Written Communication', 3),
(260, 5, 3, 'MATH 31', 'Integral Calculus', 5),
(261, 5, 3, 'CHEM 30', 'Biochemistry', 4),
(262, 5, 3, 'AR 113', 'Geographic Mapping ', 4),
(263, 5, 3, 'AR 114', 'Brackish Water Aquaculture', 4),
(264, 5, 3, 'SOC.SCI 10', 'New Constitution', 3),
(265, 5, 3, 'PE 30', 'Individual/Dual Games', 2),
(266, 5, 4, 'ENG 50', 'Intro to Literature', 3),
(267, 5, 4, 'MATH 63', 'Linear Algebra', 3),
(268, 5, 4, 'CSC 1', 'Computer 1', 3),
(269, 5, 4, 'PHYSICS 11', 'General Physics 2', 3),
(270, 5, 4, 'AR 115', 'Mariculture', 4),
(271, 5, 4, 'SOC.SCI 20', 'Rizal\'s Life, Works & Writings', 3),
(272, 5, 4, 'HUM 10', 'Logic & Ethics', 3),
(273, 5, 4, 'PD 10', 'Essence of Personality', 1),
(274, 5, 4, 'PE 40', 'Team Sports & Games', 2),
(275, 5, 5, 'ENG 40', 'Technical Writing & Reporting', 3),
(276, 5, 5, 'STAT 10', 'Biostatistics', 3),
(277, 5, 5, 'CSC 20', 'Geo. Info System 1', 3),
(278, 5, 5, 'AR 116', 'Fish Natr. & Health Mgt.', 4),
(279, 5, 5, 'AR 117', 'General Genetics', 4),
(280, 5, 5, 'SOC.SCI 30', 'Gen. Econ. Agr. Ref. & Taxation', 3),
(281, 5, 5, 'HUM 20', 'Culture, Art & Literature', 3),
(282, 5, 5, 'PD 20', 'Soc. Graces & Soc. Relation', 1),
(283, 5, 6, 'Eng 60', 'Effective Speech ', 3),
(284, 5, 6, 'AR 118', 'Biomodeling 1', 3),
(285, 5, 6, 'CSC 30', 'Geo. Info System 2', 3),
(286, 5, 6, 'AR 119', 'Method of Research', 3),
(287, 5, 6, 'AR 120', 'Freshwater & Marine Fish Prod.', 4),
(288, 5, 6, 'BIOSTAT 20', 'Biotechnology', 3),
(289, 5, 6, 'SOC.SCI 40', 'Applied Psychology', 3),
(290, 5, 6, 'AR 121', 'Integrated CRM', 3),
(291, 5, 9, 'OJT', 'Supervised On-the-Job-Training ', 12),
(292, 5, 7, 'AR 122', 'Fish Brdng. & Hatchery Mgt.', 4),
(293, 5, 7, 'AR 123', 'Fish Handl. & Qual. Control', 4),
(294, 5, 7, 'AR 124', 'Fish Law, Rules & Regulation', 3),
(295, 5, 7, 'AR 125', 'Aquatic Ecosystem Mgt.', 3),
(296, 5, 7, 'AR 126', 'Biomodeling 2', 3),
(297, 5, 7, 'AR 127', 'Experimental Design', 3),
(298, 5, 7, 'BM', 'Entrepreneurship', 3),
(299, 5, 8, 'AR 128', 'Aquatic Food Pro. Pract.', 4),
(300, 5, 8, 'AR 129', 'Aquatic Microbiology', 4),
(301, 5, 8, 'AR 130', 'Community Organization', 3),
(302, 5, 8, 'AR 131', 'Action Research ', 4),
(303, 6, 1, 'IT10', 'Basic Computer Concepts', 3),
(304, 6, 1, 'IT11', 'Office Productivity Tools 1', 3),
(305, 6, 1, 'IT13', 'Fundamentals of Programming with Applications 1', 4),
(306, 6, 1, 'MATH11', 'College Algebra', 5),
(307, 6, 1, 'ENG10', 'Study and Thinking Skills', 3),
(308, 6, 1, 'PD10', 'Essence of Personality', 1),
(309, 6, 1, 'NSTP10', 'ROTC/CWTS/LTS 1', 3),
(310, 6, 2, 'IT14', 'Computer Programming 1', 6),
(311, 6, 2, 'IT15', 'Office Productivity Tools 2', 3),
(312, 6, 2, 'IT16', 'Basic Electronics', 4),
(313, 6, 2, 'DRAWING20', 'Elementary Project Design', 1),
(314, 6, 2, 'ENG20', 'Writing Across Discipline', 3),
(315, 6, 2, 'PD20', 'Social Graces and Social Relations', 1),
(316, 6, 2, 'NSTP 11', 'ROTC/CWTS/LTS 2', 3),
(317, 6, 3, 'IT20', 'Computer Programming 2', 6),
(318, 6, 3, 'IT21', 'Office Productivity Tools 3', 3),
(319, 6, 3, 'IT22', 'Logic Circuits and Switching Theory', 4),
(320, 6, 3, 'ENG31', 'Oral Communication', 3),
(321, 6, 3, 'CADD10', 'Basic CADD', 1),
(322, 6, 3, 'PHYSICS10', 'General Physics Mechanics & Heat', 4),
(323, 6, 4, 'IT25', 'Microprocessor with Assembly Language', 4),
(324, 6, 4, 'IT24', 'Computer Programming 3', 6),
(325, 6, 4, 'ENG40', 'Technical Writing and Reporting', 3),
(326, 6, 4, 'MATH12', 'Plane Trigonometry', 3),
(327, 6, 4, 'SOC.SCI 10', 'New Constitution', 3),
(328, 6, 4, 'INTERNSHIP', 'Internship Program', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`crs_id`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`rec_id`),
  ADD KEY `stud_no_id` (`stud_no_id`,`s_year_id`,`sem_no_id`,`subject_id`,`grades`,`stat`),
  ADD KEY `s_year_id` (`s_year_id`),
  ADD KEY `sem_no_id` (`sem_no_id`),
  ADD KEY `grades` (`grades`),
  ADD KEY `stat` (`stat`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `grading`
--
ALTER TABLE `grading`
  ADD PRIMARY KEY (`grd_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mark`
--
ALTER TABLE `mark`
  ADD PRIMARY KEY (`mark_id`);

--
-- Indexes for table `remark`
--
ALTER TABLE `remark`
  ADD PRIMARY KEY (`rem_id`);

--
-- Indexes for table `schl_year`
--
ALTER TABLE `schl_year`
  ADD PRIMARY KEY (`sy_id`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`sem_id`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`stud_no`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `remarks_id` (`remarks_id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_No`),
  ADD KEY `Credits_index` (`Credits`),
  ADD KEY `crse_id` (`crse_id`,`sems_id`),
  ADD KEY `sems_id` (`sems_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `crs_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `rec_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `grading`
--
ALTER TABLE `grading`
  MODIFY `grd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `mark`
--
ALTER TABLE `mark`
  MODIFY `mark_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `remark`
--
ALTER TABLE `remark`
  MODIFY `rem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `schl_year`
--
ALTER TABLE `schl_year`
  MODIFY `sy_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
  MODIFY `sem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `stud_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `grades`
--
ALTER TABLE `grades`
  ADD CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`s_year_id`) REFERENCES `schl_year` (`sy_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`sem_no_id`) REFERENCES `semester` (`sem_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grades_ibfk_3` FOREIGN KEY (`grades`) REFERENCES `grading` (`grd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grades_ibfk_4` FOREIGN KEY (`stat`) REFERENCES `mark` (`mark_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grades_ibfk_5` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_No`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student_info`
--
ALTER TABLE `student_info`
  ADD CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`crs_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_info_ibfk_2` FOREIGN KEY (`remarks_id`) REFERENCES `remark` (`rem_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`crse_id`) REFERENCES `courses` (`crs_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `subjects_ibfk_2` FOREIGN KEY (`sems_id`) REFERENCES `semester` (`sem_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
