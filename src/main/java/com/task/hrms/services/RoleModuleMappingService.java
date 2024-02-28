package com.task.hrms.services;

import com.task.hrms.model.RoleModuleMapping;

import java.util.List;

public interface RoleModuleMappingService {

    RoleModuleMapping save(RoleModuleMapping roleModuleMapping);

    RoleModuleMapping findById(Long id);

    List<RoleModuleMapping> findAll();

    void delete(Long id);
}
