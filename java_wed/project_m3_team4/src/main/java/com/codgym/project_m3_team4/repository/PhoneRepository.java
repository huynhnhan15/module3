
package com.codgym.project_m3_team4.repository;

import com.codgym.project_m3_team4.model.Phone;
import com.codgym.project_m3_team4.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository implements IPhoneRepository {

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phoneList = new ArrayList<>();
        String query = "SELECT * FROM dien_thoai";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Phone phone = new Phone();
                phone.setIdDienThoai(rs.getInt("id_dien_thoai"));
                phone.setTen(rs.getString("ten"));
                phone.setThuongHieu(rs.getString("thuong_hieu"));
                phone.setModel(rs.getString("model"));
                phone.setNamSanXuat(rs.getInt("nam_san_xuat"));
                phone.setGia(rs.getDouble("gia"));
                phone.setRam(rs.getInt("ram"));
                phone.setBoNhoTrong(rs.getInt("bo_nho_trong"));
                phone.setDungLuongPin(rs.getInt("dung_luong_pin"));
                phone.setHeDieuHanh(rs.getString("he_dieu_hanh"));
                phone.setTrangThai(rs.getString("trang_thai"));
                phone.setHinhAnh(rs.getString("hinh_anh"));
                phoneList.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneList;
    }
}