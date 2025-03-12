package com.codgym.ss11.repository;


import com.codgym.ss11.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void add(Product product);
    void update(Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> searchByName(String name);
}