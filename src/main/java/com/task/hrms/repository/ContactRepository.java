package com.task.hrms.repository;

import com.task.hrms.model.Contact;
import com.task.hrms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    @Query("SELECT c FROM Contact c WHERE c.isEnable = true ORDER BY c.id DESC")
    List<Contact> findAllEnable();
}
