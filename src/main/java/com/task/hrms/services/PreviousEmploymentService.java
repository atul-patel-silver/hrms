package com.task.hrms.services;

import com.task.hrms.model.PreviousEmployment;

import java.util.List;

public interface PreviousEmploymentService {
    PreviousEmployment save(PreviousEmployment previousEmployment);

    PreviousEmployment findById(Long id);

    List<PreviousEmployment> findAll();

    void delete(Long id);
}
