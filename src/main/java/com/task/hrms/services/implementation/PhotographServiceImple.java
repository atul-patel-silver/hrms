package com.task.hrms.services.implementation;

import com.task.hrms.model.Photograph;
import com.task.hrms.repository.PhotographRepository;
import com.task.hrms.services.PhotographService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotographServiceImple implements PhotographService {
    @Autowired
    private PhotographRepository photographRepository;
    @Override
    public Photograph save(Photograph photograph) {
        return this.photographRepository.save(photograph);
    }

    @Override
    public Photograph findById(Long id) {
        return this.photographRepository.findById(id).get();
    }

    @Override
    public List<Photograph> findAll() {
        return this.photographRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Photograph photograph = this.photographRepository.findById(id).get();
        photograph.setEnable(false);
        this.photographRepository.save(photograph);

    }
}
