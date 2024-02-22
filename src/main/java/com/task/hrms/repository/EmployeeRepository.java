package com.task.hrms.repository;

import com.task.hrms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.isEnable = true ORDER BY e.id DESC")
    List<Employee> findAllEnable();
}
