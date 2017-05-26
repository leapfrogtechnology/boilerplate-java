package com.lftechnology.sample.dao.impl;

import com.lftechnology.sample.dao.RoleDao;
import com.lftechnology.sample.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role save(Role userRole) {
        em.persist(userRole);
        return userRole;
    }

    @Override
    public Role findById(Long id) {
        return em.find(Role.class, id);
    }
}
