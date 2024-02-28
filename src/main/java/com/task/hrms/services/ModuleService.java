package com.task.hrms.services;

import com.task.hrms.model.Module;

import java.util.List;

public interface ModuleService {

    Module save(Module module);

    Module findById(Long id);

    List<Module> findAll();

    void delete(Long id);

  }
