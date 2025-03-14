<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chi tiết sản phẩm</title>
</head>
<body>
<h2>Thông tin chi tiết sản phẩm</h2>
<p><strong>ID:</strong> ${product.id}</p>
<p><strong>Tên:</strong> ${product.name}</p>
<p><strong>Giá:</strong> ${product.price}</p>
<p><strong>Mô tả:</strong> ${product.description}</p>
<p><strong>Nhà sản xuất:</strong> ${product.manufacturer}</p>

<a href="products">Quay lại danh sách</a>
</body>
</html>