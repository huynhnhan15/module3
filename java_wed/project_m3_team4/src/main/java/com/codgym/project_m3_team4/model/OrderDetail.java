package com.codgym.project_m3_team4.model;

public class OrderDetail {
    private int id;
    private int orderId;
    private int phoneId;
    private int quantity;
    private double price;

    public OrderDetail(int id, int orderId, int phoneId, double price, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.phoneId = phoneId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetail() {
    }
}
