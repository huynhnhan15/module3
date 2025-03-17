<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm điện thoại</title>
  <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<div class="container mt-3">
  <h1>Thêm điện thoại</h1>
  <form action="/phones?action=create" method="post">
    <div class="mb-3">
      <label class="form-label">Tên điện thoại</label>
      <input type="text" name="name" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">Giá</label>
      <input type="number" name="price" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">Mô tả</label>
      <input type="text" name="description" class="form-control">
    </div>
    <div class="mb-3">
      <label class="form-label">Hãng sản xuất</label>
      <input type="text" name="manufacturer" class="form-control">
    </div>
    <button type="submit" class="btn btn-success">Thêm mới</button>
    <a href="/phones" class="btn btn-secondary">Quay lại</a>
  </form>
</div>
</body>
</html>
