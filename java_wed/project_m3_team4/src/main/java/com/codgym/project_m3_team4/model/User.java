package com.codgym.project_m3_team4.model;

import java.security.Timestamp;

public class User {
    private int id;
    private String username;
    private String password;
    private String birthDate;
    private String address;
    private String email;
    private String phoneNumber;
    private String role;
    private Timestamp createdAt;

    public User(String address, String birthDate, Timestamp createdAt, String email, int id, String password, String phoneNumber, String role, String username) {
        this.address = address;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.email = email;
        this.id = id;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.username = username;
    }

    public User(int id, String username, String email, String phone, String role) {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
    }
}
