package com.task.hrms.services;

import com.task.hrms.model.Department;
import com.task.hrms.model.Designation;
import lombok.extern.java.Log;

import java.util.List;

public interface DesignationService {
    List<Designation> findAllEnable();
    Designation save(Designation designation);

    Designation findById(Long id);

    void delete(Long id);
}
