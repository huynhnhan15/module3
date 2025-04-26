<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mượn sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Mượn sách</h1>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>
    <div class="mb-3">
        <a href="books" class="btn btn-primary">Quay lại danh sách sách</a>
    </div>

    <div class="card">
        <div class="card-body">
            <form action="borrow?action=create" method="post" id="borrowForm">
                <div class="mb-3">
                    <label for="borrowId" class="form-label">Mã mượn sách</label>
                    <input type="text" class="form-control" id="borrowId" name="borrowId" value="${borrowId}" required pattern="MS-\d{4}" title="Mã mượn sách phải có định dạng MS-XXXX">
                    <div class="form-text">Định dạng: MS-XXXX (X là các số nguyên dương)</div>
                </div>

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">Tên sách</label>
                    <input type="text" class="form-control" id="bookTitle" value="${book.title}" readonly>
                    <input type="hidden" name="bookId" value="${book.bookId}">
                </div>

                <div class="mb-3">
                    <label for="studentId" class="form-label">Tên học sinh</label>
                    <select class="form-select" id="studentId" name="studentId" required>
                        <option value="" selected disabled>-- Chọn học sinh --</option>
                        <c:forEach var="student" items="${students}">
                            <option value="${student.studentId}">${student.fullName} - ${student.className}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="borrowDate" class="form-label">Ngày mượn sách</label>
                    <input type="date" class="form-control" id="borrowDate" name="borrowDate" value="${borrowDate}" readonly>
                </div>

                <div class="mb-3">
                    <label for="returnDate" class="form-label">Ngày trả sách</label>
                    <input type="date" class="form-control" id="returnDate" name="returnDate" required min="${borrowDate}">
                </div>

                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary">Mượn sách</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.getElementById('borrowDate').valueAsDate = new Date();
    document.getElementById('returnDate').min = document.getElementById('borrowDate').value;

    document.getElementById('returnButton').addEventListener('click', function() {
        var confirmModal = new bootstrap.Modal(document.getElementById('confirmModal'));
        confirmModal.show();
    });
</script>
</body>
</html>
