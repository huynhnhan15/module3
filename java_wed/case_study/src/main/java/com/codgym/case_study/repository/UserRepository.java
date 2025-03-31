package com.codgym.case_study.repository;

import com.codgym.case_study.model.User;
import com.codgym.case_study.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String SELECT_ALL_USERS = "SELECT * FROM nguoi_dung";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_nguoi_dung"); // Sửa từ 'id' thành 'id_nguoi_dung'
                String username = rs.getString("ten_dang_nhap");
                String email = rs.getString("email");
                String role = rs.getString("vai_tro");

                users.add(new User(id, username, email, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}