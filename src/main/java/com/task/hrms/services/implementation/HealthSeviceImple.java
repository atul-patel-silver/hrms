package com.task.hrms.services.implementation;

import com.task.hrms.model.Health;
import com.task.hrms.repository.HealthRepository;
import com.task.hrms.services.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthSeviceImple implements HealthService {
@Autowired
    private HealthRepository healthRepository;

    @Override
    public Health save(Health health) {
        return this.healthRepository.save(health);
    }

    @Override
    public Health findById(Long id) {
        return this.healthRepository.findById(id).get();
    }

    @Override
    public List<Health> findAll() {
        return this.healthRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Health health = this.healthRepository.findById(id).get();
        health.setEnable(false);
        this.healthRepository.save(health);

    }
}
