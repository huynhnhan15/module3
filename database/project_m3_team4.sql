-- Xóa cơ sở dữ liệu nếu có
DROP DATABASE IF EXISTS project_m3_team4;
CREATE DATABASE project_m3_team4;
USE project_m3_team4;

-- Xóa bảng nếu có trước khi tạo mới
DROP TABLE IF EXISTS nguoi_dung, dien_thoai, don_hang, chi_tiet_don_hang, dich_vu, don_hang_dich_vu, tin_nhan, danh_gia, gio_hang, chi_tiet_gio_hang;

-- Bảng người dùng
CREATE TABLE nguoi_dung (
    id_nguoi_dung INT PRIMARY KEY AUTO_INCREMENT,
    ten_dang_nhap VARCHAR(50) UNIQUE NOT NULL CHECK (ten_dang_nhap NOT LIKE '%[àáảãạăắằẳẵặâấầẩẫậàáạãèéẻẽẹêếềểễệìíỉĩịòóỏõọôốồổỗộơớờởỡợùúủũụưứừửữựỳýỷỹỵ%'),
    mat_khau VARCHAR(255) NOT NULL,
    ngay_sinh DATE NOT NULL,
    dia_chi VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL CHECK (email LIKE '%@%'),
    so_dien_thoai VARCHAR(15) UNIQUE NOT NULL CHECK (LENGTH(so_dien_thoai) = 10),
    vai_tro ENUM('admin', 'nguoi_dung') NOT NULL DEFAULT 'nguoi_dung',
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng điện thoại (có thêm cột hình ảnh)
CREATE TABLE dien_thoai (
    id_dien_thoai INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(100) NOT NULL,
    thuong_hieu VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    nam_san_xuat YEAR NOT NULL,
    gia DECIMAL(15,2) NOT NULL,
    ram INT NOT NULL,
    bo_nho_trong INT NOT NULL,
    dung_luong_pin INT NOT NULL,
    he_dieu_hanh VARCHAR(50) NOT NULL,
    trang_thai ENUM('con_hang', 'da_ban', 'giu_cho') NOT NULL DEFAULT 'con_hang',
    hinh_anh VARCHAR(255), -- Thêm cột lưu đường dẫn ảnh
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng đơn hàng
CREATE TABLE don_hang (
    id_don_hang INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT NOT NULL,
    trang_thai_don_hang ENUM('cho_duyet', 'da_duyet', 'hoan_tat', 'da_huy') NOT NULL DEFAULT 'cho_duyet',
    tong_tien DECIMAL(15,2) NOT NULL,
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id_nguoi_dung)
);

-- Bảng chi tiết đơn hàng
CREATE TABLE chi_tiet_don_hang (
    id_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
    id_don_hang INT NOT NULL,
    id_dien_thoai INT NOT NULL,
    so_luong INT NOT NULL,
    gia DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (id_don_hang) REFERENCES don_hang(id_don_hang),
    FOREIGN KEY (id_dien_thoai) REFERENCES dien_thoai(id_dien_thoai)
);

-- Bảng dịch vụ
CREATE TABLE dich_vu (
    id_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(100) NOT NULL,
    mo_ta TEXT,
    gia DECIMAL(15,2) NOT NULL
);

-- Bảng dịch vụ trong đơn hàng
CREATE TABLE don_hang_dich_vu (
    id_don_hang INT NOT NULL,
    id_dich_vu INT NOT NULL,
    PRIMARY KEY (id_don_hang, id_dich_vu),
    FOREIGN KEY (id_don_hang) REFERENCES don_hang(id_don_hang),
    FOREIGN KEY (id_dich_vu) REFERENCES dich_vu(id_dich_vu)
);

-- Bảng tin nhắn giữa người dùng
CREATE TABLE tin_nhan (
    id_tin_nhan INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_gui INT NOT NULL,
    id_nguoi_nhan INT NOT NULL,
    noi_dung TEXT NOT NULL,
    thoi_gian_gui TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_gui) REFERENCES nguoi_dung(id_nguoi_dung),
    FOREIGN KEY (id_nguoi_nhan) REFERENCES nguoi_dung(id_nguoi_dung)
);

