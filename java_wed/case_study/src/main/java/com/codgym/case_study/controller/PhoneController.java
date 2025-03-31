package com.codgym.case_study.controller;

import com.codgym.case_study.model.Phone;
import com.codgym.case_study.service.IPhoneService;
import com.codgym.case_study.service.PhoneService;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "PhoneController", urlPatterns = {
        "/phone", "/phone/detail", "/phone/delete", "/phone/confirmDelete",
        "/phone/search", "/phone/add", "/phone/updateStatus"
})
@MultipartConfig
public class PhoneController extends HttpServlet {
    private final IPhoneService phoneService = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/phone":
                showPhoneList(request, response);
                break;
            case "/phone/detail":
                showPhoneDetail(request, response);
                break;
            case "/phone/delete":
                deletePhone(request, response);
                break;
            case "/phone/confirmDelete":
                confirmDelete(request, response);
                break;
            case "/phone/search":
                searchPhones(request, response);
                break;
            case "/phone/add":
                showAddProductForm(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/phone");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/phone/updateStatus":
                updatePhoneStatus(request, response);
                break;
            case "/phone/add":
                addProduct(request, response);
                break;
            default:
                doGet(request, response);
                break;
        }
    }

    private void showPhoneList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> phoneList = phoneService.getAllPhones();
        request.setAttribute("phoneList", phoneList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void showPhoneDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Phone phone = phoneService.getPhoneById(id);
                if (phone != null) {
                    request.setAttribute("phone", phone);
                    request.getRequestDispatcher("/WEB-INF/views/phone/detail.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/phone");
    }

    private void deletePhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                phoneService.deletePhoneById(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/phone");
    }

    private void confirmDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Phone phone = phoneService.getPhoneById(id);
                if (phone != null) {
                    request.setAttribute("phone", phone);
                    request.getRequestDispatcher("/WEB-INF/views/phone/confirm_delete.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/phone");
    }

    private void searchPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Phone> phoneList = phoneService.searchPhones(keyword);
        request.setAttribute("phoneList", phoneList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void showAddProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/phone/add_product.jsp").forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String ten = request.getParameter("ten");
        String thuongHieu = request.getParameter("thuongHieu");
        String model = request.getParameter("model");
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        double gia = Double.parseDouble(request.getParameter("gia"));
        int ram = Integer.parseInt(request.getParameter("ram"));
        int boNhoTrong = Integer.parseInt(request.getParameter("boNhoTrong"));
        int dungLuongPin = Integer.parseInt(request.getParameter("dungLuongPin"));
        String heDieuHanh = request.getParameter("heDieuHanh");
        String trangThai = request.getParameter("trangThai");
        String hinhAnh = request.getParameter("hinhAnh"); // Đây là đường dẫn ảnh (ví dụ: uploads/iphone_new.jpg)

        Phone phone = new Phone();
        phone.setTen(ten);
        phone.setThuongHieu(thuongHieu);
        phone.setModel(model);
        phone.setNamSanXuat(namSanXuat);
        phone.setGia(gia);
        phone.setRam(ram);
        phone.setBoNhoTrong(boNhoTrong);
        phone.setDungLuongPin(dungLuongPin);
        phone.setHeDieuHanh(heDieuHanh);
        phone.setTrangThai(trangThai);
        phone.setHinhAnh(hinhAnh);


        phoneService.addPhone(phone);

        response.sendRedirect(request.getContextPath() + "/phone");
    }

    private void updatePhoneStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String newStatus = request.getParameter("newStatus");

        if (idStr != null && newStatus != null) {
            try {
                int id = Integer.parseInt(idStr);
                phoneService.updatePhoneStatus(id, newStatus);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/phone/detail?id=" + idStr);
    }
}
