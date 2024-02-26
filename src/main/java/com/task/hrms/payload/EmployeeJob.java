package com.task.hrms.payload;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeJob {
    private Long employeeId;
    private String employmentType;
    private String employmentCategory;
    private String employmentSubType;
    private String status;
    private Long noticePeriod;
    private String employeeGrade;
    private String probationDuration;
    private LocalDate probationStartDate;
    private String dutiesAndResponsibilities;
    private String insuranceStartGroup;
    private LocalDate insuranceWithEffectiveFrom;
    private String placeOfPosition;
    private String branchName;
    private String workLocation;

    private Long designationId;
    private LocalDate dateOfPosting;
    private String groupWhenPosting;
    private Long postOrderNumber;
    private LocalDate dateOfPostingOrder;
    private String payConfiguration;
    private String scale;
    private Long scaleValue;
    private String gradePay;
    private String recruitmentCategory;
    private String recruitmentType;
    private String shift;
    private LocalDate weeklyOffWithEffectiveFrom;
    private String weeklyOff;

}
