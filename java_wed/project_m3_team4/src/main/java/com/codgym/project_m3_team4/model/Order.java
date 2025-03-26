package com.codgym.project_m3_team4.model;

import java.security.Timestamp;

public class Order {
    private int userId;
    private String status;
    private int id;
    private double totalAmount;
    private Timestamp createdAt;

    public Order(Timestamp createdAt, int id, String status, double totalAmount, int userId) {
        this.createdAt = createdAt;
        this.id = id;
        this.status = status;
        this.totalAmount = totalAmount;
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Order() {
    }
}
