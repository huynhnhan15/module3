package com.codgym.case_study.service;

import com.codgym.case_study.model.User;
import com.codgym.case_study.repository.IUserRepository;
import com.codgym.case_study.repository.UserRepository;

import java.util.List;


public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
        public List<User> getAllUsers () {
            List<User> users = userRepository.getAllUsers();
            System.out.println("Số lượng người dùng từ service: " + users.size());
            return users;
        }
    }
