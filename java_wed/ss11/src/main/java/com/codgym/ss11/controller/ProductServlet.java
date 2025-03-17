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
    private final IProductService productService = new ProductServiceImpl() {

    }; // ✅ Đã sửa lỗi

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create":
                request.getRequestDispatcher("/WEB-INF/views/product/create.jsp").forward(request, response);
                break;

            case "edit":
                try {
                    int editId = Integer.parseInt(request.getParameter("id"));
                    Product product = productService.findById(editId);
                    if (product != null) {
                        request.setAttribute("product", product);
                        request.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("products?error=notfound");
                    }
                } catch (NumberFormatException e) {
                    response.sendRedirect("products?error=invalidId");
                }
                break;

            case "delete":
                try {
                    int deleteId = Integer.parseInt(request.getParameter("id"));

                    response.sendRedirect("products");
                } catch (NumberFormatException e) {
                    response.sendRedirect("products?error=invalidId");
                }
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
            try {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                String manufacturer = request.getParameter("manufacturer");

                Product newProduct = new Product(0, name, price, description, manufacturer); // ID = 0, để CSDL tự tăng

                response.sendRedirect("products");
            } catch (NumberFormatException e) {
                response.sendRedirect("products?error=invalidInput");
            }
        }
    }
}
