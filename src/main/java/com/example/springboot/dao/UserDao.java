package com.example.springboot.dao;



import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {

    public void saveUser(User user);

    public void removeUserById(long id);

    public List<User> getAllUsers();

    public User getUser(Long id);
}
