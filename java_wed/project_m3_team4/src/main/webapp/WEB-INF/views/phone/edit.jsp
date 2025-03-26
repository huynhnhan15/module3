<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Phone</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>Chỉnh sửa</h3>
        </div>
        <div class="card-body">
            <form action="phones" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${phone.id}">

                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Name</label>
                            <input type="text" name="name" class="form-control" value="${phone.name}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Brand</label>
                            <input type="text" name="brand" class="form-control" value="${phone.brand}" required>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Model</label>
                            <input type="text" name="model" class="form-control" value="${phone.model}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Manufacture Year</label>
                            <input type="number" name="manufactureYear" class="form-control" value="${phone.manufactureYear}" required>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Price ($)</label>
                            <input type="number" step="0.01" name="price" class="form-control" value="${phone.price}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">RAM (GB)</label>
                            <input type="number" name="ram" class="form-control" value="${phone.ram}" required>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Storage (GB)</label>
                            <input type="number" name="storage" class="form-control" value="${phone.storage}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Battery (mAh)</label>
                            <input type="number" name="batteryCapacity" class="form-control" value="${phone.batteryCapacity}" required>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Operating System</label>
                            <input type="text" name="operatingSystem" class="form-control" value="${phone.operatingSystem}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mb-3">
                            <label class="form-label fw-bold">Status</label>
                            <select name="status" class="form-select" required>
                                <option value="Available" ${phone.status == 'Available' ? 'selected' : ''}>con_hang</option>
                                <option value="Out of Stock" ${phone.status == 'Out of Stock' ? 'selected' : ''}>con_hang</option>
                                <option value="Discontinued" ${phone.status == 'Discontinued' ? 'selected' : ''}>con_hang</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success px-4">Cập Nhập</button>
                    <a href="phones" class="btn btn-danger px-4">Thoát</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
