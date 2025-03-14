package com.codgym.ss11.repository;


import com.codgym.ss11.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(Product product);
    void delete(int id);
    List<Product> searchByName(String name);
}