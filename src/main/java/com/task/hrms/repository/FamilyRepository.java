package com.task.hrms.repository;

import com.task.hrms.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family,Long> {

        @Query("SELECT f FROM Family f WHERE f.isEnable = true ORDER BY f.id DESC")
        List<Family> findAllEnable();
}
