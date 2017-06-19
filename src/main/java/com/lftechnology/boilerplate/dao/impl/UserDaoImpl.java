package com.lftechnology.boilerplate.dao.impl;

import java.util.UUID;

import com.lftechnology.boilerplate.dao.UserDao;
import com.lftechnology.boilerplate.entity.User;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 *
 */
public class UserDaoImpl extends BaseDao<User, UUID> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
