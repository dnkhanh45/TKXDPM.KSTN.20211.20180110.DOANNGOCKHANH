CREATE DATABASE `aims`;

USE `aims`;

CREATE TABLE `Media` (
	`id`	INTEGER AUTO_INCREMENT NOT NULL,
	`category`	VARCHAR(45) NOT NULL,
	`price`	INT(11) NOT NULL,
	`quantity`	INT(11) NOT NULL,
	`title`	VARCHAR(45) NOT NULL,
	`value`	INT NOT NULL,
	`imageUrl`	VARCHAR(45) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `CD` (
	`id`	INT(11) NOT NULL,
	`artist`	VARCHAR(45) NOT NULL,
	`recordLabel`	VARCHAR(45) NOT NULL,
	`musicType`	VARCHAR(45) NOT NULL,
	`releasedDate`	DATE,
	CONSTRAINT `fk_CD_Media1` FOREIGN KEY(`id`) REFERENCES `Media`(`id`)
);

CREATE TABLE `Book` (
	`id`	INT(11) NOT NULL,
	`author`	VARCHAR(45) NOT NULL,
	`coverType`	VARCHAR(45) NOT NULL,
	`publisher`	VARCHAR(45) NOT NULL,
	`publishDate`	DATETIME NOT NULL,
	`numOfPages`	INT(11) NOT NULL,
	`language`	VARCHAR(45) NOT NULL,
	`bookCategory`	VARCHAR(45) NOT NULL,
	CONSTRAINT `fk_Book_Media1` FOREIGN KEY(`id`) REFERENCES `Media`(`id`)
);

CREATE TABLE `DeliveryInfo` (
	`id`	INTEGER AUTO_INCREMENT NOT NULL,
	`name`	VARCHAR(45),
	`province`	VARCHAR(45),
	`instructions`	VARCHAR(200),
	`address`	VARCHAR(100),
	PRIMARY KEY(`id`)
);

CREATE TABLE `DVD` (
	`id`	INT(11) NOT NULL,
	`discType`	VARCHAR(45) NOT NULL,
	`director`	VARCHAR(45) NOT NULL,
	`runtime`	INT(11) NOT NULL,
	`studio`	VARCHAR(45) NOT NULL,
	`subtitle`	VARCHAR(45) NOT NULL,
	`releasedDate`	DATETIME,
	CONSTRAINT `fk_DVD_Media1` FOREIGN KEY(`id`) REFERENCES `Media`(`id`)
);

CREATE TABLE `Order` (
	`id`	INT(11) NOT NULL,
	`shippingFees`	VARCHAR(45),
	`deliveryInfoId`	INT NOT NULL,
	`isRushOrder`	INT NOT NULL,
	`expectedTime`	DATETIME,
	PRIMARY KEY(`id`,`deliveryInfoId`),
	CONSTRAINT `fk_Order_DeliveryInfo1` FOREIGN KEY(`deliveryInfoId`) REFERENCES `DeliveryInfo`(`id`)
);

CREATE INDEX `Order.fk_Order_DeleveryInfo1_idx` ON `Order` (
	`deliveryInfoId`
);

CREATE TABLE `OrderMedia` (
	`orderId`	INT(11) NOT NULL,
	`price`	INT NOT NULL,
	`quantity`	INT NOT NULL,
	`mediaId`	INT(11) NOT NULL,
	CONSTRAINT `fk_orderMedia_order` FOREIGN KEY(`orderId`) REFERENCES `Order`(`id`),
	CONSTRAINT `fk_OrderMedia_Media1` FOREIGN KEY(`mediaId`) REFERENCES `Media`(`id`),
	PRIMARY KEY(`orderId`,`mediaId`)
);

CREATE INDEX `OrderMedia.fk_ordermedia_order_idx` ON `OrderMedia` (
	`orderId`
);

CREATE INDEX `OrderMedia.fk_OrderMedia_Media1_idx` ON `OrderMedia` (
	`mediaId`
);

CREATE TABLE `Invoice` (
	`id`	INT NOT NULL,
	`totalAmount`	INT NOT NULL,
	`orderId`	INT(11) NOT NULL,
	CONSTRAINT `fk_Invoice_Order1` FOREIGN KEY(`orderId`) REFERENCES `Order`(`id`),
	PRIMARY KEY(`id`)
);

CREATE INDEX `Invoice.fk_Invoice_Order1_idx` ON `Invoice` (
	`orderId`
);

CREATE TABLE `PaymentTransaction` (
	`id`	INT(11) NOT NULL,
	`createAt`	DATETIME NOT NULL,
	`content`	VARCHAR(45) NOT NULL,
	`method`	VARCHAR(45),
	`invoiceId`	INT NOT NULL,
	PRIMARY KEY(`id`,`invoiceId`),
	CONSTRAINT `fk_PaymentTransaction_Invoice1` FOREIGN KEY(`invoiceId`) REFERENCES `Invoice`(`id`)
);

CREATE INDEX `PaymentTransaction.fk_PaymentTransaction_Invoice1_idx` ON `PaymentTransaction` (
	`invoiceId`
);