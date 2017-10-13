CREATE DATABASE [ECommerce]
GO
USE [ECommerce]
GO

CREATE TABLE Category(
	
	id int IDENTITY(1,1) not null,
	name nvarchar(50) null,
	description nVARCHAR(500) null,
	image_url nVARCHAR(100) null,
	is_active bit null ,
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

DROP TABLE Category;

SELECT * FROM Category;