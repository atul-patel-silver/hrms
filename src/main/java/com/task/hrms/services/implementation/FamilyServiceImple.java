package com.task.hrms.services.implementation;

import com.task.hrms.model.Family;
import com.task.hrms.repository.FamilyRepository;
import com.task.hrms.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FamilyServiceImple implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;
    @Override
    public Family save(Family family) {
        return this.familyRepository.save(family);
    }

    @Override
    public Family findById(Long id) {
        return this.familyRepository.findById(id).get();
    }

    @Override
    public List<Family> findAll() {
        return this.familyRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Family family = this.familyRepository.findById(id).get();
        family.setEnable(false);
        this.familyRepository.save(family);

    }

    @Override
    public List<Family> findByEmployeeId(Long id) {
        return this.familyRepository.findFamilyWithEmpId(id);
    }
}
