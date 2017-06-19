package com.lftechnology.boilerplate.service;

import java.util.UUID;

import com.lftechnology.boilerplate.entity.User;

/**
 * Interface for user related task.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public interface UserService extends CrudService<User, UUID> {
}
