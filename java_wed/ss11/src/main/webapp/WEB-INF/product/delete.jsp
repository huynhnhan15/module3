<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Xóa sản phẩm</title>
</head>
<body>
<h2>Bạn có chắc muốn xóa sản phẩm này?</h2>
<p>ID: ${product.id}</p>
<p>Tên: ${product.name}</p>
<p>Giá: ${product.price}</p>
<p>Mô tả: ${product.description}</p>
<p>Nhà sản xuất: ${product.manufacturer}</p>

<form action="products?action=delete" method="post">
  <input type="hidden" name="id" value="${product.id}">
  <button type="submit">Xóa</button>
</form>
<a href="products">Quay lại danh sách</a>
</body>
</html>