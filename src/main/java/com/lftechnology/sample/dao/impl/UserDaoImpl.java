package com.lftechnology.sample.dao.impl;

import com.lftechnology.sample.dao.UserDao;
import com.lftechnology.sample.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User u) {
        em.persist(u);
        return u;
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }
}
