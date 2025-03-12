<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh Sách Khách Hàng</title>
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>
<table border="1">
  <tr>
    <th>Họ và tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${customers}" var="customer">
    <tr>
      <td>${customer.name}</td>
      <td>${customer.birthday}</td>
      <td>${customer.address}</td>
      <td>
        <img src="${pageContext.request.contextPath}/${customer.image}" width="200">
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
