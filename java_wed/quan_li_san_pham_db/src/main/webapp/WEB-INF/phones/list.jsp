<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách điện thoại</title>
  <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<h1>Danh sách điện thoại</h1>
<a href="/phones?action=create">Thêm mới</a>
<table class="table table-bordered">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Mô tả</th>
    <th>Hãng sản xuất</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="phone" items="${phoneList}">
    <tr>
      <td>${phone.id}</td>
      <td>${phone.name}</td>
      <td>${phone.price}</td>
      <td>${phone.description}</td>
      <td>${phone.manufacturer}</td>
      <td>
        <a href="/phones?action=edit&id=${phone.id}" class="btn btn-primary btn-sm">Sửa</a>
        <a href="/phones?action=delete&id=${phone.id}" class="btn btn-danger btn-sm">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
