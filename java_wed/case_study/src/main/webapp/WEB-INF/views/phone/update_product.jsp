<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập nhật Sản Phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <!-- Nút quay lại trang quản lý (admin) hoặc danh sách sản phẩm -->
    <a href="${pageContext.request.contextPath}/phone?action=admin" class="btn btn-secondary mb-3">&laquo; Quay lại</a>

    <h2 class="mb-4">Cập nhật Sản Phẩm</h2>
    <!-- Form cập nhật sản phẩm -->
    <form action="${pageContext.request.contextPath}/phone/update" method="post">
        <!-- Ẩn field chứa ID sản phẩm -->
        <input type="hidden" name="id" value="${phone.idDienThoai}">

        <div class="mb-3">
            <label for="ten" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${phone.ten}" required>
        </div>
        <div class="mb-3">
            <label for="thuongHieu" class="form-label">Thương hiệu</label>
            <input type="text" class="form-control" id="thuongHieu" name="thuongHieu" value="${phone.thuongHieu}" required>
        </div>
        <div class="mb-3">
            <label for="model" class="form-label">Model</label>
            <input type="text" class="form-control" id="model" name="model" value="${phone.model}" required>
        </div>
        <div class="mb-3">
            <label for="namSanXuat" class="form-label">Năm sản xuất</label>
            <input type="number" class="form-control" id="namSanXuat" name="namSanXuat" value="${phone.namSanXuat}" required>
        </div>
        <div class="mb-3">
            <label for="gia" class="form-label">Giá</label>
            <input type="number" step="0.01" class="form-control" id="gia" name="gia" value="${phone.gia}" required>
        </div>
        <div class="mb-3">
            <label for="ram" class="form-label">RAM (GB)</label>
            <input type="number" class="form-control" id="ram" name="ram" value="${phone.ram}" required>
        </div>
        <div class="mb-3">
            <label for="boNhoTrong" class="form-label">Bộ nhớ trong (GB)</label>
            <input type="number" class="form-control" id="boNhoTrong" name="boNhoTrong" value="${phone.boNhoTrong}" required>
        </div>
        <div class="mb-3">
            <label for="dungLuongPin" class="form-label">Dung lượng pin (mAh)</label>
            <input type="number" class="form-control" id="dungLuongPin" name="dungLuongPin" value="${phone.dungLuongPin}" required>
        </div>
        <div class="mb-3">
            <label for="heDieuHanh" class="form-label">Hệ điều hành</label>
            <input type="text" class="form-control" id="heDieuHanh" name="heDieuHanh" value="${phone.heDieuHanh}" required>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái</label>
            <select class="form-select" id="trangThai" name="trangThai" required>
                <option value="con_hang" ${phone.trangThai eq 'con_hang' ? 'selected' : ''}>Còn hàng</option>
                <option value="da_ban" ${phone.trangThai eq 'da_ban' ? 'selected' : ''}>Đã bán</option>
                <option value="giu_cho" ${phone.trangThai eq 'giu_cho' ? 'selected' : ''}>Giữ chỗ</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="hinhAnh" class="form-label">Đường dẫn ảnh</label>
            <input type="text" class="form-control" id="hinhAnh" name="hinhAnh" value="${phone.hinhAnh}" required>
        </div>
        <div class="mt-4">
            <button type="submit" class="btn btn-primary">Cập nhật</button>
            <a href="${pageContext.request.contextPath}/phone?action=admin" class="btn btn-secondary">Hủy</a>
        </div>
    </form>
</div>
<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
