package com.task.hrms.services.implementation;

import com.task.hrms.model.Job;
import com.task.hrms.repository.JobRepository;
import com.task.hrms.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImple implements JobService {
@Autowired
    private JobRepository jobRepository;
    @Override
    public Job save(Job job) {
        return this.jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return this.jobRepository.findById(id).get();
    }

    @Override
    public List<Job> findAll() {
        return this.jobRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Job job = this.jobRepository.findById(id).get();
        job.setEnable(false);
        this.jobRepository.save(job);
    }
}
