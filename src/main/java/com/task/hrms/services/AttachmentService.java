package com.task.hrms.services;

import com.task.hrms.model.Attachment;

import java.util.List;

public interface AttachmentService {

    Attachment save(Attachment attachment);

    Attachment findById(Long id);

    List<Attachment> findAll();

    void delete(Long id);
}
