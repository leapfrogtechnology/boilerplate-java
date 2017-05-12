package com.lftechnology.sample.dao;

import com.lftechnology.sample.model.Role;

public interface RoleDao {
    Role save(Role u);

    Role findById(Long id);
}
