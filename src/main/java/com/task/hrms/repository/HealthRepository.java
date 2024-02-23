package com.task.hrms.repository;

import com.task.hrms.model.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthRepository extends JpaRepository<Health,Long> {
        @Query("SELECT h FROM Health h WHERE h.isEnable = true ORDER BY h.id DESC")
        List<Health> findAllEnable();
}
