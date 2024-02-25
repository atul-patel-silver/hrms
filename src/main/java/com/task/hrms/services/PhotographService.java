package com.task.hrms.services;

import com.task.hrms.model.Photograph;

import java.util.List;

public interface PhotographService {
    Photograph save(Photograph photograph);

    Photograph findById(Long id);

    List<Photograph> findAll();

    void delete(Long id);
}
