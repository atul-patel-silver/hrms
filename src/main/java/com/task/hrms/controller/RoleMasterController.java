package com.task.hrms.controller;

import com.task.hrms.model.Module;
import com.task.hrms.model.Role;
import com.task.hrms.model.RoleModuleMapping;
import com.task.hrms.services.ModuleService;
import com.task.hrms.services.RoleModuleMappingService;
import com.task.hrms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RoleMasterController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleModuleMappingService roleModuleMappingService;
    @PostMapping("/add-role")
    @ResponseBody
    public ResponseEntity<String> addRole(@ModelAttribute Role role){
        try{
            role.setEnable(true);
            this.roleService.save(role);
            return ResponseEntity.ok("success");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }
    @GetMapping("/manage-module")
    public String manageModule(Model model){
        try{
            List<Module> modules =  this.moduleService.findAll();
            model.addAttribute("modules",modules);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "admin/manage-module";
    }


    @PostMapping("/add-module-data")
    @ResponseBody
    public ResponseEntity<String> addModule(@ModelAttribute Module module,@RequestParam("parentId")String parentId,@RequestParam("subParentId")String subParentId){
        try{

            Module suParentModule = this.moduleService.findById(Long.valueOf(subParentId));
            Module parentModule = this.moduleService.findById(Long.valueOf(parentId));

            module.setEnable(true);
            module.setParentModule(parentModule);
            module.setSubParentModule(suParentModule);

            this.moduleService.save(module);
            return ResponseEntity.ok("success");

        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }


    @GetMapping("/manage-mapping")
    public String moduleMapping(Model model){

        List<Role> roles = this.roleService.findAll();
        model.addAttribute("roles",roles);
        return "admin/manage-role-mapping";
    }

    @GetMapping("/getModulesForRole")
    @ResponseBody
    public ResponseEntity<?>  selectRole(){
        List<Module> modules = this.moduleService.findAll();
        return ResponseEntity.ok(modules);
    }

    @PostMapping("/addPermission")
    @ResponseBody
    public ResponseEntity<?> addPermission(@RequestParam("moduleId") Long mId,@RequestParam("roleId") Long rId){
        Module module = this.moduleService.findById(mId);
        Role role = this.roleService.findById(rId);
        RoleModuleMapping roleModuleMapping = RoleModuleMapping.builder().add("YES").isEnable(true).role(role).module(module).build();
        this.roleModuleMappingService.save(roleModuleMapping);
        return ResponseEntity.ok("success");
    }


    @PostMapping("/viewPermission")
    @ResponseBody
    public ResponseEntity<?> viewPermission(@RequestParam("moduleId") Long mId,@RequestParam("roleId") Long rId){
        Module module = this.moduleService.findById(mId);
        Role role = this.roleService.findById(rId);
        RoleModuleMapping roleModuleMapping = RoleModuleMapping.builder().view("YES").isEnable(true).role(role).module(module).build();
        this.roleModuleMappingService.save(roleModuleMapping);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/editPermission")
    @ResponseBody
    public ResponseEntity<?> editPermission(@RequestParam("moduleId") Long mId,@RequestParam("roleId") Long rId){
        Module module = this.moduleService.findById(mId);
        Role role = this.roleService.findById(rId);
        RoleModuleMapping roleModuleMapping = RoleModuleMapping.builder().edit("YES").isEnable(true).role(role).module(module).build();
        this.roleModuleMappingService.save(roleModuleMapping);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/deletePermission")
    @ResponseBody
    public ResponseEntity<?> deletePermission(@RequestParam("moduleId") Long mId,@RequestParam("roleId") Long rId){
        Module module = this.moduleService.findById(mId);
        Role role = this.roleService.findById(rId);
        RoleModuleMapping roleModuleMapping = RoleModuleMapping.builder().delete("YES").isEnable(true).role(role).module(module).build();
        this.roleModuleMappingService.save(roleModuleMapping);
        return ResponseEntity.ok("success");
    }


}
