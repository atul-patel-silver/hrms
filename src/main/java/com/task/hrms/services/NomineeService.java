package com.task.hrms.services;

import com.task.hrms.model.Nominee;

import java.util.List;

public interface NomineeService {

    Nominee save(Nominee nominee);

    Nominee findById(Long id);

    List<Nominee> findAll();

    void delete(Long id);
}
