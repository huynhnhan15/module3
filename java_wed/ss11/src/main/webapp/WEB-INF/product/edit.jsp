<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<h2>Chỉnh sửa sản phẩm</h2>
<form action="products?action=edit" method="post">
  <input type="hidden" name="id" value="${product.id}">

  <label>Tên sản phẩm:</label>
  <input type="text" name="name" value="${product.name}" required><br>

  <label>Giá sản phẩm:</label>
  <input type="number" name="price" step="0.01" value="${product.price}" required><br>

  <label>Mô tả:</label>
  <textarea name="description" required>${product.description}</textarea><br>

  <label>Nhà sản xuất:</label>
  <input type="text" name="manufacturer" value="${product.manufacturer}" required><br>

  <button type="submit">Cập nhật</button>
</form>
<a href="products">Quay lại danh sách</a>
</body>
</html>
