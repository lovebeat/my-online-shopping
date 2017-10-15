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

INSERT INTO Category
VALUES('Laptop', 'This is all about for laptop','Cat_001',1);
INSERT INTO Category
VALUES('Television', 'This is all about for Television','Cat_002',1);
INSERT INTO Category
VALUES('Pc', 'This is all about for pc','Cat_002',1);

DROP TABLE Category;

SELECT * FROM Category;

UPDATE Category
SET name='Mobile',image_url='Cat_003'
WHERE id=3; 
CREATE TABLE User_detail(
	id int IDENTITY(1,1) not null,
	first_name NVARCHAR(50),
	last_name NVARCHAR(50),
	role NVARCHAR(50),
	enabled bit null,
	password NVARCHAR(50),
	email NVARCHAR(100),
	contact_number NVARCHAR(50)
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);
INSERT INTO	User_detail VALUES('Thach','Huynh','ADMIN', 1, 'admin', '13520757@ecommerce.ngoc.thach.vn', 0966152448)
INSERT INTO	User_detail VALUES('Ngoc','Huynh','SUPPLIER', 1, 'supplier', 'staffNgoc@ecommerce.ngoc.thach.vn', 0966152449)
INSERT INTO	User_detail VALUES('Trang','Huynh','SUPPLIER', 1, 'supplier', 'staffTrang@ecommerce.ngoc.thach.vn', 0966152450)

CREATE TABLE Product(
	id int IDENTITY(1,1) not null,
	code NVARCHAR(50) null,
	name NVARCHAR(50) null,
	brand NVARCHAR(50) null,
	description NVARCHAR(100) null,
	unit_price DECIMAL (10,2) null,
	quantity int null,
	is_active bit null,
	category_id int,
	supplier_id int,
	purchases int DEFAULT 0,
	views int DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES Category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES User_detail(id),


);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, 1, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, 1, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, 1, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, 1, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, 1, 1, 3 );



