package com.task.hrms.configration;



import com.task.hrms.entity.LoggedInEmployee;
import com.task.hrms.model.Login;
import com.task.hrms.services.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private LoggedInEmployee loggedInEmployee;
    @Autowired
    private LoginService loginService;


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            String username = authentication.getName();
            Login login=this.loginService.findByEmployeeCode(username);
            login.setEnable(false);
            this.loginService.save(login);
            this.loggedInEmployee.removeEmployee(username);
        }
          response.sendRedirect("/login");
    }
}

