<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách sản phẩm</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
  <h2 class="text-center">Danh sách sản phẩm</h2>
  <a href="products?action=create" class="btn btn-success mb-3">Thêm sản phẩm</a>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>ID</th>
      <th>Tên sản phẩm</th>
      <th>Giá</th>
      <th>Mô tả</th>
      <th>Nhà sản xuất</th>
      <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.description}</td>
        <td>${product.manufacturer}</td>
        <td>
          <a href="products?action=edit&id=${product.id}" class="btn btn-warning">Sửa</a>
          <a href="products?action=detail&id=${product.id}" class="btn btn-info">Xem</a>
          <a href="products?action=delete&id=${product.id}" class="btn btn-danger">Xóa</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
