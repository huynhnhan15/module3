package com.codgym.ss11.repository;

import com.codgym.ss11.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop Dell", 1500.0, "Laptop mạnh mẽ", "Dell"));
        products.add(new Product(2, "iPhone 13", 1200.0, "Điện thoại cao cấp", "Apple"));
        products.add(new Product(3, "Samsung Galaxy", 1000.0, "Điện thoại Android", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
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
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}
