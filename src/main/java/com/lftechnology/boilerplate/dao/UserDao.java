package com.lftechnology.boilerplate.dao;

import java.util.UUID;

import com.lftechnology.boilerplate.entity.User;

/**
 * Common CRUD operations.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public interface UserDao extends CrudDao<User, UUID> {
}
