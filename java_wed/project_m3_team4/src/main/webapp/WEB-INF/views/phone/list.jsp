<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<div class="product-list">
    <c:forEach var="phone" items="${phoneList}">
        <div class="product-item" style="border: 1px solid #ccc; padding: 10px; margin: 10px; display: inline-block; width: 220px; text-align: center;">
            <img src="${phone.hinhAnh}" alt="${phone.ten}" style="width: 200px; height: auto;">
            <h2>${phone.ten}</h2>
            <p>Giá: ${phone.gia} VND</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
