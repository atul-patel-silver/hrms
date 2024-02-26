package com.task.hrms.services;

import com.task.hrms.model.ReportingOfficer;

import java.util.List;

public interface ReportingOfficerService {

    ReportingOfficer save(ReportingOfficer reportingOfficer);

    ReportingOfficer findById(Long id);

    List<ReportingOfficer> findAll();

    void delete(Long id);

    ReportingOfficer findWithEmployee(Long id);
}
