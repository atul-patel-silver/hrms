package com.task.hrms.services;

import com.task.hrms.model.Family;

import java.util.List;

public interface FamilyService {
    Family save(Family family);

    Family findById(Long id);

    List<Family> findAll();

    void delete(Long id);

    List<Family> findByEmployeeId(Long id);

}
