package com.task.hrms.configration;
import com.task.hrms.entity.LoggedInEmployee;
import com.task.hrms.model.Login;
import com.task.hrms.services.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private LoggedInEmployee loggedInEmployee;

    @Autowired
    private LoginService loginService;


    private Logger logger= LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        this.logger.info("LOGIN CUSTOMER:--"+username);
        Login login=this.loginService.findByEmployeeCode(username);
        login.setEnable(true);
        this.loginService.save(login);
        this.loggedInEmployee.addEmployee(username);

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (auth.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin/dashboard");
                return;
            } else if (auth.getAuthority().equals("ROLE_EMPLOYEE")) {
                response.sendRedirect("/employee/dashboard");
                return;
            }
        }
    }

}

