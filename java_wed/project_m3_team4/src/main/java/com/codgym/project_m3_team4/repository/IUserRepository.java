package com.codgym.project_m3_team4.repository;

import com.codgym.project_m3_team4.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUsers();
}