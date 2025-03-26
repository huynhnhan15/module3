package com.codgym.project_m3_team4.controller;

import com.codgym.project_m3_team4.service.IUserService;
import com.codgym.project_m3_team4.service.UserService;
import com.codgym.project_m3_team4.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = userService.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
    }
}

