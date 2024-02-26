package com.task.hrms.repository;

import com.task.hrms.model.Job;
import com.task.hrms.model.ReportingOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportingOfficerRepository extends JpaRepository<ReportingOfficer,Long> {
    @Query("SELECT r FROM ReportingOfficer r WHERE r.isEnable = true ORDER BY r.id DESC")
    List<ReportingOfficer> findAllEnable();
    @Query("SELECT r FROM ReportingOfficer r WHERE r.isEnable = true and r.employee.id =:id ORDER BY r.id DESC")
    ReportingOfficer findWithEmployee(@Param("id") Long id);
}
