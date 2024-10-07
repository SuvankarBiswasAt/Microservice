package com.shiv.user.service;

import com.shiv.user.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User saveUser(User user);

    User getUserById(Long id);

    Boolean updateUser(User user);

    Boolean deleteUser(User user);
}
