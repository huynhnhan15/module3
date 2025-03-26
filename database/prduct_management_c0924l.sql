CREATE DATABASE IF NOT exists quan_li_san_pham ;
USE quan_li_san_pham;
CREATE TABLE Product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    manufacturer VARCHAR(255)
);
select * from Product;