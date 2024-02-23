package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "tbl_nominee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String priority;
    private String firstName;
    private String middleName;
    private String lastName;
    private String relation;
    private String gender;
    private LocalDate dateOfBirth;
    private Long uidNo;
    private Long panNo;
    private Long contactNo;
    private String nomineeInavalidCondition;
    private boolean isEnable;
    @ManyToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
}
