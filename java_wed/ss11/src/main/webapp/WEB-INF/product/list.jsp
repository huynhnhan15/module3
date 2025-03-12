<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Mô tả</th>
    <th>Nhà sản xuất</th>
  </tr>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.id}</td>s
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.description}</td>
      <td>${product.manufacturer}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>