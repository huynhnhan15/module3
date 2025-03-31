<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản lý điện thoại</title>
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>">
</head>
<body>

<!-- Thanh điều hướng -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="<c:url value='/phone'/>">Phone Store</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/phone'/>">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/cart'/>">Giỏ hàng</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/contact'/>">Liên hệ</a>
        </li>
        <c:if test="${not empty sessionScope.user}">
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/logout'/>">Đăng xuất</a>
          </li>
        </c:if>
        <c:if test="${empty sessionScope.user}">
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
