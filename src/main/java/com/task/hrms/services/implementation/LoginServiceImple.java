package com.task.hrms.services.implementation;



import com.task.hrms.model.Login;
import com.task.hrms.repository.LoginRepo;
import com.task.hrms.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImple implements LoginService {
@Autowired
    private LoginRepo loginRepo;


    @Override
    public Login findByEmployeeCode(String employeeCode) {
        return this.loginRepo.findByEmployeeCode(employeeCode);
    }

    @Override
    public Login save(Login login) {
        return this.loginRepo.save(login);
    }

    @Override
    public Login findById(Long id) {
        return this.loginRepo.findById(id).get();
    }
}
