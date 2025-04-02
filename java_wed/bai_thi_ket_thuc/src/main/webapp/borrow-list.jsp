<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách mượn sách</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center mb-4">Danh sách mượn sách</h1>

  <div class="mb-3">
    <a href="books" class="btn btn-primary">Quay lại danh sách sách</a>
  </div>

  <table class="table table-striped table-hover">
    <thead class="table-dark">
    <tr>
      <th>Mã mượn sách</th>
      <th>Tên sách</th>
      <th>Tên học sinh</th>
      <th>Ngày mượn</th>
      <th>Ngày trả</th>
      <th>Trạng thái</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="borrowCards" scope="request" type="java.util.List"/>
    <c:forEach var="card" items="${borrowCards}">
      <tr>
        <td>${card.borrowId}</td>
        <td>${card.book.title}</td>
        <td>${card.student.fullName} - ${card.student.className}</td>
        <td>
          <fmt:parseDate value="${card.borrowDate}" pattern="yyyy-MM-dd" var="parsedBorrowDate" type="date" />
          <fmt:formatDate value="${parsedBorrowDate}" pattern="dd/MM/yyyy" />
        </td>
        <td>
          <fmt:parseDate value="${card.returnDate}" pattern="yyyy-MM-dd" var="parsedReturnDate" type="date" />
          <fmt:formatDate value="${parsedReturnDate}" pattern="dd/MM/yyyy" />
        </td>
        <td>
          <c:choose>
            <c:when test="${card.status}">
              <span class="badge bg-warning">Đang mượn</span>
            </c:when>
            <c:otherwise>
              <span class="badge bg-success">Đã trả</span>
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>