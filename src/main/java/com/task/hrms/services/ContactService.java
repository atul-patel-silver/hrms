package com.task.hrms.services;

import com.task.hrms.model.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    Contact findById(Long id);

    List<Contact> findAll();

    void delete(Long id);
}
