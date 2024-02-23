package com.task.hrms.services;

import com.task.hrms.model.Health;

import java.util.List;

public interface HealthService {
    Health save(Health health);

    Health findById(Long id);

    List<Health> findAll();

    void delete(Long id);
}
