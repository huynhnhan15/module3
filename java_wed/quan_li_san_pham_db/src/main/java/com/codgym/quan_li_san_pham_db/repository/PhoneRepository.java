package com.codgym.quan_li_san_pham_db.repository;

import com.codgym.quan_li_san_pham_db.Util.BaseRepository;
import com.codgym.quan_li_san_pham_db.model.Phone;

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
    private static final String UPDATE = "UPDATE phones SET name=?, price=?, description=?, manufacturer=? WHERE id=?";
    private static final String DELETE = "DELETE FROM phones WHERE id=?";
    private static final String SEARCH_BY_NAME = "SELECT * FROM phones WHERE name LIKE ?";

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



    @Override
    public boolean update(Phone phone) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setDouble(2, phone.getPrice());
            preparedStatement.setString(3, phone.getDescription());
            preparedStatement.setString(4, phone.getManufacturer());
            preparedStatement.setInt(5, phone.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public List<Phone> searchByName(String name) {
        List<Phone> phones = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
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
}