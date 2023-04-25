package com.example.springboot.service;


import com.example.springboot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    User getUser(Long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}
