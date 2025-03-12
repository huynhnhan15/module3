package com.codgym.ss11.service;

import com.codgym.ss11.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> searchProductsByName(String name);
}