package com.task.hrms.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Principal;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(this.userDetailsService);
        authenticationProvider.setPasswordEncoder(this.passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").
                        hasRole("ADMIN").requestMatchers("/employee/**")
                        .hasRole("EMPLOYEE")
                        .requestMatchers("/**").permitAll().anyRequest().authenticated()).formLogin(form -> {
                    form.loginPage("/login").loginProcessingUrl("/doLogin").successHandler(this.customAuthenticationSuccessHandler);
                }).logout(log -> log.logoutSuccessHandler(this.customLogoutSuccessHandler));

        return httpSecurity.build();
    }
}
