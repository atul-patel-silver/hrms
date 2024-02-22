package com.task.hrms.services.implementation;

import com.task.hrms.model.Designation;
import com.task.hrms.repository.DesignationRepository;
import com.task.hrms.services.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DesignationServiceImple implements DesignationService {
    @Autowired
    private DesignationRepository designationRepository;
    @Override
    public List<Designation> findAllEnable() {
        return this.designationRepository.findAllEnable();
    }

    @Override
    public Designation save(Designation designation) {
        return this.designationRepository.save(designation);
    }

    @Override
    public Designation findById(Long id) {
        return this.designationRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Designation designation = this.designationRepository.findById(id).get();
        designation.setEnable(false);
        this.designationRepository.save(designation);
    }
}
