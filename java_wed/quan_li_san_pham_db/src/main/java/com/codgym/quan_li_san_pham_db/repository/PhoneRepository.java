package com.codgym.quan_li_san_pham_db.repository;

import com.codgym.quan_li_san_pham_db.model.Phone;
import com.codgym.quan_li_san_pham_db.util.BaseRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PhoneRepository implements IPhoneRepository {
    private static final String SELECT_ALL = "SELECT * FROM phones";
    private static final String SELECT_BY_ID = "SELECT * FROM phones WHERE id = ?";
    private static final String INSERT = "INSERT INTO phones (name, price, description, manufacturer) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM phones WHERE id=?";

    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                phones.add(new Phone(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("manufacturer")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public Phone findById(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Phone(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("manufacturer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}