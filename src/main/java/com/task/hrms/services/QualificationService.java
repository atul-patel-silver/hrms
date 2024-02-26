package com.task.hrms.services;

import com.task.hrms.model.Qualification;

import java.util.List;

public interface QualificationService {

    Qualification save(Qualification qualification);

    Qualification findById(Long id);

    List<Qualification> findAll();

    void delete(Long id);

    List<Qualification> findQualificationWithEmpId(Long id);
}
