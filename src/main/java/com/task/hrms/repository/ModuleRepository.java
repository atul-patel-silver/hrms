package com.task.hrms.repository;

import com.task.hrms.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Long> {

    @Query("select m from Module m where m.isEnable = true ORDER BY m.id DESC")
    List<Module> findAllEnable();
}
