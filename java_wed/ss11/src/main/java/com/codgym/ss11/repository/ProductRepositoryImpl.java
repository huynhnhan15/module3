package com.codgym.ss11.repository;

import com.codgym.ss11.model.Product;
import com.codgym.ss11.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static final String SELECT_ALL = "SELECT * FROM Product";
    private static final String INSERT_PRODUCT = "INSERT INTO Product(name, price, description, manufacturer) VALUES (?, ?, ?, ?)";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        if (connection == null) {
            System.err.println("❌ Lỗi: Không thể kết nối đến database!");
            return products; // Trả về danh sách rỗng để tránh lỗi NullPointerException
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");

                products.add(new Product(id, name, price, description, manufacturer));
            }
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi truy vấn dữ liệu!");
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public Product findById(int id) {
        return null;
    }


}
