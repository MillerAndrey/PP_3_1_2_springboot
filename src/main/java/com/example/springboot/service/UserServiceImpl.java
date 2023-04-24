package com.example.springboot.service;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }


    @Override
    @Transactional
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
