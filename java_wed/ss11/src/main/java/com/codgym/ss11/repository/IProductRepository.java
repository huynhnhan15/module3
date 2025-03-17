package com.codgym.ss11.repository;


import com.codgym.ss11.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);

}