package com.task.hrms.repository;

import com.task.hrms.model.Family;
import com.task.hrms.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QualificationRepository extends JpaRepository<Qualification,Long> {

    @Query("SELECT q FROM Qualification q WHERE q.isEnable = true ORDER BY q.id DESC")
    List<Qualification> findAllEnable();
    @Query("SELECT q FROM Qualification q WHERE q.isEnable = true AND q.employee.id =:id ORDER BY q.id DESC")
    List<Qualification> findQualificationWithEmpId(@Param("id") Long empId);
}
