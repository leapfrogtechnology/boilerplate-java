package com.lftechnology.sample.service.impl;

import com.lftechnology.sample.dao.UserDao;
import com.lftechnology.sample.model.User;
import com.lftechnology.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private  UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id);
    }
}
