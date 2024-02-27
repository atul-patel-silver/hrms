package com.task.hrms.services.implementation;

import com.task.hrms.model.Emergency;
import com.task.hrms.repository.EmergencyRepository;
import com.task.hrms.repository.EmployeeRepository;
import com.task.hrms.services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergancyServiceImple implements EmergencyService {
    @Autowired
    private EmergencyRepository emergencyRepository;
    @Override
    public Emergency save(Emergency emergency) {
        return this.emergencyRepository.save(emergency);
    }

    @Override
    public Emergency findById(Long id) {
        return this.emergencyRepository.findById(id).get();
    }

    @Override
    public List<Emergency> findAll() {
        return this.emergencyRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Emergency emergency = this.emergencyRepository.findById(id).get();
        emergency.setEnable(false);
        this.emergencyRepository.save(emergency);
    }

    @Override
    public List<Emergency> findEmergenciesByEmployeeId(Long id) {
        return this.emergencyRepository.findEmergenciesByEmployeeId(id);
    }
}
