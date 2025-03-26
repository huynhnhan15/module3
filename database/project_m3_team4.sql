-- Xóa database nếu tồn tại và tạo mới
DROP DATABASE IF EXISTS project_m3_team4;
CREATE DATABASE project_m3_team4;
USE project_m3_team4;

-- Xóa các bảng nếu có trước khi tạo mới
DROP TABLE IF EXISTS chi_tiet_gio_hang, gio_hang, danh_gia, tin_nhan, don_hang_dich_vu, dich_vu, chi_tiet_don_hang, don_hang, dien_thoai, nguoi_dung;

-- Bảng người dùng
CREATE TABLE nguoi_dung (
    id_nguoi_dung INT PRIMARY KEY AUTO_INCREMENT,
    ten_dang_nhap VARCHAR(50) UNIQUE NOT NULL,
    mat_khau VARCHAR(255) NOT NULL,
    ngay_sinh DATE NOT NULL,
    dia_chi VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL CHECK (email LIKE '%@%'),
    so_dien_thoai VARCHAR(15) UNIQUE NOT NULL CHECK (LENGTH(so_dien_thoai) = 10),
    vai_tro ENUM('admin', 'nguoi_dung') NOT NULL DEFAULT 'nguoi_dung',
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng điện thoại
CREATE TABLE dien_thoai (
    id_dien_thoai INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255) NOT NULL,
    thuong_hieu VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    nam_san_xuat INT NOT NULL,
    gia DOUBLE NOT NULL,
    ram INT NOT NULL,
    bo_nho_trong INT NOT NULL,
    dung_luong_pin INT NOT NULL,
    he_dieu_hanh VARCHAR(100) NOT NULL,
    trang_thai VARCHAR(100) NOT NULL DEFAULT 'Còn hàng',
    hinh_anh VARCHAR(255) NOT NULL DEFAULT 'default.jpg'
);

-- Bảng đơn hàng
CREATE TABLE don_hang (
    id_don_hang INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT NOT NULL,
    trang_thai_don_hang ENUM('cho_duyet', 'da_duyet', 'hoan_tat', 'da_huy') NOT NULL DEFAULT 'cho_duyet',
    tong_tien DECIMAL(15,2) NOT NULL,
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id_nguoi_dung) ON DELETE CASCADE
);

-- Bảng chi tiết đơn hàng
CREATE TABLE chi_tiet_don_hang (
    id_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
    id_don_hang INT NOT NULL,
    id_dien_thoai INT NOT NULL,
    so_luong INT NOT NULL,
    gia DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (id_don_hang) REFERENCES don_hang(id_don_hang) ON DELETE CASCADE,
    FOREIGN KEY (id_dien_thoai) REFERENCES dien_thoai(id_dien_thoai) ON DELETE CASCADE
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
    FOREIGN KEY (id_don_hang) REFERENCES don_hang(id_don_hang) ON DELETE CASCADE,
    FOREIGN KEY (id_dich_vu) REFERENCES dich_vu(id_dich_vu) ON DELETE CASCADE
);

-- Bảng tin nhắn giữa người dùng
CREATE TABLE tin_nhan (
    id_tin_nhan INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_gui INT NOT NULL,
    id_nguoi_nhan INT NOT NULL,
    noi_dung TEXT NOT NULL,
    thoi_gian_gui TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_gui) REFERENCES nguoi_dung(id_nguoi_dung) ON DELETE CASCADE,
    FOREIGN KEY (id_nguoi_nhan) REFERENCES nguoi_dung(id_nguoi_dung) ON DELETE CASCADE
);

-- Bảng đánh giá sản phẩm
CREATE TABLE danh_gia (
    id_danh_gia INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT NOT NULL,
    id_dien_thoai INT NOT NULL,
    diem INT CHECK (diem BETWEEN 1 AND 5),
    binh_luan TEXT,
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id_nguoi_dung) ON DELETE CASCADE,
    FOREIGN KEY (id_dien_thoai) REFERENCES dien_thoai(id_dien_thoai) ON DELETE CASCADE
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
    id_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
    id_gio_hang INT NOT NULL,
    id_dien_thoai INT NOT NULL,
    so_luong INT NOT NULL,
    gia DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (id_gio_hang) REFERENCES gio_hang(id_gio_hang) ON DELETE CASCADE,
    FOREIGN KEY (id_dien_thoai) REFERENCES dien_thoai(id_dien_thoai) ON DELETE CASCADE
);
INSERT INTO dien_thoai (ten, thuong_hieu, model, nam_san_xuat, gia, ram, bo_nho_trong, dung_luong_pin, he_dieu_hanh, hinh_anh) 
VALUES 
('iPhone 14', 'Apple', 'A2882', 2022, 25000000, 6, 128, 3279, 'iOS 16', 'iphone14.jpg'),
('Galaxy S23', 'Samsung', 'SM-S911B', 2023, 22000000, 8, 256, 3900, 'Android 13', 's23.jpg');

