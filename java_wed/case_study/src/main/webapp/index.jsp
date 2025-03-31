<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Danh Sách Sản Phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
        }
        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }
        .card-img-container {
            width: 100%;
            height: 250px;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            background: #f8f9fa;
        }
        .card-img-container img {
            max-width: 100%;
            max-height: 100%;
            object-fit: contain;
        }
        .card-body {
            text-align: center;
            padding: 15px;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <a href="${pageContext.request.contextPath}/user/list" class="btn btn-primary">Danh sách người dùng</a>
        <h1 class="flex-grow-1 text-center">Danh Sách Sản Phẩm</h1>
        <a href="${pageContext.request.contextPath}/phone/add" class="btn btn-success">Thêm sản phẩm</a>
    </div>

    <form class="d-flex mb-4" action="${pageContext.request.contextPath}/phone/search" method="get">
        <input class="form-control me-2" type="search" name="keyword" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
    </form>

    <div class="row">
        <c:forEach var="phone" items="${phoneList}">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-img-container">
                        <img src="${pageContext.request.contextPath}/uploads/${phone.hinhAnh}" alt="${phone.ten}">
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${phone.ten}</h5>
                        <p class="card-text">
                            <strong>Giá: </strong>
                            <fmt:formatNumber value="${phone.gia}" type="currency" currencySymbol="VNĐ"/>
                        </p>
                        <a href="${pageContext.request.contextPath}/phone/detail?id=${phone.idDienThoai}" class="btn btn-primary">Xem chi tiết</a>
                        <a href="${pageContext.request.contextPath}/phone/confirmDelete?id=${phone.idDienThoai}" class="btn btn-danger">Xóa</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
