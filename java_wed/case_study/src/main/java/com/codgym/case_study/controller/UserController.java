package com.codgym.case_study.controller;

import com.codgym.case_study.model.User;
import com.codgym.case_study.service.IUserService;
import com.codgym.case_study.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = {"/user/list"})
public class UserController extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();

        if (users == null || users.isEmpty()) {
            System.out.println("Danh sách người dùng rỗng!");
        } else {
            System.out.println("Số lượng người dùng: " + users.size());
            for (User user : users) {
                System.out.println("User: " + user.getUsername() + " - Email: " + user.getEmail());
            }
        }

        // Đặt danh sách vào request attribute
        request.setAttribute("userList", users);

        // Điều hướng đến JSP (kiểm tra lại đường dẫn)
        request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
    }
}
