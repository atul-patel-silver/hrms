package com.task.hrms.services.implementation;

import com.task.hrms.model.Personal;
import com.task.hrms.repository.PersonalRepository;
import com.task.hrms.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonalServiceImple implements PersonalService {
    @Autowired
    private PersonalRepository personalRepository;
    @Override
    public Personal save(Personal personal) {
        return this.personalRepository.save(personal);
    }

    @Override
    public Personal findById(Long id) {
        return this.personalRepository.findById(id).get();
    }

    @Override
    public List<Personal> findAll() {
        return this.personalRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Personal personal = this.personalRepository.findById(id).get();
        personal.setEnable(false);
        this.personalRepository.save(personal);
    }
}
