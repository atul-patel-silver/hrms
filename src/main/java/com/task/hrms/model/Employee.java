package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String panNumber;
    private String oldEmployeeCode;

    private LocalDate dateOfAppoinment;

    private String bioMetricId;

    private String salutation;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    private String unit;

    private String firstName;

    private String middleName;

    private String lastName;

    private String employeeEligibleFor;

    private boolean isGazetted;

    private boolean isUnderGratuityAct;

    private boolean isEnable;


    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "login_id")
    private Login login;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Address>  addresses;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
    private Emergency emergency;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Family> families;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
    private Health health;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Nominee> nominees;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
    private Personal personal;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
    private Photograph photograph;

}
