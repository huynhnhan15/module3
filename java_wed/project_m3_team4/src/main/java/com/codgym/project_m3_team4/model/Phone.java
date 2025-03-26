package com.codgym.project_m3_team4.model;

import java.security.Timestamp;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private String model;
    private int manufactureYear;
    private double price;
    private int ram;
    private int storage;
    private int batteryCapacity;
    private String operatingSystem;
    private String status;
    private String image;
    private Timestamp createdAt;

    public Phone() {
    }

    public Phone(int batteryCapacity, String brand, Timestamp createdAt, int id, int manufactureYear, String model, String name, String operatingSystem, double price, int ram, String status, int storage) {
        this.batteryCapacity = batteryCapacity;
        this.brand = brand;
        this.createdAt = createdAt;
        this.id = id;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.ram = ram;
        this.status = status;
        this.storage = storage;
    }

    public Phone(int id, String name, String brand, String model, int manufactureYear, double price, int ram, int storage, int batteryCapacity, String operatingSystem, String status) {
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setOs(String heDieuHanh) {
    }

    public void setBattery(int dungLuongPin) {
    }

    public void setYear(int namSanXuat) {
    }
}
