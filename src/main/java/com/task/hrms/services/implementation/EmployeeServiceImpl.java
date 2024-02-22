package com.task.hrms.services.implementation;

import com.task.hrms.model.Employee;
import com.task.hrms.repository.EmployeeRepository;
import com.task.hrms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAllEnable() {
        return this.employeeRepository.findAllEnable();
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Employee employee = this.employeeRepository.findById(id).get();
        employee.setEnable(false);
        this.employeeRepository.save(employee);
    }

}
