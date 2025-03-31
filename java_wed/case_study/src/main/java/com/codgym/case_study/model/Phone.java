package com.codgym.case_study.model;

public class Phone {
    private int idDienThoai;
    private String ten;
    private String thuongHieu;
    private String model;
    private int namSanXuat;
    private double gia;
    private int ram;
    private int boNhoTrong;
    private int dungLuongPin;
    private String heDieuHanh;
    private String trangThai;
    private String hinhAnh;

    public Phone() {
    }

    public Phone(int idDienThoai, String ten, String thuongHieu, String model, int namSanXuat, double gia, int ram, int boNhoTrong, int dungLuongPin, String heDieuHanh, String trangThai, String hinhAnh) {
        this.idDienThoai = idDienThoai;
        this.ten = ten;
        this.thuongHieu = thuongHieu;
        this.model = model;
        this.namSanXuat = namSanXuat;
        this.gia = gia;
        this.ram = ram;
        this.boNhoTrong = boNhoTrong;
        this.dungLuongPin = dungLuongPin;
        this.heDieuHanh = heDieuHanh;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    public int getIdDienThoai() {
        return idDienThoai;
    }

    public void setIdDienThoai(int idDienThoai) {
        this.idDienThoai = idDienThoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBoNhoTrong() {
        return boNhoTrong;
    }

    public void setBoNhoTrong(int boNhoTrong) {
        this.boNhoTrong = boNhoTrong;
    }

    public int getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(int dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
