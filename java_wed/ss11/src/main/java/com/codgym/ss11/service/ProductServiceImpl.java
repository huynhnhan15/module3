package com.codgym.ss11.service;


import com.codgym.ss11.model.Product;
import com.codgym.ss11.repository.IProductRepository;
import com.codgym.ss11.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.searchByName(name);
    }
}