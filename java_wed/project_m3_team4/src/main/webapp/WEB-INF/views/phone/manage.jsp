<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<h1>Quản lý sản phẩm</h1>
<table border="1" cellspacing="0" cellpadding="8" style="width:100%; text-align:left;">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Thương hiệu</th>
        <th>Model</th>
        <th>Năm sản xuất</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="phone" items="${phoneList}">
        <tr>
            <td>${phone.idDienThoai}</td>
            <td>${phone.ten}</td>
            <td>${phone.thuongHieu}</td>
            <td>${phone.model}</td>
            <td>${phone.namSanXuat}</td>
            <td>${phone.gia}</td>
            <td>
                <a href="#">Sửa</a> |
                <a href="#">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
