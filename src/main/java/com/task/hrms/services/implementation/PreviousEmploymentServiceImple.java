package com.task.hrms.services.implementation;

import com.task.hrms.model.PreviousEmployment;
import com.task.hrms.repository.PreviousEmploymentRepository;
import com.task.hrms.services.PreviousEmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreviousEmploymentServiceImple implements PreviousEmploymentService {
    @Autowired
    private PreviousEmploymentRepository previousEmploymentRepository;
    @Override
    public PreviousEmployment save(PreviousEmployment previousEmployment) {
        return this.previousEmploymentRepository.save(previousEmployment);
    }

    @Override
    public PreviousEmployment findById(Long id) {
        return this.previousEmploymentRepository.findById(id).get();
    }

    @Override
    public List<PreviousEmployment> findAll() {
        return this.previousEmploymentRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        PreviousEmployment previousEmployment = this.previousEmploymentRepository.findById(id).get();

        previousEmployment.setEnable(false);
        this.previousEmploymentRepository.save(previousEmployment);
    }
}
