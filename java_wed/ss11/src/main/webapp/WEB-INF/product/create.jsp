<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form action="products?action=create" method="post">
  <label>Tên sản phẩm:</label>
  <input type="text" name="name" required><br>

  <label>Giá sản phẩm:</label>
  <input type="number" name="price" step="0.01" required><br>

  <label>Mô tả:</label>
  <textarea name="description" required></textarea><br>

  <label>Nhà sản xuất:</label>
  <input type="text" name="manufacturer" required><br>

  <button type="submit">Thêm</button>
</form>
<a href="products">Quay lại danh sách</a>
</body>
</html>