-- Bảng đánh giá sản phẩm
CREATE TABLE danh_gia (
    id_danh_gia INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT NOT NULL,
    id_dien_thoai INT NOT NULL,
    diem INT CHECK (diem BETWEEN 1 AND 5),
    binh_luan TEXT,
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id_nguoi_dung),
    FOREIGN KEY (id_dien_thoai) REFERENCES dien_thoai(id_dien_thoai)
);

-- Bảng giỏ hàng
CREATE TABLE gio_hang (
    id_gio_hang INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT NOT NULL,
    ngay_them DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id_nguoi_dung) ON DELETE CASCADE
);

-- Bảng chi tiết giỏ hàng
CREATE TABLE chi_tiet_gio_hang (
    id_chi_tiet_gio_hang INT PRIMARY KEY AUTO_INCREMENT,
    id_gio_hang INT NOT NULL,
    id_dien_thoai INT NOT NULL,
    so_luong INT NOT NULL DEFAULT 1,
    gia DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (id_gio_hang) REFERENCES gio_hang(id_gio_hang) ON DELETE CASCADE,
    FOREIGN KEY (id_dien_thoai) REFERENCES dien_thoai(id_dien_thoai) ON DELETE CASCADE
);


ALTER TABLE dien_thoai ADD COLUMN image_data BLOB;

INSERT INTO dien_thoai (ten, thuong_hieu, model, nam_san_xuat, gia, ram, bo_nho_trong, dung_luong_pin, he_dieu_hanh, trang_thai, hinh_anh)
VALUES 
('iPhone 11', 'Apple', 'Model11', 2020, 12000000, 4, 64, 3000, 'iOS', 'con_hang', 'iphone11.jpg'),
('iPhone 12', 'Apple', 'Model12', 2021, 18000000, 6, 128, 3500, 'iOS', 'con_hang', 'iphone12.jpg'),
('iPhone 13', 'Apple', 'Model13', 2022, 22000000, 6, 256, 4000, 'iOS', 'con_hang', 'iphone13.jpg'),
('iPhone 14', 'Apple', 'Model14', 2023, 25000000, 8, 512, 4500, 'iOS', 'con_hang', 'iphone14.jpg'),
('iPhone 15', 'Apple', 'Model15', 2024, 28000000, 8, 1024, 5000, 'iOS', 'con_hang', 'iphone15.jpg'),
('Samsung Galaxy S21', 'Samsung', 'S21', 2020, 15000000, 6, 128, 4000, 'Android', 'con_hang', 'galaxy_s21.jpg'),
('Samsung Galaxy S22', 'Samsung', 'S22', 2021, 18000000, 8, 256, 4500, 'Android', 'con_hang', 'galaxy_s22.jpg'),
('Samsung Galaxy S23', 'Samsung', 'S23', 2022, 22000000, 8, 512, 5000, 'Android', 'con_hang', 'galaxy_s23.jpg'),
('Samsung Galaxy S24', 'Samsung', 'S24', 2023, 25000000, 12, 1024, 5500, 'Android', 'con_hang', 'galaxy_s24.jpg'),
('Samsung Galaxy S25', 'Samsung', 'S25', 2024, 28000000, 12, 2048, 6000, 'Android', 'con_hang', 'galaxy_s25.jpg');


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE dien_thoai;
SET FOREIGN_KEY_CHECKS = 1;
SELECT * FROM nguoi_dung;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE nguoi_dung;
SET FOREIGN_KEY_CHECKS = 1;

-- Thêm dữ liệu người dùng
INSERT INTO nguoi_dung (ten_dang_nhap, mat_khau, ngay_sinh, dia_chi, email, so_dien_thoai, vai_tro) 
VALUES
('admin', 'admin123', '1990-01-01', 'Hà Nội', 'admin@example.com', '0987654321', 'admin'),
('user1', 'user123', '1995-05-10', 'TP HCM', 'user1@example.com', '0912345678', 'nguoi_dung'),
('user2', 'user456', '1998-08-15', 'Đà Nẵng', 'user2@example.com', '0923456789', 'nguoi_dung'),
('user3', 'user789', '2000-12-20', 'Hải Phòng', 'user3@example.com', '0934567890', 'nguoi_dung');

