package com.codgym.case_study.repository;

import com.codgym.case_study.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUsers();
}