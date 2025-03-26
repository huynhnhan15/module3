package com.codgym.project_m3_team4.controller;

import com.codgym.project_m3_team4.model.Phone;
import com.codgym.project_m3_team4.service.IDienThoaiService;
import com.codgym.project_m3_team4.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet", urlPatterns = {"/phones"})
public class PhoneServlet extends HttpServlet {
    private IDienThoaiService phoneService = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listPhones(request, response);
                break;
        }

    }

    private void listPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> phoneList = phoneService.getAllPhones();
        request.setAttribute("phones", phoneList);
        request.getRequestDispatcher("WEB-INF/views/phone/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Phone existingPhone = phoneService.getPhoneById(id);
        request.setAttribute("phone", existingPhone);
        request.getRequestDispatcher("WEB-INF/views/phone/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            updatePhone(request, response);
        }
    }

    private void updatePhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");

        // Kiểm tra chuỗi rỗng trước khi chuyển đổi số
        int manufactureYear = parseInteger(request.getParameter("manufactureYear"), 0);
        double price = parseDouble(request.getParameter("price"), 0.0);
        int ram = parseInteger(request.getParameter("ram"), 0);
        int storage = parseInteger(request.getParameter("storage"), 0);
        int batteryCapacity = parseInteger(request.getParameter("batteryCapacity"), 0);

        String operatingSystem = request.getParameter("operatingSystem");
        String status = request.getParameter("status");

        Phone phone = new Phone(id, name, brand, model, manufactureYear, price, ram, storage, batteryCapacity, operatingSystem, status);
        phoneService.updatePhone(phone);

        response.sendRedirect("phones");
    }

    // Hàm xử lý giá trị rỗng khi chuyển đổi sang số nguyên
    private int parseInteger(String value, int defaultValue) {
        try {
            return (value == null || value.trim().isEmpty()) ? defaultValue : Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // Hàm xử lý giá trị rỗng khi chuyển đổi sang số thực
    private double parseDouble(String value, double defaultValue) {
        try {
            return (value == null || value.trim().isEmpty()) ? defaultValue : Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
