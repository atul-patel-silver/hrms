package com.task.hrms.repository;

import com.task.hrms.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family,Long> {

        @Query("SELECT f FROM Family f WHERE f.isEnable = true ORDER BY f.id DESC")
        List<Family> findAllEnable();
        @Query("SELECT f FROM Family f WHERE f.isEnable = true AND f.employee.id =:id ORDER BY f.id DESC")
        List<Family> findFamilyWithEmpId(@Param("id") Long empId);
}
