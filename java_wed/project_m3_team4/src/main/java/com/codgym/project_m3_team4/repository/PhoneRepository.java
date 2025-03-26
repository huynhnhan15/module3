
package com.codgym.project_m3_team4.repository;

import com.codgym.project_m3_team4.model.Phone;
import com.codgym.project_m3_team4.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PhoneRepository implements IDienThoaiRepository {
    private static final String SELECT_ALL_PHONES = "SELECT * FROM dien_thoai";
    private static final String DELETE_PHONE_BY_ID = "DELETE FROM dien_thoai WHERE id_dien_thoai = ?";
    private static final String UPDATE_PHONE_SQL =
            "UPDATE dien_thoai SET ten = ?, thuong_hieu = ?, model = ?, nam_san_xuat = ?, gia = ?, ram = ?, bo_nho_trong = ?, dung_luong_pin = ?, he_dieu_hanh = ?, trang_thai = ? WHERE id_dien_thoai = ?";

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phoneList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHONES);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getInt("id_dien_thoai"));
                phone.setName(resultSet.getString("ten"));
                phone.setBrand(resultSet.getString("thuong_hieu"));
                phone.setModel(resultSet.getString("model"));
                phone.setYear(resultSet.getInt("nam_san_xuat"));
                phone.setPrice(resultSet.getDouble("gia"));
                phone.setRam(resultSet.getInt("ram"));
                phone.setStorage(resultSet.getInt("bo_nho_trong"));
                phone.setBattery(resultSet.getInt("dung_luong_pin"));
                phone.setOs(resultSet.getString("he_dieu_hanh"));
                phone.setStatus(resultSet.getString("trang_thai"));

                phoneList.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneList;
    }

    @Override
    public void deletePhone(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PHONE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhone(Phone phone) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHONE_SQL)) {

            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setString(3, phone.getModel());
            preparedStatement.setInt(4, phone.getManufactureYear());
            preparedStatement.setDouble(5, phone.getPrice());
            preparedStatement.setInt(6, phone.getRam());
            preparedStatement.setInt(7, phone.getStorage());
            preparedStatement.setInt(8, phone.getBatteryCapacity());
            preparedStatement.setString(9, phone.getOperatingSystem());
            preparedStatement.setString(10, phone.getStatus());
            preparedStatement.setInt(11, phone.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}