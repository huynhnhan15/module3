<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết Sản Phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <!-- Nút quay lại danh sách sản phẩm -->
    <a href="${pageContext.request.contextPath}/phone" class="btn btn-secondary mb-3">&laquo; Quay lại danh sách</a>

    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <div class="row">
        <!-- Cột hiển thị hình ảnh sản phẩm -->
        <div class="col-md-6">
            <img src="${pageContext.request.contextPath}/uploads/${phone.hinhAnh}"
                 alt="${phone.ten}" class="img-fluid">
        </div>
        <!-- Cột hiển thị thông tin chi tiết sản phẩm -->
        <div class="col-md-6">
            <h2>${phone.ten}</h2>
            <table class="table">
                <tr>
                    <th>Thương hiệu</th>
                    <td>${phone.thuongHieu}</td>
                </tr>
                <tr>
                    <th>Model</th>
                    <td>${phone.model}</td>
                </tr>
                <tr>
                    <th>Năm sản xuất</th>
                    <td>${phone.namSanXuat}</td>
                </tr>
                <tr>
                    <th>Giá</th>
                    <td><fmt:formatNumber value="${phone.gia}" type="currency" currencySymbol="VNĐ"/></td>
                </tr>
                <tr>
                    <th>RAM</th>
                    <td>${phone.ram} GB</td>
                </tr>
                <tr>
                    <th>Bộ nhớ trong</th>
                    <td>${phone.boNhoTrong} GB</td>
                </tr>
                <tr>
                    <th>Dung lượng pin</th>
                    <td>${phone.dungLuongPin} mAh</td>
                </tr>
                <tr>
                    <th>Hệ điều hành</th>
                    <td>${phone.heDieuHanh}</td>
                </tr>
                <tr>
                    <th>Trạng thái</th>
                    <td>${phone.trangThai}</td>
                </tr>
            </table>

            <!-- Form cập nhật trạng thái sản phẩm -->
            <form action="${pageContext.request.contextPath}/phone/updateStatus" method="post">
                <input type="hidden" name="id" value="${phone.idDienThoai}">
                <div class="mb-3">
                    <label for="newStatus" class="form-label">Trạng thái mới:</label>
                    <select name="newStatus" id="newStatus" class="form-select">
                        <option value="Còn hàng" ${phone.trangThai == 'Còn hàng' ? 'selected' : ''}>con_hang</option>
                        <option value="Hết hàng" ${phone.trangThai == 'Hết hàng' ? 'selected' : ''}>het_hang</option>
                        <option value="Ngừng kinh doanh" ${phone.trangThai == 'Ngừng kinh doanh' ? 'selected' : ''}>Khong_ban</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">Cập nhật trạng thái</button>
            </form>

            <!-- Nút chỉnh sửa sản phẩm -->
            <div class="mt-4">
                <a href="${pageContext.request.contextPath}/phone/edit?id=${phone.idDienThoai}" class="btn btn-warning">Chỉnh sửa</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>