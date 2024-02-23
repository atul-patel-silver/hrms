package com.task.hrms.services;

import com.task.hrms.model.Personal;


import java.util.List;

public interface PersonalService {

    Personal save(Personal personal);

    Personal findById(Long id);

    List<Personal> findAll();

    void delete(Long id);
}
