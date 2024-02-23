package com.task.hrms.repository;

import com.task.hrms.model.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmergencyRepository extends JpaRepository<Emergency,Long> {
        @Query("SELECT e FROM Emergency e WHERE e.isEnable = true ORDER BY e.id DESC")
        List<Emergency> findAllEnable();
}
