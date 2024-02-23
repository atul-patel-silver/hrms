package com.task.hrms.repository;

import com.task.hrms.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalRepository extends JpaRepository<Personal,Long> {
        @Query("SELECT p FROM Personal p WHERE p.isEnable = true ORDER BY p.id DESC")
        List<Personal> findAllEnable();

}
