-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.16-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para empleados
CREATE DATABASE IF NOT EXISTS `empleados` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `empleados`;

-- Volcando estructura para tabla empleados.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FK_GENDER` (`gender_id`),
  KEY `FK_JOB` (`job_id`),
  CONSTRAINT `FK_GENDER` FOREIGN KEY (`gender_id`) REFERENCES `genders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_JOB` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla empleados.employees: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT IGNORE INTO `employees` (`id`, `gender_id`, `job_id`, `name`, `last_name`, `birthdate`) VALUES
	(2, 1, 1, 'nectar', 'suarez', '2017-06-15'),
	(9, 1, 1, 'test', 'ms', '2012-04-22'),
	(10, 1, 1, 'test', 'ms', '2004-03-11'),
	(11, 1, 1, 'test', 'ms', '2004-03-14'),
	(12, 1, 1, 'test', 'ms', '2004-03-14'),
	(13, 1, 1, 'test1', 'ms1', '2004-03-14'),
	(14, 2, 1, 'test2', 'ms2', '2004-03-14'),
	(15, 2, 1, 'test4', 'ms4', '2004-03-14'),
	(16, 1, 1, 'test5', 'ms5', '2000-02-29'),
	(17, 1, 1, 'test6', 'ms6', '2000-02-29'),
	(18, 1, 1, 'test7', 'ms7', '2000-02-29'),
	(19, 1, 1, 'test8', 'ms8', '2000-02-29'),
	(20, 1, 1, 'test9', 'ms9', '2000-02-29'),
	(21, 1, 1, 'test10', 'ms10', '2000-02-29'),
	(22, 1, 2, 'test11', 'ms11', '2000-02-29'),
	(23, 1, 2, 'test12', 'ms12', '2000-02-29'),
	(24, 1, 2, 'test13', 'ms13', '2000-02-29'),
	(25, 1, 2, 'test14', 'ms14', '2000-02-29');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;

-- Volcando estructura para tabla empleados.employee_worked_hours
CREATE TABLE IF NOT EXISTS `employee_worked_hours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `worked_hours` int(11) DEFAULT NULL,
  `worked_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FK_EMPLOYEE` (`employee_id`),
  CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla empleados.employee_worked_hours: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `employee_worked_hours` DISABLE KEYS */;
INSERT IGNORE INTO `employee_worked_hours` (`id`, `employee_id`, `worked_hours`, `worked_date`) VALUES
	(2, 2, 10, '2022-03-02'),
	(9, 2, 10, '2022-03-02'),
	(10, 2, 10, '2022-03-14'),
	(15, 2, 2, '2004-03-14'),
	(16, 2, 2, '2004-03-13'),
	(17, 9, 2, '2004-03-12'),
	(18, 9, 2, '2004-03-15'),
	(19, 9, 2, '2022-03-15'),
	(20, 19, 20, '2022-03-01'),
	(21, 19, 20, '2022-03-02'),
	(22, 19, 20, '2022-03-03'),
	(23, 19, 20, '2022-03-04'),
	(24, 20, 20, '2022-02-28'),
	(25, 20, 20, '2022-03-01'),
	(26, 21, 20, '2022-02-28'),
	(27, 22, 20, '2022-02-28'),
	(28, 24, 20, '2022-02-28'),
	(29, 24, 20, '2022-03-01'),
	(30, 24, 20, '2022-03-02');
/*!40000 ALTER TABLE `employee_worked_hours` ENABLE KEYS */;

-- Volcando estructura para tabla empleados.genders
CREATE TABLE IF NOT EXISTS `genders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla empleados.genders: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `genders` DISABLE KEYS */;
INSERT IGNORE INTO `genders` (`id`, `name`) VALUES
	(1, 'masculino'),
	(2, 'femenino');
/*!40000 ALTER TABLE `genders` ENABLE KEYS */;

-- Volcando estructura para tabla empleados.jobs
CREATE TABLE IF NOT EXISTS `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla empleados.jobs: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT IGNORE INTO `jobs` (`id`, `name`, `salary`) VALUES
	(1, 'test', 25),
	(2, 'programador', 30);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;

-- Volcando estructura para procedimiento empleados.existEmployee
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `existEmployee`(
	IN `inName` VARCHAR(255),
	IN `inLastName` VARCHAR(255),
	IN `inId` INT,
	OUT `outId` INT
)
BEGIN
	SELECT
		@aux := COUNT(emp.id)
	FROM
		empleados.employees emp
	WHERE (emp.name = inName OR emp.last_name = inLastName)
		OR (emp.id = inId);
		
		
	SET outId = @aux;
