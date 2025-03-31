package com.codgym.case_study.repository;

import com.codgym.case_study.model.Phone;
import com.codgym.case_study.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.codgym.case_study.util.DBConnection.getConnection;

public class PhoneRepository implements IPhoneRepository {

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phones = new ArrayList<>();
        String sql = "SELECT * FROM dien_thoai";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
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
                phones.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public Phone getPhoneById(int id) {
        Phone phone = null;
        String sql = "SELECT * FROM dien_thoai WHERE id_dien_thoai = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    phone = new Phone();
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
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phone;
    }

    @Override
    public void deletePhoneById(int id) {
        String sql = "DELETE FROM dien_thoai WHERE id_dien_thoai = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Phone> searchPhones(String keyword) {
        List<Phone> phones = new ArrayList<>();
        String sql = "SELECT * FROM dien_thoai WHERE ten LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
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
                    phones.add(phone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }

    @Override
    public void addPhone(Phone phone) {
        String sql = "INSERT INTO dien_thoai (ten, thuong_hieu, model, nam_san_xuat, gia, ram, bo_nho_trong, dung_luong_pin, he_dieu_hanh, trang_thai, hinh_anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phone.getTen());
            ps.setString(2, phone.getThuongHieu());
            ps.setString(3, phone.getModel());
            ps.setInt(4, phone.getNamSanXuat());
            ps.setDouble(5, phone.getGia());
            ps.setInt(6, phone.getRam());
            ps.setInt(7, phone.getBoNhoTrong());
            ps.setInt(8, phone.getDungLuongPin());
            ps.setString(9, phone.getHeDieuHanh());
            ps.setString(10, phone.getTrangThai());
            ps.setString(11, phone.getHinhAnh());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhoneStatus(int id, String newStatus) {
        String query = "UPDATE phones SET trangThai = ? WHERE idDienThoai = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

