package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "tbl_family")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String relation;
    private LocalDate dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String occupation;
    private String contactDetails;
    private String nationality;
    private boolean isNominee;
    private boolean isDependent;
    private boolean isResidingWith;
    private boolean contactInEmergency;
    private boolean isPhysicallyDisabled;
    private String address;

    private boolean isEnable;
    @ManyToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
}
