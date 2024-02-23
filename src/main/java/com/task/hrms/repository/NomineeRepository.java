package com.task.hrms.repository;

import com.task.hrms.model.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NomineeRepository extends JpaRepository<Nominee,Long> {
        @Query("SELECT n FROM Nominee n WHERE n.isEnable = true ORDER BY n.id DESC")
        List<Nominee> findAllEnable();
}
