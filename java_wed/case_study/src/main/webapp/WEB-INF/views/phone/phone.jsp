<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách điện thoại</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Danh sách điện thoại</h2>
    <div class="row">
        <c:forEach var="phone" items="${phoneList}">
            <div class="col-md-3">
                <div class="card mb-4">
                    <img src="uploads/${phone.image}" class="card-img-top" alt="${phone.name}" style="height: 200px; object-fit: cover;">
                    <div class="card-body">
                        <h5 class="card-title">${phone.name}</h5>
                        <p class="card-text">Giá: <strong>${phone.price} VNĐ</strong></p>
                        <a href="phone/detail?id=${phone.id}" class="btn btn-primary">Xem chi tiết</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

