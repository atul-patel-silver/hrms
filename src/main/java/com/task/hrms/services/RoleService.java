package com.task.hrms.services;

import com.task.hrms.model.Role;

import java.util.List;

public interface RoleService {

    Role save(Role role);

    Role findById(Long id);

    List<Role> findAll();

    void delete(Long id);

}
