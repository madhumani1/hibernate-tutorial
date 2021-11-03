CREATE DATABASE  IF NOT EXISTS `hb_employee_tracker`;
USE `hb_employee_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE hb_employee_tracker.employee AUTO_INCREMENT=1;

delete FROM hb_employee_tracker.employee where id>0;
commit;


--
-- How to add date
-- Make use of a combination of Java's date formatting class and Hibernate annotations.
--
-- Alter database table for student
ALTER TABLE `hb_employee_tracker`.`employee` 
ADD COLUMN `date_of_birth` DATETIME NULL AFTER `last_name`;
-- Add a date utils class for parsing and formatting dates
-- Add date field to Student class
-- Add toString method to Student class
-- Update CreateStudentDemo
--
--