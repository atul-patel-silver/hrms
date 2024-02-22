package com.task.hrms.controller;

import com.task.hrms.model.Department;
import com.task.hrms.model.Designation;
import com.task.hrms.model.Employee;
import com.task.hrms.model.Login;
import com.task.hrms.services.DepartmentService;
import com.task.hrms.services.DesignationService;
import com.task.hrms.services.EmployeeService;
import com.task.hrms.services.LoginService;
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
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/addEmployee")
    public String addEmployeePage(Model model) {
        List<Designation> designations = this.designationService.findAllEnable();
        model.addAttribute("designations",designations);
        List<Department> departments = this.departmentService.findAllEnable();
        model.addAttribute("departments",departments);

        return "admin/add-employee";
    }
    
    //department page

    @GetMapping("/manage-department")
    public String departmentPage(Model model){
        try {
            List<Department> departments = this.departmentService.findAllEnable();
            model.addAttribute("departments",departments);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "admin/manage-department";
    }


    @PostMapping("/handleDepartMentData")
    @ResponseBody
    public ResponseEntity<String> addDepartment(@RequestParam("departmentName") String departmentName,
                                                @RequestParam("description") String description) {
        try{
            Department department = Department.builder().departmentName(departmentName).description(description).isEnable(true).build();
            this.departmentService.save(department);
            return ResponseEntity.ok("success");
        }
        catch (Exception e){
             e.printStackTrace();
            return ResponseEntity.ok("error"+e.getMessage());
        }

    }

    @PostMapping("/delete-department")
    @ResponseBody
    public String deleteDepartMent(@RequestParam("department_id")Long id){
        try{
            this.departmentService.delete(id);
            return "success";
        }
        catch (Exception e){
            e.printStackTrace();
            return "error "+e.getMessage();
        }
    }



    //manage designation

    @GetMapping("/manage-designation")
    public String designationPage(Model model){
        try {
            List<Designation> designations = this.designationService.findAllEnable();
            model.addAttribute("designations",designations);
        }
        catch (Exception e){
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



    @PostMapping("/saveEmployee")
    @ResponseBody
    public ResponseEntity<?> saveEmployee(@RequestParam("code2") String code2,
                               @RequestParam("panNumber") String panNumber,
                               @RequestParam("oldEmployeeCode") String oldEmployeeCode,
                               @RequestParam("dateOfAppoinment") String dateOfAppointment,
                               @RequestParam("bioMetricId") String bioMetricId,
                               @RequestParam("salutation") String salutation,
                               @RequestParam("departmentId") String departmentId,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("middleName") String middleName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("unit") String unit,
                               @RequestParam("designationId") String designationId,
                               @RequestParam(defaultValue = "false") boolean isGazetted,
                               @RequestParam("employeeEligibleFor") String employeeEligibleFor,
                               @RequestParam(defaultValue = "false") boolean isUnderGratuityAct) {

        try{

            Designation designation = this.designationService.findById(Long.valueOf(designationId));
            Department department = this.departmentService.findById(Long.valueOf(departmentId));
            Login login = Login.builder().role("ROLE_EMPLOYEE").employeeCode("STTP_" + code2.trim()).isEnable(false).build();
            Login save = this.loginService.save(login);
            Employee build = Employee.builder().panNumber(panNumber)
                    .oldEmployeeCode(oldEmployeeCode)
                    .dateOfAppoinment(LocalDate.parse(dateOfAppointment))
                    .bioMetricId(bioMetricId)
                    .salutation(salutation)
                    .department(department)
                    .firstName(firstName)
                    .middleName(middleName)
                    .lastName(lastName)
                    .unit(unit)
                    .designation(designation)
                    .isGazetted(isGazetted)
                    .employeeEligibleFor(employeeEligibleFor)
                    .isUnderGratuityAct(isUnderGratuityAct)
                    .login(save)
                    .isEnable(true).build();
            Employee save1 = this.employeeService.save(build);
            Map<String,String> data=new HashMap<>();
            data.put("isSuccess","success");
            data.put("id", String.valueOf(save1.getId()));
            return ResponseEntity.ok(data);

        }
        catch (Exception e){
            e.printStackTrace();
            Map<String,String> data=new HashMap<>();
            data.put("isSuccess","error");
            data.put("id","0");
            return ResponseEntity.ok(data);

        }
    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployeePage(@PathVariable("id")Long id,Model model){


        try{
            Employee employee = this.employeeService.findById(id);
            model.addAttribute("employee",employee);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "admin/edit-employee";
    }
}
