package com.codgym.quan_li_san_pham_db.controller;


import com.codgym.quan_li_san_pham_db.model.Phone;
import com.codgym.quan_li_san_pham_db.service.IPhoneService;
import com.codgym.quan_li_san_pham_db.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet", value  = "/phones")
public class PhoneServlet extends HttpServlet {
    private IPhoneService phoneService = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "search":
//                searchPhone(request, response);
                break;
            default:
                listPhones(request, response);
        }
    }

    private void listPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> phones = phoneService.findAll();
        request.setAttribute("phones", phones);
        request.getRequestDispatcher("/phones/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("phones/create.jsp").forward(request, response);
    }


}