<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Điện thoại</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #acb6e5);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            max-width: 90%;
        }
        .table {
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn-custom {
            border-radius: 8px;
            transition: 0.3s;
        }
        .btn-custom:hover {
            transform: scale(1.05);
        }
        th, td {
            vertical-align: middle;
        }
        .table th {
            background: #007bff;
            color: white;
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h2 class="mb-3 text-center">📱 Danh sách Điện thoại</h2>
    <div class="d-flex justify-content-between mb-3">
        <a href="phones?action=add" class="btn btn-success btn-custom">➕ Thêm điện thoại</a>
        <a href="<%= request.getContextPath() %>/home-addmin.jsp" class="btn btn-primary btn-custom">🏠 Về Trang Quản Trị</a>
    </div>

    <table class="table table-bordered text-center">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Hãng</th>
            <th>Model</th>
            <th>Năm SX</th>
            <th>Giá</th>
            <th>RAM</th>
            <th>Bộ nhớ</th>
            <th>Pin</th>
            <th>Hệ điều hành</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phone" items="${phones}">
            <tr>
                <td>${phone.id}</td>
                <td>${phone.name}</td>
                <td>${phone.brand}</td>
                <td>${phone.model}</td>
                <td>${phone.manufactureYear}</td>
                <td><fmt:formatNumber value="${phone.price}" type="currency" currencySymbol="VND"/></td>
                <td>${phone.ram} GB</td>
                <td>${phone.storage} GB</td>
                <td>${phone.batteryCapacity} mAh</td>
                <td>${phone.operatingSystem}</td>
                <td>${phone.status}</td>
                <td>${phone.createdAt}</td>
                <td>
                    <a href="phones?action=edit&id=${phone.id}" class="btn btn-warning btn-sm btn-custom"
                       title="Chỉnh sửa thông tin">
                        ✏ Sửa
                    </a>
                    <a href="phones?action=delete&id=${phone.id}" class="btn btn-danger btn-sm btn-custom"
                       onclick="return confirm('Bạn có chắc chắn muốn xóa điện thoại này không?');"
                       title="Xóa điện thoại">
                        ❌ Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
