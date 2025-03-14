package com.codgym.ss11.controller;

import com.codgym.ss11.model.Product;
import com.codgym.ss11.service.IProductService;
import com.codgym.ss11.service.ProductServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create":
                request.getRequestDispatcher("/WEB-INF/views/product/create.jsp").forward(request, response);
                break;
            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", productService.findById(editId));
                request.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(request, response);
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                productService.delete(deleteId);
                response.sendRedirect("products");
                break;
            default:
                List<Product> products = productService.findAll();
                request.setAttribute("products", products);
                request.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String manufacturer = request.getParameter("manufacturer");

            productService.save(new Product(productService.findAll().size() + 1, name, price, description, manufacturer));
            response.sendRedirect("products");
        }
    }
}