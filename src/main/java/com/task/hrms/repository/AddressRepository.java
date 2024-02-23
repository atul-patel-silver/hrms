package com.task.hrms.repository;

import com.task.hrms.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
        @Query("SELECT a FROM Address a WHERE a.isEnable = true ORDER BY a.id DESC")
        List<Address> findAllEnable();
        @Query("select a from Address a where a.isEnable = true AND a.employee.id =:empId ORDER BY a.id DESC")
        List<Address> findByEmployeeId(@Param("empId") Long empid);
}
