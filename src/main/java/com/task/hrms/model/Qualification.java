package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_qulification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qualification;
    private String modeOfStudy;
    private String university;
    private String passingMonth;
    private String board;
    private Long passingYear;
    private Long duration;
    private String major;
    private Long percentage;
    private String grade;
    private Long percentile;
    private Long gpaScore;
    @Column(length=2000)
    private String remark;
    @Column(length=2000)
    private String instituteAddress;
    private boolean isEnable;

    @ManyToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
}
