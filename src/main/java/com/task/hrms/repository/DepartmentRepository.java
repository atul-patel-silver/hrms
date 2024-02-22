package com.task.hrms.repository;

import com.task.hrms.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query("SELECT d FROM Department d WHERE d.isEnable = true ORDER BY d.id DESC")
    List<Department> findAllEnable();
}
