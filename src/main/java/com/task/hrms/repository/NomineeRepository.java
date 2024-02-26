package com.task.hrms.repository;

import com.task.hrms.model.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NomineeRepository extends JpaRepository<Nominee,Long> {
        @Query("SELECT n FROM Nominee n WHERE n.isEnable = true ORDER BY n.id DESC")
        List<Nominee> findAllEnable();

        @Query("SELECT n FROM Nominee n WHERE n.isEnable = true And n.employee.id =:id ORDER BY n.id DESC")
        List<Nominee> findNomineeForEmployee(@Param("id") Long id);
}
