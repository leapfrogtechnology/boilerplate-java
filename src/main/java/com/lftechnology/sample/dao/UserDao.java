package com.lftechnology.sample.dao;

import com.lftechnology.sample.model.User;

public interface UserDao {
    User save(User u);

    User findById(Long id);
}
