package com.codgym.project_m3_team4.controller;

import com.codgym.project_m3_team4.model.Phone;
import com.codgym.project_m3_team4.service.IPhoneService;
import com.codgym.project_m3_team4.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phones")
public class PhoneServlet extends HttpServlet {
    private IPhoneService phoneService;

    @Override
    public void init() throws ServletException {
        phoneService = new PhoneService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số action từ request
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "";
        }

        // Lấy danh sách điện thoại từ service
        List<Phone> phoneList = phoneService.getAllPhones();
        request.setAttribute("phoneList", phoneList);

        // Kiểm tra action và forward đến JSP tương ứng
        if ("manage".equals(action)) {
            // Chuyển đến trang quản lý sản phẩm
            request.getRequestDispatcher("/WEB-INF/views/phone/manage.jsp").forward(request, response);
        } else {
            // Mặc định chuyển đến trang chủ
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }
}
