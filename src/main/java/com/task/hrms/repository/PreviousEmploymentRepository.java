package com.task.hrms.repository;

import com.task.hrms.model.Job;
import com.task.hrms.model.PreviousEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreviousEmploymentRepository extends JpaRepository<PreviousEmployment,Long> {
    @Query("SELECT p FROM PreviousEmployment p WHERE p.isEnable = true ORDER BY p.id DESC")
    List<PreviousEmployment> findAllEnable();
}
