package com.task.hrms.services.implementation;

import com.task.hrms.model.RoleModuleMapping;
import com.task.hrms.repository.RoleModuleMappingRepo;
import com.task.hrms.services.RoleModuleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleModuleMappingServiceImple implements RoleModuleMappingService {
    @Autowired
    private RoleModuleMappingRepo roleModuleMappingRepo;

    @Override
    public RoleModuleMapping save(RoleModuleMapping roleModuleMapping) {
        return this.roleModuleMappingRepo.save(roleModuleMapping);
    }

    @Override
    public RoleModuleMapping findById(Long id) {
        return this.roleModuleMappingRepo.findById(id).get();
    }

    @Override
    public List<RoleModuleMapping> findAll() {
        return this.roleModuleMappingRepo.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        RoleModuleMapping roleModuleMapping = this.roleModuleMappingRepo.findById(id).get();
        roleModuleMapping.setEnable(false);
        this.roleModuleMappingRepo.save(roleModuleMapping);
    }
}
