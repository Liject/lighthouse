-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lighthouse
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lighthouse` ;

-- -----------------------------------------------------
-- Schema lighthouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lighthouse` DEFAULT CHARACTER SET utf8 ;
USE `lighthouse` ;

-- -----------------------------------------------------
-- Table `lighthouse`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lighthouse`.`users` ;

CREATE TABLE IF NOT EXISTS `lighthouse`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login_id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `created` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_id_UNIQUE` (`login_id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lighthouse`.`voyage_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lighthouse`.`voyage_record` ;

CREATE TABLE IF NOT EXISTS `lighthouse`.`voyage_record` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `uid` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`no`),
  INDEX `voyage_uid_idx` (`uid` ASC),
  UNIQUE INDEX `no_UNIQUE` (`no` ASC),
  CONSTRAINT `voyage-uid`
    FOREIGN KEY (`uid`)
    REFERENCES `lighthouse`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `lighthouse` ;

-- -----------------------------------------------------
-- procedure registration
-- -----------------------------------------------------

USE `lighthouse`;
DROP procedure IF EXISTS `lighthouse`.`registration`;

DELIMITER $$
USE `lighthouse`$$
CREATE PROCEDURE `registration` (
	IN p_login_id varchar(45),
	IN p_password varchar(45),
	IN p_name varchar(45),
	IN p_email varchar(45),
    IN p_created datetime
)
BEGIN
	IF ( select exists (select 1 from users where login_id = p_login_id) ) THEN
		select 'login_id Exists';
        
	ELSEIF ( select exists (select 1 from users where email = p_email) ) THEN
		select 'email Exists';
        
	ELSE
		INSERT INTO users (login_id, password, name, email, created) values (p_login_id, p_password, p_name, p_email, p_created);
        
	END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure login
-- -----------------------------------------------------

USE `lighthouse`;
DROP procedure IF EXISTS `lighthouse`.`login`;

DELIMITER $$
USE `lighthouse`$$
CREATE PROCEDURE `login` (
	IN p_login_id varchar(45),
	IN p_password varchar(45)
)
BEGIN
	IF ( select NOT exists (select 1 from users where login_id = p_login_id AND password = p_password) ) THEN
		SELECT "FAIL";
	END IF;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
