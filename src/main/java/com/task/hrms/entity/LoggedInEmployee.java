package com.task.hrms.entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Scope(value = "singleton")
public class LoggedInEmployee {
    private final Set<String> employees = new HashSet<>();

    public Set<String> getEmployees() {
        return employees;
    }

    public void addEmployee(String username) {
        employees.add(username);
    }

    public void removeEmployee(String username) {
        employees.remove(username);
    }
}
