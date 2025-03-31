<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Xác Nhận Xóa Sản Phẩm</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
  <h2 class="text-center mb-4">Xác Nhận Xóa Sản Phẩm</h2>
  <div class="alert alert-warning" role="alert">
    Bạn có chắc chắn muốn xóa sản phẩm "<strong>${phone.ten}</strong>" không?
  </div>
  <div class="d-flex justify-content-center">
    <!-- Nút xác nhận xóa -->
    <a href="${pageContext.request.contextPath}/phone/delete?id=${phone.idDienThoai}" class="btn btn-danger me-2">Xóa Sản Phẩm</a>
    <!-- Nút hủy, trở lại danh sách sản phẩm -->
    <a href="${pageContext.request.contextPath}/phone" class="btn btn-secondary">Hủy</a>
  </div>
</div>
<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
