<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Cửa Hàng Điện Thoại</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #212529;
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #007bff;
            padding: 15px;
        }
        .navbar-brand {
            color: #fff;
            font-size: 24px;
            font-weight: bold;
        }
        .btn-custom {
            background-color: #007bff;
            border: none;
            padding: 10px 15px;
            font-size: 16px;
            border-radius: 8px;
            transition: 0.3s;
            color: white;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
        .card {
            background: #ffffff;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 123, 255, 0.3);
        }
        .search-bar {
            width: 50%;
            margin: auto;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">Cửa Hàng</a>
        <form class="d-flex search-bar">
            <input class="form-control me-2" type="search" placeholder="Tìm kiếm sản phẩm..." aria-label="Search">
            <button class="btn btn-custom" type="submit">Tìm kiếm</button>
        </form>
        <div>
            <a href="<%= request.getContextPath() %>/cart" class="btn btn-warning me-2">Giỏ Hàng</a>
            <a href="<%= request.getContextPath() %>/register" class="btn btn-success me-2">Đăng ký</a>
            <a href="<%= request.getContextPath() %>/home-addmin.jsp" class="btn btn-primary">Đăng nhập</a>

        </div>
    </div>
</nav>

<div class="container mt-5">
    <h1 class="text-center">Danh Sách Sản Phẩm</h1>
    <div class="row mt-4">
        <div class="col-md-4">
            <div class="card p-3">
                <img src="http://congnghevadoisong.vn/files/ip-15-utr.jpg" class="card-img-top" alt="Sản phẩm">
                <div class="card-body text-center">
                    <h5 class="card-title">Tên sản phẩm</h5>
                    <p class="card-text">Giá: 10,000,000 VND</p>
                    <a href="#" class="btn btn-custom">Thêm vào giỏ</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card p-3">
                <img src="http://congnghevadoisong.vn/files/ip-15-utr.jpg" class="card-img-top" alt="Sản phẩm">
                <div class="card-body text-center">
                    <h5 class="card-title">Tên sản phẩm</h5>
                    <p class="card-text">Giá: 12,000,000 VND</p>
                    <a href="#" class="btn btn-custom">Thêm vào giỏ</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card p-3">
                <img src="http://congnghevadoisong.vn/files/ip-15-utr.jpg" class="card-img-top" alt="Sản phẩm">
                <div class="card-body text-center">
                    <h5 class="card-title">Tên sản phẩm</h5>
                    <p class="card-text">Giá: 12,000,000 VND</p>
                    <a href="#" class="btn btn-custom">Thêm vào giỏ</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
