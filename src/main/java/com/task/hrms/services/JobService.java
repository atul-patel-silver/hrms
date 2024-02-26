package com.task.hrms.services;

import com.task.hrms.model.Job;

import java.util.List;

public interface JobService {

    Job save(Job job);

    Job findById(Long id);

    List<Job> findAll();

    void delete(Long id);
}
