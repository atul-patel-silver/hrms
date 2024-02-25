package com.task.hrms.repository;

import com.task.hrms.model.Attachment;
import com.task.hrms.model.Photograph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotographRepository extends JpaRepository<Photograph,Long> {

    @Query("SELECT p FROM Photograph p WHERE p.isEnable = true ORDER BY p.id DESC")
    List<Photograph> findAllEnable();


}
