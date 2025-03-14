package com.codgym.ss11.repository;

import com.codgym.ss11.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop Dell", 1500, "Laptop văn phòng", "Dell"));
        products.add(new Product(2, "iPhone 14", 1200, "Điện thoại Apple", "Apple"));
        products.add(new Product(3, "Samsung S23", 1100, "Điện thoại Samsung", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacturer(product.getManufacturer());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}
