package com.task.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.task.hrms.model.Login;

public interface LoginRepo extends JpaRepository<Login,Long> {

    @Query("select l from Login l where l.employeeCode =:employeeCode")
    Login findByEmployeeCode(@Param("employeeCode") String employeeCode);
}
