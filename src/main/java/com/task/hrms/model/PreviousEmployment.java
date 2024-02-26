package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_previous_employment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreviousEmployment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String companyName;
    private String serviceType;
    private String position;
    private Long ctc;
    @Column(length = 2000)
    private String reponsibilities;
    @Column(length = 2000)
    private String reasonOfSeperation;
    private String hrContactPerson;
    private Long phoneNo;
    private Long mobileNo;
    private String email;
    private String website;
    @Column(length = 2000)
    private String address;
    @Column(length = 2000)
    private String remark;
    private boolean isEnable;
    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
