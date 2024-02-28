package com.task.hrms.repository;

import com.task.hrms.model.ReportingOfficer;
import com.task.hrms.model.RoleModuleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleModuleMappingRepo extends JpaRepository<RoleModuleMapping,Long> {

    @Query("SELECT r FROM RoleModuleMapping r WHERE r.isEnable = true ORDER BY r.id DESC")
    List<RoleModuleMapping> findAllEnable();
}
