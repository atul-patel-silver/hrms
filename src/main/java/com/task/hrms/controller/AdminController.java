package com.task.hrms.controller;

import com.task.hrms.model.*;
import com.task.hrms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }
    @GetMapping("/addEmployee")
    public String addEmployeePage(Model model) {
        List<Designation> designations = this.designationService.findAllEnable();
        model.addAttribute("designations", designations);
        List<Department> departments = this.departmentService.findAllEnable();
        model.addAttribute("departments", departments);

        return "admin/add-employee";
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



    //conatct fromdata
    @PostMapping("/employeeContactFromData/{Id}")
    @ResponseBody
    public String contactFromDataHandle(@RequestBody Contact contact,@PathVariable("Id") Long employeeId){
        try{
            Employee employee = this.employeeService.findById(employeeId);
            contact.setEnable(true);
            contact.setEmployee(employee);
            this.contactService.save(contact);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }


    //add address
    @PostMapping("/employeeAddressFromData/{Id}")
    @ResponseBody
    public String employeeAddressFromData(@RequestBody Address address,@PathVariable("Id") Long employeeId){
        try{
            Employee employee = this.employeeService.findById(employeeId);
            address.setEnable(true);
            address.setEmployee(employee);
            this.addressService.save(address);

            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }


    //delete address
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

    @PostMapping("/saveEmployee")
    @ResponseBody
    public ResponseEntity<?> saveEmployee(@RequestParam("code2") String code2, @RequestParam("panNumber") String panNumber, @RequestParam("oldEmployeeCode") String oldEmployeeCode, @RequestParam("dateOfAppoinment") String dateOfAppointment, @RequestParam("bioMetricId") String bioMetricId, @RequestParam("salutation") String salutation, @RequestParam("departmentId") String departmentId, @RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, @RequestParam("unit") String unit, @RequestParam("designationId") String designationId, @RequestParam(defaultValue = "false") boolean isGazetted, @RequestParam("employeeEligibleFor") String employeeEligibleFor, @RequestParam(defaultValue = "false") boolean isUnderGratuityAct) {

        try {

            Designation designation = this.designationService.findById(Long.valueOf(designationId));
            Department department = this.departmentService.findById(Long.valueOf(departmentId));
            Login login = Login.builder().role("ROLE_EMPLOYEE").employeeCode("STTP_" + code2.trim()).isEnable(false).build();
            Login save = this.loginService.save(login);
            Employee build = Employee.builder().panNumber(panNumber).oldEmployeeCode(oldEmployeeCode).dateOfAppoinment(LocalDate.parse(dateOfAppointment)).bioMetricId(bioMetricId).salutation(salutation).department(department).firstName(firstName).middleName(middleName).lastName(lastName).unit(unit).designation(designation).isGazetted(isGazetted).employeeEligibleFor(employeeEligibleFor).isUnderGratuityAct(isUnderGratuityAct).login(save).isEnable(true).build();
            Employee save1 = this.employeeService.save(build);
            Map<String, String> data = new HashMap<>();
            data.put("isSuccess", "success");
            data.put("id", String.valueOf(save1.getId()));
            return ResponseEntity.ok(data);

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> data = new HashMap<>();
            data.put("isSuccess", "error");
            data.put("id", "0");
            return ResponseEntity.ok(data);

        }
    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployeePage(@PathVariable("id") Long id, Model model) {


        try {
            Employee employee = this.employeeService.findById(id);
            model.addAttribute("employee", employee);

            List<Address> addresses = this.addressService.findByEmployeeId(id);
            model.addAttribute("addresses", addresses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin/edit-employee";
    }

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
           Personal personal = Personal.builder().gender(gender).marriageStatus(marriageStatus).dateOfBirth(dateOfBirth).dateOfMarriage(dateOfMarriage).birthPlace(birthPlace).communityCategory(communityCategory).uidNo(uidNo).gpfAcNo(gpfAcNo).religion(religion).caste(caste).communityCategoryRef(communityCategoryRef).nationality(nationality).postelLifeInsuranceNo(postelLifeInsuranceNo).hobbies(hobbies).bankName(bankName).bankBranch(bankBranch).bankAcNo(bankAcNo).ifscCode(ifscCode).bsrCode(bsrCode).passportNo(passportNo).dateOfExpiry(dateOfExpiry).visaDetail(visaDetail).drivingLicenceNo(drivingLicenceNo).issuedState(issuedState).detailOfVehicleProvider(detailOfVehicleProvider).isGovernmentVehicleProvider(isGovernmentVehicleProvider).isUsedForOnDuty(isUsedForOnDuty).isResidentOfOtherCountry(isResidentOfOtherCountry)
                   .isDisciplinaryProceeding(isDisciplinaryProceeding).country("INDIA").isEnable(true)
                   .vehicleType(vehicleType).validUpto(String.valueOf(validUpto))
                   .addtionalInfo(additionalInfo).migrationDateOfIndia(migrationDateOfIndia).otherCountryAddress(otherCountryAddress).employee(employee).build();
                this.personalService.save(personal);
                return "success";
       }
       catch (Exception e){
           e.printStackTrace();
           return "error";
       }
    }
}
