package com.task.hrms.services;
import com.task.hrms.model.Login;


public interface LoginService {

    Login findByEmployeeCode(String employeeCode);

    Login save(Login login);

    Login findById(Long id);


}
