package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "tbl_reporting_officer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportingOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate  startDate;
    private LocalDate endDate;
    private String ddo;
    private String dh;
    private String ho;
    private String hod;
    private LocalDate authDate;
    @Column(length = 2000)
    private String note;
    private boolean isEnable;


    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

}
