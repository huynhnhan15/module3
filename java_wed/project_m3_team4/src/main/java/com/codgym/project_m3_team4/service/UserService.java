package com.codgym.project_m3_team4.service;

import com.codgym.project_m3_team4.model.User;
import com.codgym.project_m3_team4.repository.IUserRepository;
import com.codgym.project_m3_team4.repository.UserRepository;
import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
