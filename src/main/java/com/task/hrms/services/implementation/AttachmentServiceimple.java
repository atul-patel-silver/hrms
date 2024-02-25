package com.task.hrms.services.implementation;

import com.task.hrms.model.Attachment;
import com.task.hrms.repository.AttachmentRepository;
import com.task.hrms.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceimple implements AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;
    @Override
    public Attachment save(Attachment attachment) {
        return this.attachmentRepository.save(attachment);
    }

    @Override
    public Attachment findById(Long id) {
        return this.attachmentRepository.findById(id).get();
    }

    @Override
    public List<Attachment> findAll() {
        return this.attachmentRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Attachment attachment = this.attachmentRepository.findById(id).get();
        attachment.setEnable(false);
        this.attachmentRepository.save(attachment);
    }
}
