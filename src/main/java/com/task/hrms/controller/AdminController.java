package com.task.hrms.controller;

import com.task.hrms.helper.FileHelper;
import com.task.hrms.model.*;
import com.task.hrms.payload.EmployeeJob;
import com.task.hrms.services.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
    private ExcelService excelService;

    @Autowired
    private QualificationService qualificationService;

    //dashboard
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }
//download Excel file

    @GetMapping("/get-excel-file")
    public ResponseEntity<byte[]> complainExcelFile() throws Exception{

        Workbook workbook = excelService.createExcel();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment","employee_fill_up.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(outputStream.toByteArray());
    }


    //upload excel file

    @PostMapping("/upload-excel")
    @ResponseBody
    public String handleFileUpload(@RequestParam("excel-file-data") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try{
            if (file.isEmpty()) {
                return "Please select a file to upload.";
            }

            else if(!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
                return "Please upload an Excel file.";
            }
            else {
                boolean b = FileHelper.uploadFile("/static/excel-file", file);
                if(b){
                    return "success";
                }
                else {
                    return "Something Went Wrong Tray Again !!";
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";
        }


    }
    //show all employee
    @GetMapping("/employeeList")
    public String showAllEmployee(Model model) {
        List<Employee> employees = this.employeeService.findAllEnable();
        model.addAttribute("employees", employees);
        return "admin/showAllEmployee";
    }


    //add employee page
    @GetMapping("/addEmployee")
    public String addEmployeePage(Model model) {
        List<Designation> designations = this.designationService.findAllEnable();
        model.addAttribute("designations", designations);
        List<Department> departments = this.departmentService.findAllEnable();
        model.addAttribute("departments", departments);

        return "admin/add-employee";
    }


    @GetMapping("/viewEmployee/{id}")
    public String viewEmployeeDetail(@PathVariable("id")Long id,Model model){
        try{
            Employee employee = this.employeeService.findById(id);
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

        return "admin/employee-detail";
    }

    //department page
    @GetMapping("/manage-department")
    public String departmentPage(Model model) {
        try {
            List<Department> departments = this.departmentService.findAllEnable();
            model.addAttribute("departments", departments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/manage-department";
    }


    //handle department data
    @PostMapping("/handleDepartMentData")
    @ResponseBody
    public ResponseEntity<String> addDepartment(@RequestParam("departmentName") String departmentName,
                                                @RequestParam("description") String description) {
        try {
            Department department = Department.builder().departmentName(departmentName).description(description).isEnable(true).build();
            this.departmentService.save(department);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("error" + e.getMessage());
        }

    }


    //delete department
    @PostMapping("/delete-department")
    @ResponseBody
    public String deleteDepartMent(@RequestParam("department_id") Long id) {
        try {
            this.departmentService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error " + e.getMessage();
        }
    }


    //manage designation
    @GetMapping("/manage-designation")
    public String designationPage(Model model) {
        try {
            List<Designation> designations = this.designationService.findAllEnable();
            model.addAttribute("designations", designations);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/manage-designation";
    }


    //handle designation data
    @PostMapping("/handleDesignationData")
    @ResponseBody
    public ResponseEntity<String> addDesignation(@RequestParam("designationTitle") String designationTitle,
                                                 @RequestParam("description") String description) {
        try {
            Designation designation = Designation.builder()
                    .designationTitle(designationTitle)
                    .description(description)
                    .isEnable(true)
                    .build();
            this.designationService.save(designation);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("error" + e.getMessage());
        }
    }


    //delete designation
    @PostMapping("/delete-designation")
    @ResponseBody
    public String deleteDesignation(@RequestParam("designation_id") Long id) {
        try {
            this.designationService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error " + e.getMessage();
        }
    }


    //conatct from data
    @PostMapping("/employeeContactFromData/{Id}")
    @ResponseBody
    public String contactFromDataHandle(@RequestBody Contact contact, @PathVariable("Id") Long employeeId) {
        try {
            Employee employee = this.employeeService.findById(employeeId);
            contact.setEnable(true);
            contact.setEmployee(employee);
            this.contactService.save(contact);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //family from data
    @PostMapping("/employeeFamilyFromData/{Id}")
    @ResponseBody
    public String familyFromDataHandle(@RequestBody Family family, @PathVariable("Id") Long employeeId) {
        try {
            Employee employee = this.employeeService.findById(employeeId);
            family.setEmployee(employee);
            family.setEnable(true);
            this.familyService.save(family);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //delete family
    @PostMapping("/delete-family")
    @ResponseBody
    public String deleteFamilyMember(@RequestParam("family_id") Long id) {
        try {
            this.familyService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error " + e.getMessage();
        }
    }


    //add employee address
    @PostMapping("/employeeAddressFromData/{Id}")
    @ResponseBody
    public String employeeAddressFromData(@RequestBody Address address, @PathVariable("Id") Long employeeId) {
        try {
            Employee employee = this.employeeService.findById(employeeId);
            address.setEnable(true);
            address.setEmployee(employee);
            this.addressService.save(address);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //delete employee address
    @PostMapping("/delete-address")
    @ResponseBody
    public String deleteAddress(@RequestParam("address_id") Long id) {
        try {
            this.addressService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error " + e.getMessage();
        }
    }


    //add emergancy data
    @PostMapping("/employeeFromEmergancyData/{Id}")
    @ResponseBody
    public String employeeEmergancyFromData(@RequestBody Emergency emergency, @PathVariable("Id") Long employeeId) {
        try {
            Employee employee = this.employeeService.findById(employeeId);
            emergency.setEnable(true);
            emergency.setEmployee(employee);
            this.emergencyService.save(emergency);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //health data
    @PostMapping("/employeeFromHealthData/{Id}")
    @ResponseBody
    public String employeeHealthFromData(@RequestBody Health health, @PathVariable("Id") Long employeeId) {
        try {
            Employee employee = this.employeeService.findById(employeeId);
            health.setEnable(true);
            health.setEmployee(employee);
            this.healthService.save(health);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //handle Employee Photograph
    @PostMapping("/handleEmployeePhotograph")
    @ResponseBody
    public String handleFormSubmission(@RequestParam("employeeId") String employeeId,
                                       @RequestParam("image") MultipartFile image,
                                       @RequestParam("sign") MultipartFile sign) {

        try {
            Employee employee = this.employeeService.findById(Long.valueOf(employeeId));

            boolean b = FileHelper.uploadFile("static/image/profile", image);
            boolean b1 = FileHelper.uploadFile("static/image/sign", sign);

            if (b && b1) {
                Photograph photograph = Photograph.builder().image(image.getOriginalFilename()).sign(sign.getOriginalFilename()).isEnable(true).employee(employee).build();
                this.photographService.save(photograph);
            } else {
                return "Photo Not Saved";
            }
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }


    //handle document data
    @PostMapping("/saveEmployeeDocument")
    @ResponseBody
    public String handleFormSubmission(
            @RequestParam("employeeId") String employeeId,
            @RequestParam("documentType") String documentType,
            @RequestParam("titleOfDocument") String titleOfDocument,
            @RequestParam("description") String description,
            @RequestParam("documentImage") MultipartFile documentImage) {


        try {
            Employee employee = this.employeeService.findById(Long.valueOf(employeeId));

            if (FileHelper.uploadFile("static/image/attachment", documentImage)) {
                Attachment attachment = Attachment.builder().documentType(documentType)
                        .titleOfDocument(titleOfDocument)
                        .description(description)
                        .employee(employee)
                        .documentImage(documentImage.getOriginalFilename()).isEnable(true).build();
                this.attachmentService.save(attachment);
            } else {
                return "Document is Not Upload";
            }

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }


    }


    //handle employee first page data
    @PostMapping("/saveEmployee")
    @ResponseBody
    public ResponseEntity<?> saveEmployee(@RequestParam("code2") String code2, @RequestParam("panNumber") String panNumber, @RequestParam("oldEmployeeCode") String oldEmployeeCode, @RequestParam("dateOfAppoinment") String dateOfAppointment, @RequestParam("bioMetricId") String bioMetricId, @RequestParam("salutation") String salutation, @RequestParam("departmentId") String departmentId, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("unit") String unit, @RequestParam("designationId") String designationId, @RequestParam(defaultValue = "false") boolean isGazetted, @RequestParam("employeeEligibleFor") String employeeEligibleFor, @RequestParam(defaultValue = "false") boolean isUnderGratuityAct) {

        try {
            if (this.loginService.findByEmployeeCode("STTP_" + code2.trim()) == null) {
                Designation designation = this.designationService.findById(Long.valueOf(designationId));
                Department department = this.departmentService.findById(Long.valueOf(departmentId));
                Login login = Login.builder().role("ROLE_EMPLOYEE").employeeCode("STTL_" + code2.trim()).isEnable(false).build();


                Login save = this.loginService.save(login);
                Login save2 = this.loginService.findById(save.getId());
                login.setPassword(this.passwordEncoder.encode(login.getEmployeeCode()+"@123"));
                Login save3 = this.loginService.save(save2);
                Employee build = Employee.builder().panNumber(panNumber).oldEmployeeCode(oldEmployeeCode).dateOfAppoinment(LocalDate.parse(dateOfAppointment)).bioMetricId(bioMetricId).salutation(salutation).department(department).firstName(firstName).middleName(middleName).lastName(lastName).unit(unit).designation(designation).isGazetted(isGazetted).employeeEligibleFor(employeeEligibleFor).isUnderGratuityAct(isUnderGratuityAct).login(save3).isEnable(true).build();
                Employee save1 = this.employeeService.save(build);
                Map<String, String> data = new HashMap<>();
                data.put("isSuccess", "success");
                data.put("id", String.valueOf(save1.getId()));
                return ResponseEntity.ok(data);
            } else {
                Map<String, String> data = new HashMap<>();
                data.put("isSuccess", "error");
                data.put("msg", "Already Present Employee in This Employee Code!!");
                return ResponseEntity.ok(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> data = new HashMap<>();
            data.put("isSuccess", "error");
            data.put("id", "0");
            return ResponseEntity.ok(data);

        }
    }


    //Nominee  data add in database
    @PostMapping("/saveEmployeeNominee/{Id}")
    @ResponseBody
    public String saveEmployeeNominee(@RequestBody Nominee nominee, @PathVariable("Id") Long employeeId) {
        try {
            Employee employee = this.employeeService.findById(employeeId);
            nominee.setEnable(true);
            nominee.setEmployee(employee);
            nominee.setNomineeInvalidCondition(nominee.getNomineeInvalidCondition().trim());
            this.nomineeService.save(nominee);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

//delete nominee data

    @PostMapping("/delete-nominee")
    @ResponseBody
    public String deleteNominee(@RequestParam("nominee_id") Long nominee_id) {
        try {

            this.nomineeService.delete(nominee_id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //edit employee page
    @GetMapping("/editEmployee/{id}")
    public String editEmployeePage(@PathVariable("id") Long id, Model model) {


        try {
            Employee employee = this.employeeService.findById(id);
            model.addAttribute("employee", employee);

            List<Address> addresses = this.addressService.findByEmployeeId(id);
            model.addAttribute("addresses", addresses);
            List<Designation> designations = this.designationService.findAllEnable();
            model.addAttribute("designations", designations);
            List<Department> departments = this.departmentService.findAllEnable();
            model.addAttribute("departments", departments);
            List<Attachment> attachments = this.attachmentService.findByEmployeeId(id);
            model.addAttribute("attachments", attachments);
            List<Nominee> nominees = this.nomineeService.findNomineeForEmployee(id);
            model.addAttribute("nominees", nominees);

            ReportingOfficer reportingOfficer = this.reportingOfficerService.findWithEmployee(id);
            model.addAttribute("reportingOfficer", reportingOfficer);


            List<Family> families = this.familyService.findByEmployeeId(id);
            model.addAttribute("families", families);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/edit-employee";
    }


    //employee personal data
    @PostMapping("/employee-personalData")
    @ResponseBody
    public String handlePersonalData(@RequestParam("gender") String gender, @RequestParam("marriageStatus") String marriageStatus, @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("dateOfMarriage") String dateOfMarriage, @RequestParam("birthPlace") String birthPlace, @RequestParam("communityCategory") String communityCategory, @RequestParam("uidNo") Long uidNo, @RequestParam("gpfAcNo") Long gpfAcNo, @RequestParam("religion") String religion, @RequestParam("caste") String caste, @RequestParam("communityCategoryRef") String communityCategoryRef, @RequestParam("nationality") String nationality, @RequestParam("postelLifeInsuranceNo") Long postelLifeInsuranceNo, @RequestParam("hobbies") String hobbies, @RequestParam("bankName") String bankName, @RequestParam("bankBranch") String bankBranch, @RequestParam("bankAcNo") Long bankAcNo, @RequestParam("ifscCode") Long ifscCode, @RequestParam("bsrCode") Long bsrCode, @RequestParam("passportNo") Long passportNo, @RequestParam("dateOfExpiry") String dateOfExpiry, @RequestParam("visaDetail") String visaDetail, @RequestParam("drivingLicenceNo") Long drivingLicenceNo, @RequestParam("vehicleType") String vehicleType, @RequestParam("validUpto") LocalDate validUpto, @RequestParam("issuedState") String issuedState, @RequestParam("detailOfVehicleProvider") String detailOfVehicleProvider, @RequestParam("employeeId") String employeeId, @RequestParam(defaultValue = "false") boolean isGovernmentVehicleProvider, @RequestParam(defaultValue = "false") boolean isUsedForOnDuty,
                                     @RequestParam(defaultValue = "false") boolean isResidentOfOtherCountry,
                                     @RequestParam(defaultValue = "false") boolean isDisciplinaryProceeding,
                                     @RequestParam("additionalInfo") String additionalInfo,
                                     @RequestParam("migrationDateOfIndia") String migrationDateOfIndia,
                                     @RequestParam("otherCountryAddress") String otherCountryAddress) {

        try {
            Employee employee = this.employeeService.findById(Long.valueOf(employeeId));
            Personal personal = Personal.builder().gender(gender).marriageStatus(marriageStatus).dateOfBirth(dateOfBirth).dateOfMarriage(dateOfMarriage).birthPlace(birthPlace).communityCategory(communityCategory).uidNo(uidNo).gpfAcNo(gpfAcNo).religion(religion).caste(caste).communityCategoryRef(communityCategoryRef).nationality(nationality).postelLifeInsuranceNo(postelLifeInsuranceNo).hobbies(hobbies).bankName(bankName).bankBranch(bankBranch).bankAcNo(bankAcNo).ifscCode(String.valueOf(ifscCode)).bsrCode(bsrCode).passportNo(passportNo).dateOfExpiry(dateOfExpiry).visaDetail(visaDetail).drivingLicenceNo(drivingLicenceNo).issuedState(issuedState).detailOfVehicleProvider(detailOfVehicleProvider).isGovernmentVehicleProvider(isGovernmentVehicleProvider).isUsedForOnDuty(isUsedForOnDuty).isResidentOfOtherCountry(isResidentOfOtherCountry)
                    .isDisciplinaryProceeding(isDisciplinaryProceeding).country("INDIA").isEnable(true)
                    .vehicleType(vehicleType).validUpto(String.valueOf(validUpto))
                    .addtionalInfo(additionalInfo).migrationDateOfIndia(migrationDateOfIndia).otherCountryAddress(otherCountryAddress).employee(employee).build();
            this.personalService.save(personal);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //add Employee Job Data
    @PostMapping("/employeeJobData")
    @ResponseBody
    public String saveEmployeeJobDetails(@RequestBody EmployeeJob job) {
        try {
            Employee employee = this.employeeService.findById(job.getEmployeeId());
            Job job2 = Job.builder().
                    employee(employee)
                    .EmploymentType(job.getEmploymentType())
                    .EmploymentCategory(job.getEmploymentCategory())
                    .EmploymentSubType(job.getEmploymentSubType())
                    .Status(job.getStatus())
                    .noticePeriod(job.getNoticePeriod())
                    .employeeGrade(job.getEmployeeGrade())
                    .probationDuration(job.getProbationDuration())
                    .probationStartDate(String.valueOf(job.getProbationStartDate()))
                    .dutiesAndResponsibilities(job.getDutiesAndResponsibilities())
                    .InsuranceStartGroup(job.getInsuranceStartGroup())
                    .InsuranceWithEffectiveFrom(job.getInsuranceWithEffectiveFrom())
                    .placeOfPosition(job.getPlaceOfPosition())
                    .branchName(job.getBranchName())
                    .workLocation(job.getWorkLocation())
                    .isEnable(true)
                    .designation(this.designationService.findById(job.getDesignationId()))
                    .dateOfPosting(job.getDateOfPosting())
                    .GroupWhenPosting(job.getGroupWhenPosting())
                    .postOrderNumber(job.getPostOrderNumber())
                    .dateOfPostingOrder(job.getDateOfPostingOrder())
                    .PayConfiguraton(job.getPayConfiguration())
                    .Scale(job.getScale())
                    .scaleValue(job.getScaleValue())
                    .GradePay(job.getGradePay())
                    .RecuritmentCategory(job.getEmploymentCategory())
                    .RecuritmentType(job.getEmploymentType())
                    .Shift(job.getShift())
                    .WeeklyOff(job.getWeeklyOff())
                    .WeeklyOffWitheffectiveFrom(job.getWeeklyOffWithEffectiveFrom()).build();

            this.jobService.save(job2);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //add Employee Report Person
    @PostMapping("/saveReportOfficerForEmployee/{Id}")
    @ResponseBody
    public String saveReportOfficerForEmployee(@RequestBody ReportingOfficer reportingOfficer, @PathVariable("Id") Long empId) {
        try {
            reportingOfficer.setEmployee(this.employeeService.findById(empId));
            reportingOfficer.setEnable(true);
            this.reportingOfficerService.save(reportingOfficer);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //delete Reporting Officer
    @PostMapping("/delete-reporting-officer")
    @ResponseBody
    public String deleteReportingOfficer(@RequestParam("repo_id") Long repo_id) {
        try {
            this.reportingOfficerService.delete(repo_id);
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "success";
        }
    }


    //add old company detail
    @PostMapping("/saveOldCompanyDetail/{id}")
    @ResponseBody
    public String saveOldCompanyDetail(@RequestBody PreviousEmployment previousEmployment, @PathVariable("id") Long id) {
        try {

            previousEmployment.setEmployee(this.employeeService.findById(id));
            previousEmployment.setEnable(true);
            this.previousEmploymentService.save(previousEmployment);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    //add qulificatin Data in dataBase
    @PostMapping("/saveEmployeeQulification/{id}")
    @ResponseBody
    public String saveEmployeeQulification(@RequestBody Qualification qualification, @PathVariable("id") Long id) {
        try {
            qualification.setEnable(true);
            qualification.setEmployee(this.employeeService.findById(id));
            this.qualificationService.save(qualification);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