END//
DELIMITER ;

-- Volcando estructura para procedimiento empleados.existGenderJob
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `existGenderJob`(
	IN `inGenderId` INT,
	IN `inJobId` INT,
	OUT `outId` INT
)
BEGIN

	SELECT @gen := COUNT(*) FROM empleados.genders gen WHERE gen.id = inGenderId
	UNION
	SELECT @job := COUNT(*) FROM empleados.jobs job WHERE job.id = inJobId;
	
	
	SET outId = @gen + @job;
END//
DELIMITER ;

-- Volcando estructura para procedimiento empleados.GetEmployeeByJobId
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEmployeeByJobId`(
	IN `inJobId` INT
)
BEGIN
	
	SELECT
	 	emp.id EmployeeId,
		emp.name EmployeeName,
		emp.last_name EmployeeLastName,
		emp.birthdate EmployeeBirthdate,
		job.id JobId,
		job.name JobName,
		job.salary JobSalary,
		gen.id GenderId,
		gen.name GenderName
	FROM empleados.employees emp
	INNER JOIN empleados.jobs job ON (job.id = emp.job_id)
	INNER JOIN empleados.genders gen ON (gen.id = emp.gender_id)
	AND job.id = inJobId;
	
END//
DELIMITER ;

-- Volcando estructura para procedimiento empleados.GetPaymentHours
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPaymentHours`(
	IN `inEmployeeId` INT,
	IN `inStartDate` DATE,
	IN `inEndDate` DATE,
	OUT `outSuma` INT
)
BEGIN

	SELECT @val := (SUM(ewh.worked_hours) * job.salary)
	FROM empleados.employee_worked_hours ewh
	INNER JOIN empleados.employees emp ON (emp.id = ewh.employee_id)
	INNER JOIN empleados.jobs job ON (job.id = emp.job_id)
	WHERE ewh.employee_id = inEmployeeId
	AND (ewh.worked_date BETWEEN inStartDate AND inEndDate);
	
	SET outSuma = @val;
	
END//
DELIMITER ;

-- Volcando estructura para procedimiento empleados.GetWorkedHours
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetWorkedHours`(
	IN `inEmployeeId` INT,
	IN `inStartDate` DATE,
	IN `inEndDate` DATE,
	OUT `outSuma` INT
)
BEGIN
	SELECT @val := SUM(ewh.worked_hours)
	FROM empleados.employee_worked_hours ewh
	WHERE ewh.employee_id = inEmployeeId
	AND (ewh.worked_date BETWEEN inStartDate AND inEndDate);
	
	SET outSuma = @val;
END//
DELIMITER ;

-- Volcando estructura para procedimiento empleados.NewEmployee
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `NewEmployee`(
	IN `inGenderId` INT,
	IN `inJobId` INT,
	IN `inName` VARCHAR(255),
	IN `inLastName` VARCHAR(255),
	IN `inBirthdate` DATE,
	OUT `outId` INT
)
BEGIN
	INSERT INTO empleados.employees
		(
			gender_id,
			job_id,
			name,
			last_name,
			birthdate
		)
	VALUES
		(
			inGenderId,
			inJobId,
			inName,
			inLastName,
			inBirthdate
		);
		
		SET outId = LAST_INSERT_ID();
END//
DELIMITER ;

-- Volcando estructura para procedimiento empleados.NewWorkedHour
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `NewWorkedHour`(
	IN `inEmployeeId` INT,
	IN `inWorkedHours` INT,
	IN `inWorkedDate` DATE,
	OUT `outId` INT
)
BEGIN

	SET @REG := (SELECT COUNT(*) FROM empleados.employee_worked_hours WHERE employee_id = inEmployeeId and worked_date = inWorkedDate);
	
	IF inWorkedHours <= 20 THEN
		
		IF inWorkedDate <= CURDATE() THEN
	
			IF (@REG = 0) THEN
				
				INSERT INTO empleados.employee_worked_hours
				(
					employee_id,
					worked_hours,
					worked_date
				)
				VALUES
				(
					inEmployeeId,
					inWorkedHours,
					inWorkedDate
				);
				
				SET outId = LAST_INSERT_ID();
				
			END IF;
		
		END IF;
		
	END IF;
	
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
