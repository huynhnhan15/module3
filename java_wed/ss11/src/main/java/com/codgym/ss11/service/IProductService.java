package com.codgym.ss11.service;

import com.codgym.ss11.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
}