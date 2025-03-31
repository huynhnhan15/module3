<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Sản Phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Thêm Sản Phẩm Mới</h2>
    <form action="${pageContext.request.contextPath}/phone/add" method="post">
        <div class="mb-3">
            <label for="ten" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="ten" name="ten" required>
        </div>
        <div class="mb-3">
            <label for="thuongHieu" class="form-label">Thương hiệu</label>
            <input type="text" class="form-control" id="thuongHieu" name="thuongHieu" required>
        </div>
        <div class="mb-3">
            <label for="model" class="form-label">Model</label>
            <input type="text" class="form-control" id="model" name="model" required>
        </div>
        <div class="mb-3">
            <label for="namSanXuat" class="form-label">Năm sản xuất</label>
            <input type="number" class="form-control" id="namSanXuat" name="namSanXuat" required>
        </div>
        <div class="mb-3">
            <label for="gia" class="form-label">Giá</label>
            <input type="number" step="0.01" class="form-control" id="gia" name="gia" required>
        </div>
        <div class="mb-3">
            <label for="ram" class="form-label">RAM</label>
            <input type="number" class="form-control" id="ram" name="ram" required>
        </div>
        <div class="mb-3">
            <label for="boNhoTrong" class="form-label">Bộ nhớ trong</label>
            <input type="number" class="form-control" id="boNhoTrong" name="boNhoTrong" required>
        </div>
        <div class="mb-3">
            <label for="dungLuongPin" class="form-label">Dung lượng pin</label>
            <input type="number" class="form-control" id="dungLuongPin" name="dungLuongPin" required>
        </div>
        <div class="mb-3">
            <label for="heDieuHanh" class="form-label">Hệ điều hành</label>
            <input type="text" class="form-control" id="heDieuHanh" name="heDieuHanh" required>
        </div>
        <div class="mb-3">
            <label for="trangThai" class="form-label">Trạng thái</label>
            <select class="form-select" id="trangThai" name="trangThai" required>
                <option value="con_hang" selected>Còn hàng</option>
                <option value="da_ban">Đã bán</option>
                <option value="giu_cho">Giữ chỗ</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="hinhAnh" class="form-label">Đường dẫn ảnh</label>
            <input type="text" class="form-control" id="hinhAnh" name="hinhAnh" placeholder="ten_anh.jpg" required>
        </div>
        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
        <a href="${pageContext.request.contextPath}/phone" class="btn btn-secondary">Hủy</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
