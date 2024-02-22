package com.task.hrms.repository;

import com.task.hrms.model.Department;
import com.task.hrms.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DesignationRepository extends JpaRepository<Designation,Long> {
    @Query("SELECT d FROM Designation d WHERE d.isEnable = true ORDER BY d.id DESC")
    List<Designation> findAllEnable();
}
