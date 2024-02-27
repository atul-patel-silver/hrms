package com.task.hrms.controller;

import com.task.hrms.model.*;
import com.task.hrms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DesignationService designationService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PersonalService personalService;
    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private FamilyService familyService;
    @Autowired
    private PhotographService photographService;
    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private EmergencyService emergencyService;
    @Autowired
    private JobService jobService;

    @Autowired
    private HealthService healthService;

    @Autowired
    private NomineeService nomineeService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ReportingOfficerService reportingOfficerService;
    @Autowired
    private PreviousEmploymentService previousEmploymentService;

    @Autowired
    private QualificationService qualificationService;
    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal){
        try{
            Login login = this.loginService.findByEmployeeCode(principal.getName());
            Employee employee = login.getEmployee();
            Long id=employee.getId();

            model.addAttribute("employee",employee);
            List<Address> addresses = this.addressService.findByEmployeeId(id);
            model.addAttribute("addresses", addresses);

            List<Nominee> nominees = this.nomineeService.findNomineeForEmployee(id);
            model.addAttribute("nominees", nominees);

            List<Emergency> emergencies = this.emergencyService.findEmergenciesByEmployeeId(id);
            model.addAttribute("emergencies", emergencies);

            List<Attachment> attachments = this.attachmentService.findByEmployeeId(id);
            model.addAttribute("attachments", attachments);
            ReportingOfficer reportingOfficer = this.reportingOfficerService.findWithEmployee(id);
            model.addAttribute("reportingOfficer", reportingOfficer);


            List<Family> families = this.familyService.findByEmployeeId(id);
            model.addAttribute("families", families);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "employee/dashboard";
    }
}
