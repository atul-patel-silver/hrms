package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long workPhone;
    private String extention;
    private Long workMobile;
    private Long homePhone;
    private Long homeMobile;
    private String corporateEmail;
    private String personalEmail;
    private String secondaryEmail;
    private boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
