package com.task.hrms.services.implementation;

import com.task.hrms.model.Role;
import com.task.hrms.repository.RoleRepository;
import com.task.hrms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoleServiceImple implements RoleService {
@Autowired
    private RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return this.roleRepository.findById(id).get();
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Role role = this.roleRepository.findById(id).get();
        role.setEnable(false);
        this.roleRepository.save(role);

    }
}
