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
        .card img {
            height: 200px;
            object-fit: cover;
        }
        .card-body {
            text-align: center;
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

    <!-- Thanh tìm kiếm sản phẩm -->
    <form class="d-flex mb-4" action="${pageContext.request.contextPath}/phone/search" method="get">
        <input class="form-control me-2" type="search" name="keyword" placeholder="Tìm kiếm sản phẩm" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
    </form>

    <!-- Danh sách sản phẩm -->
    <div class="row">
        <c:forEach var="phone" items="${phoneList}">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="${pageContext.request.contextPath}/uploads/${phone.hinhAnh}" class="card-img-top" alt="${phone.ten}">
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
