package com.task.hrms.services.implementation;

import com.task.hrms.model.ReportingOfficer;
import com.task.hrms.repository.ReportingOfficerRepository;
import com.task.hrms.services.ReportingOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingOfficerServiceImple implements ReportingOfficerService {
    @Autowired
    private ReportingOfficerRepository reportingOfficerRepository;
    @Override
    public ReportingOfficer save(ReportingOfficer reportingOfficer) {
        return this.reportingOfficerRepository.save(reportingOfficer);
    }

    @Override
    public ReportingOfficer findById(Long id) {
        return this.reportingOfficerRepository.findById(id).get();
    }

    @Override
    public List<ReportingOfficer> findAll() {
        return this.reportingOfficerRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        ReportingOfficer reportingOfficer = this.reportingOfficerRepository.findById(id).get();
        reportingOfficer.setEnable(false);
        this.reportingOfficerRepository.save(reportingOfficer);
    }

    @Override
    public ReportingOfficer findWithEmployee(Long id) {
        return this.reportingOfficerRepository.findWithEmployee(id);
    }
}
