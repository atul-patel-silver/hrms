package com.task.hrms.repository;

import com.task.hrms.model.Job;
import com.task.hrms.model.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("SELECT j FROM Job j WHERE j.isEnable = true ORDER BY j.id DESC")
    List<Job> findAllEnable();
}
