package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "tbl_job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String EmploymentType;
    private String EmploymentCategory;
    private String EmploymentSubType;
    private String Status;
    private Long noticePeriod;
    private String employeeGrade;


    private String probationDuration;

    private String  probationStartDate;
    @Column(length = 2000)
    private String dutiesAndResponsibilities;
    private String InsuranceStartGroup;
    private LocalDate InsuranceWithEffectiveFrom;

    private String placeOfPosition;

    private String branchName;

    @Column(length = 2000)
    private String workLocation;
    private boolean isEnable;


    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    private LocalDate dateOfPosting;

    private String GroupWhenPosting;
    private Long postOrderNumber;
    private LocalDate dateOfPostingOrder;
    private String PayConfiguraton;
    private String Scale;
    private Long scaleValue;
    private String GradePay;
    //Radio Button
    private String RecuritmentCategory;
    private String RecuritmentType;
    private String Shift;
    private LocalDate WeeklyOffWitheffectiveFrom;
    private  String WeeklyOff;
    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
