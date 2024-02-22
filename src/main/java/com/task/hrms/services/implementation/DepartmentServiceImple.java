package com.task.hrms.services.implementation;

import com.task.hrms.model.Department;
import com.task.hrms.repository.DepartmentRepository;
import com.task.hrms.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImple implements DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAllEnable() {
        return this.departmentRepository.findAllEnable();
    }

    @Override
    public Department save(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department findById(Long id) {
        return this.departmentRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Department department = this.departmentRepository.findById(id).get();
        department.setEnable(false);
        this.departmentRepository.save(department);
    }
}
