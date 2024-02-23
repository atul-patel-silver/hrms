package com.task.hrms.services.implementation;

import com.task.hrms.model.Contact;
import com.task.hrms.repository.ContactRepository;
import com.task.hrms.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImple implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Contact save(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact findById(Long id) {
        return this.contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> findAll() {
        return this.contactRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Contact contact = this.contactRepository.findById(id).get();
        contact.setEnable(false);
        this.contactRepository.save(contact);

    }
}
