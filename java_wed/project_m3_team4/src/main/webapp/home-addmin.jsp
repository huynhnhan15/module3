<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333;
            font-family: 'Arial', sans-serif;
        }
        .navbar {
            background-color: cornflowerblue;
            padding: 15px;
        }
        .navbar-brand {
            color: #fff;
            font-size: 24px;
            font-weight: bold;
        }
        .btn-custom {
            background-color: dodgerblue;
            border: none;
            padding: 12px 20px;
            font-size: 18px;
            border-radius: 10px;
            transition: 0.3s;
            color: white;
            width: 100%;
            font-weight: bold;
        }
        .btn-custom:hover {
            background-color: #74ebd5;
            transform: scale(1.05);
        }
        .card {
            background: #ffffff;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .container {
            max-width: 900px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">Admin</a>
        <div>
            <a href="<%= request.getContextPath() %>/index.jsp" class="btn btn-success me-2">Quay Lại</a>
            <a href="<%= request.getContextPath() %>/index.jsp" class="btn btn-danger">Đăng xuất</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="card">
        <h1>Admin Dashboard</h1>
        <p class="lead">Chào mừng bạn đến với trang quản trị</p>

        <div class="d-grid gap-3 mt-3">
            <a href="<%= request.getContextPath() %>/phones" class="btn btn-custom">
                📱 Quản lý Điện thoại
            </a>
            <a href="<%= request.getContextPath() %>/users" class="btn btn-custom">
                👤 Quản lý Người dùng
            </a>
            <a href="<%= request.getContextPath() %>/orders" class="btn btn-custom">
                📦 Quản lý Đơn hàng
            </a>
            <a href="<%= request.getContextPath() %>/services" class="btn btn-custom">
                🎁 Quản lý Ưu đãi & Dịch vụ
            </a>
        </div>
    </div>
</div>

</body>
</html>
