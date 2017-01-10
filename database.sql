DELETE DATABASE IF EXISTS COMP3095;

CREATE DATABASE IF NOT EXISTS COMP3095;
USE COMP3095;
grant all on COMP3095.* to 'admin'@'localhost' identified by 'admin'; 

CREATE TABLE USERS 
( 
	id int(11) AUTO_INCREMENT PRIMARY KEY, 
	firstname varchar(255),
	lastname varchar(255),
	email varchar(255), 
	phone varchar(10),
	year varchar(10),
	major varchar(10),
	username varchar(20),
	password varchar(20)	
);

INSERT INTO `USERS` (`id`, `firstname`, `lastname`, `email`, `phone`, `year`, `major`, `username`, `password`) VALUES
(99, NULL, NULL, `admin@domain.ca`, NULL, NULL, NULL, `admin`, `admin`);
INSERT INTO `USERS` (`id`, `firstname`, `lastname`, `email`, `phone`, `year`, `major`, `username`, `password`) VALUES
(NULL, 'Hoa', 'Nguyen', `kh@kh.com`, 0123456789, 2017, 'Business', `hoa`, `hoa`);
