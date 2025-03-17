CREATE DATABASE IF NOT exists phone_management ;
USE phone_management;
CREATE TABLE phones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description TEXT,
    manufacturer VARCHAR(255) NOT NULL
);