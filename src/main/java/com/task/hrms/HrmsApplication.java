package com.task.hrms;

import com.task.hrms.model.Login;
import com.task.hrms.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HrmsApplication implements CommandLineRunner {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginService loginService;

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Login isPresent = this.loginService.findByEmployeeCode("STTL_SU");
		if(isPresent == null) {
			Login login = Login.builder().employeeCode("STTL_SU")
					.password(this.passwordEncoder.encode("admin@123"))
					.role("ROLE_ADMIN")
					.isEnable(false).build();

			this.loginService.save(login);
		}
		else {

		}
	}
}
