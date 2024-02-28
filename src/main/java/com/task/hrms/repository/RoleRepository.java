package com.task.hrms.repository;

import com.task.hrms.model.Department;
import com.task.hrms.model.Job;
import com.task.hrms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.isEnable = true ORDER BY r.id DESC")
    List<Role> findAllEnable();
}
