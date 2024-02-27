package com.task.hrms.services;

import com.task.hrms.model.Emergency;

import java.util.List;

public interface EmergencyService {

    Emergency save(Emergency emergency);

    Emergency findById(Long id);

    List<Emergency> findAll();

    void delete(Long id);

    List<Emergency> findEmergenciesByEmployeeId(Long id);
}
