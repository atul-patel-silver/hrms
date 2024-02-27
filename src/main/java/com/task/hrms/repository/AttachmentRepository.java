package com.task.hrms.repository;

import com.task.hrms.model.Attachment;
import com.task.hrms.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {

    @Query("SELECT a FROM Attachment a WHERE a.isEnable = true ORDER BY a.id DESC")
    List<Attachment> findAllEnable();
    @Query("SELECT a FROM Attachment a WHERE a.isEnable = true and a.employee.id =:id ORDER BY a.id DESC")
    List<Attachment> findByEmployeeId(@Param("id")Long id);
}
