create database if not exists ss5_view_index_sp;
use ss5_view_index_sp;
create table products (
	id int not null auto_increment primary key,
    productCode varchar(50),
    productName varchar(50),
    productPrice  decimal (10,2),
    productAmount int,
    productDescription text,
    productStatus boolean

);

insert into products (productCode,productName,productPrice,productAmount,productDescription,productStatus)
value
('P001', 'Laptop', 1500.00, 10, 'High-end gaming laptop', TRUE),
('P002', 'Smartphone', 800.00, 20, 'Latest model smartphone', TRUE),
('P003', 'Tablet', 500.00, 15, 'Lightweight and portable', FALSE),
('P004', 'Monitor', 300.00, 5, '27-inch 4K monitor', TRUE);
-- câu3
create unique index idx_productCode on products(productCode);
explain select * from products where productCode = 'P001';

create index idx_productName on products(productName,productPrice);
explain select * from products where productCode = 'P001';
-- câu 4

-- tạo view
create view view_products as
select productCode, productName, productPrice, productStatus
from Products;
-- 	sửa view
alter view ProductInfo AS
select productCode, productName, productPrice, productStatus, productAmount
from Products;

-- xóa view 
drop view ProductInfo;


