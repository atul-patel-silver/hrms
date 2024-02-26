package com.task.hrms.services.implementation;

import com.task.hrms.model.Nominee;
import com.task.hrms.repository.NomineeRepository;
import com.task.hrms.services.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomineeServiceImple implements NomineeService {

    @Autowired
    private NomineeRepository nomineeRepository;

    @Override
    public Nominee save(Nominee nominee) {
        return this.nomineeRepository.save(nominee);
    }

    @Override
    public Nominee findById(Long id) {
        return this.nomineeRepository.findById(id).get();
    }

    @Override
    public List<Nominee> findAll() {
        return this.nomineeRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Nominee nominee = this.nomineeRepository.findById(id).get();
        nominee.setEnable(false);
        this.nomineeRepository.save(nominee);
    }

    @Override
    public List<Nominee> findNomineeForEmployee(Long id) {
        return this
                .nomineeRepository.findNomineeForEmployee(id);
    }
}
