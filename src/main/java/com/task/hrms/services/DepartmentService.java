package com.task.hrms.services;

import com.task.hrms.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllEnable();

    Department save(Department department);

    Department findById(Long id);

    void delete(Long id);
}
