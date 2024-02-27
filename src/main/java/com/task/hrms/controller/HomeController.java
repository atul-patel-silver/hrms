package com.task.hrms.controller;

import com.task.hrms.services.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";

    }


}
