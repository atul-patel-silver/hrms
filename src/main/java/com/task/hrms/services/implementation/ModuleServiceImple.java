package com.task.hrms.services.implementation;

import com.task.hrms.model.Module;
import com.task.hrms.repository.ModuleRepository;
import com.task.hrms.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImple implements ModuleService {
@Autowired
    private ModuleRepository moduleRepository;
    @Override
    public Module save(Module module) {
        return this.moduleRepository.save(module);
    }

    @Override
    public Module findById(Long id) {
        return this.moduleRepository.findById(id).get();
    }

    @Override
    public List<Module> findAll() {
        return this.moduleRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Module module = this.moduleRepository.findById(id).get();
        module.setEnable(false);
        this.moduleRepository.save(module);
    }
}
