package com.task.hrms.services;

import com.task.hrms.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEnable();

    Employee save(Employee employee);

    Employee findById(Long id);

    void delete(Long id);
}
