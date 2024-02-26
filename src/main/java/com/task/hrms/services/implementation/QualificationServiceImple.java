package com.task.hrms.services.implementation;

import com.task.hrms.model.Qualification;
import com.task.hrms.repository.QualificationRepository;
import com.task.hrms.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationServiceImple implements QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    @Override
    public Qualification save(Qualification qualification) {
        return this.qualificationRepository.save(qualification);
    }

    @Override
    public Qualification findById(Long id) {
        return this.qualificationRepository.findById(id).get();
    }

    @Override
    public List<Qualification> findAll() {
        return this.qualificationRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Qualification qualification = this.qualificationRepository.findById(id).get();
        qualification.setEnable(false);
        this.qualificationRepository.save(qualification);
    }

    @Override
    public List<Qualification> findQualificationWithEmpId(Long id) {
        return this.qualificationRepository.findQualificationWithEmpId(id);
    }
}
