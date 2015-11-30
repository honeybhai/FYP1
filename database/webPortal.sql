SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `password` VARCHAR(45) NOT NULL ,
  `user_name` VARCHAR(45) NULL ,
  `role` BIGINT NULL ,
  PRIMARY KEY (`user_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`buyer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`buyer` (
  `buyer_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `buyer_name` VARCHAR(45) NULL ,
  `buyer_email` VARCHAR(45) NULL ,
  `buyer_mobile` VARCHAR(45) NULL ,
  `user_id` BIGINT NOT NULL ,
  PRIMARY KEY (`buyer_id`) ,
  INDEX `fk_user2` (`user_id` ASC) ,
  CONSTRAINT `fk_user2`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`messages`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`messages` (
  `messages_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `message` VARCHAR(45) NULL ,
  `sender_role` BIGINT NULL ,
  `sender_user_id` BIGINT NOT NULL ,
  `receiver_user_id` BIGINT NOT NULL ,
  `dateTime` DATETIME NULL ,
  `receiver_role` BIGINT NULL ,
  PRIMARY KEY (`messages_id`) ,
  INDEX `fk_login1` (`sender_user_id` ASC) ,
  CONSTRAINT `fk_login1`
    FOREIGN KEY (`sender_user_id` )
    REFERENCES `mydb`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`category` (
  `category_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `category_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`category_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seller`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seller` (
  `seller_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `category_id` BIGINT NOT NULL ,
  `seller_first_name` VARCHAR(45) NOT NULL ,
  `seller_last_name` VARCHAR(45) NULL ,
  `seller_location` VARCHAR(45) NULL ,
  `seller_mobile` VARCHAR(45) NULL ,
  `seller_business_name` VARCHAR(45) NULL ,
  `user_id` BIGINT NOT NULL ,
  PRIMARY KEY (`seller_id`) ,
  INDEX `fk_user3` (`user_id` ASC) ,
  CONSTRAINT `fk_user3`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`item`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`item` (
  `item_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `item_name` VARCHAR(45) NULL ,
  `category_id` BIGINT NOT NULL ,
  `seller_id` BIGINT NOT NULL ,
  PRIMARY KEY (`item_id`) ,
  INDEX `fk_category2` (`category_id` ASC) ,
  INDEX `fk_seller4` (`seller_id` ASC) ,
  CONSTRAINT `fk_category2`
    FOREIGN KEY (`category_id` )
    REFERENCES `mydb`.`category` (`category_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seller4`
    FOREIGN KEY (`seller_id` )
    REFERENCES `mydb`.`seller` (`seller_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`comment` (
  `comment_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `comment` VARCHAR(45) NULL ,
  `buyer_id` BIGINT NOT NULL ,
  `item_id` BIGINT NOT NULL ,
  PRIMARY KEY (`comment_id`) ,
  INDEX `fk_buyer4` (`buyer_id` ASC) ,
  INDEX `fk_item3` (`item_id` ASC) ,
  CONSTRAINT `fk_buyer4`
    FOREIGN KEY (`buyer_id` )
    REFERENCES `mydb`.`buyer` (`buyer_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item3`
    FOREIGN KEY (`item_id` )
    REFERENCES `mydb`.`item` (`item_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`wishlist`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`wishlist` (
  `wishlist_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `buyer_id` BIGINT NOT NULL ,
  `item_id` BIGINT NOT NULL ,
  PRIMARY KEY (`wishlist_id`) ,
  INDEX `fk_buyer3` (`buyer_id` ASC) ,
  INDEX `fk_item2` (`item_id` ASC) ,
  CONSTRAINT `fk_buyer3`
    FOREIGN KEY (`buyer_id` )
    REFERENCES `mydb`.`buyer` (`buyer_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item2`
    FOREIGN KEY (`item_id` )
    REFERENCES `mydb`.`item` (`item_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`admin`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`admin` (
  `admin_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `admin_name` VARCHAR(45) NULL ,
  `user_id` BIGINT NOT NULL ,
  PRIMARY KEY (`admin_id`) ,
  INDEX `fk_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reported_comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`reported_comment` (
  `reported_comments_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `comment_id` BIGINT NOT NULL ,
  PRIMARY KEY (`reported_comments_id`) ,
  INDEX `fk_comment1` (`comment_id` ASC) ,
  CONSTRAINT `fk_comment1`
    FOREIGN KEY (`comment_id` )
    REFERENCES `mydb`.`comment` (`comment_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reported_profile`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`reported_profile` (
  `reported_profile_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `seller_id` BIGINT NOT NULL ,
  PRIMARY KEY (`reported_profile_id`) ,
  INDEX `fk_seller2` (`seller_id` ASC) ,
  CONSTRAINT `fk_seller2`
    FOREIGN KEY (`seller_id` )
    REFERENCES `mydb`.`seller` (`seller_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`subscription`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`subscription` (
  `subscriptipn_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `seller_id` BIGINT NOT NULL ,
  `buyer_id` BIGINT NOT NULL ,
  PRIMARY KEY (`subscriptipn_id`) ,
  INDEX `fk_seller1` (`seller_id` ASC) ,
  INDEX `fk_buyer5` (`buyer_id` ASC) ,
  CONSTRAINT `fk_seller1`
    FOREIGN KEY (`seller_id` )
    REFERENCES `mydb`.`seller` (`seller_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buyer5`
    FOREIGN KEY (`buyer_id` )
    REFERENCES `mydb`.`buyer` (`buyer_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`advertisement`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`advertisement` (
  `advertisement_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `item_id` BIGINT NOT NULL ,
  PRIMARY KEY (`advertisement_id`) ,
  INDEX `fk_item4` (`item_id` ASC) ,
  CONSTRAINT `fk_item4`
    FOREIGN KEY (`item_id` )
    REFERENCES `mydb`.`item` (`item_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category_attribute`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`category_attribute` (
  `category_attribute_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `category_attribute_name` VARCHAR(45) NULL ,
  `category_attribute_type` ENUM('radio','text') NULL ,
  `category_id` BIGINT NOT NULL ,
  PRIMARY KEY (`category_attribute_id`) ,
  INDEX `fk_category1` (`category_id` ASC) ,
  CONSTRAINT `fk_category1`
    FOREIGN KEY (`category_id` )
    REFERENCES `mydb`.`category` (`category_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`attribute_option`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`attribute_option` (
  `attribute_option_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `attribute_option` VARCHAR(45) NULL ,
  `category_attribute_id` BIGINT NOT NULL ,
  PRIMARY KEY (`attribute_option_id`) ,
  INDEX `fk_category_attribute1` (`category_attribute_id` ASC) ,
  CONSTRAINT `fk_category_attribute1`
    FOREIGN KEY (`category_attribute_id` )
    REFERENCES `mydb`.`category_attribute` (`category_attribute_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`item_attribute`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`item_attribute` (
  `item_attribute_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `category_attribute_id` BIGINT NOT NULL ,
  `item_id` BIGINT NOT NULL ,
  `value` BIGINT NULL ,
  PRIMARY KEY (`item_attribute_id`) ,
  INDEX `fk_category_attribute2` (`category_attribute_id` ASC) ,
  INDEX `fk_item1` (`item_id` ASC) ,
  CONSTRAINT `fk_category_attribute2`
    FOREIGN KEY (`category_attribute_id` )
    REFERENCES `mydb`.`category_attribute` (`category_attribute_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item1`
    FOREIGN KEY (`item_id` )
    REFERENCES `mydb`.`item` (`item_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rating`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`rating` (
  `ratting_id` BIGINT NOT NULL AUTO_INCREMENT ,
  `item_id` BIGINT NOT NULL ,
  `rating` BIGINT NULL ,
  PRIMARY KEY (`ratting_id`) ,
  INDEX `fk_item5` (`item_id` ASC) ,
  CONSTRAINT `fk_item5`
    FOREIGN KEY (`item_id` )
    REFERENCES `mydb`.`item` (`item_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
