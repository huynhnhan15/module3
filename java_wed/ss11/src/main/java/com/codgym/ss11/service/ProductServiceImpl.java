package com.codgym.ss11.service;

import com.codgym.ss11.model.Product;
import com.codgym.ss11.repository.IProductRepository;
import com.codgym.ss11.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {  // Bỏ abstract
    private final IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return null;
    }


}
