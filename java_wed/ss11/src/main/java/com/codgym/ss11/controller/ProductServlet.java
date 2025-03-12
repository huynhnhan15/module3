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
        List<Product> productList = productService.getAllProducts();
        request.setAttribute("products", productList);
        request.getRequestDispatcher("/WEB-INF/product/list.jsp").forward(request, response);
    }
}