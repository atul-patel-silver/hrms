package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "tbl_emp_personal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;
    private String gender;
    private String  marriageStatus;
    private String dateOfBirth;
    private String dateOfMarriage;
    private String birthPlace;
    private String communityCategory;
    private long uidNo;
    private long gpfAcNo;
    private String religion;
    private String caste;
    private String communityCategoryRef;
    private String nationality;
    private long postelLifeInsuranceNo;
    private String hobbies;
    private String bankName;
    private String bankBranch;
    private long bankAcNo;
    private String ifscCode;
    private long bsrCode;
    private long passportNo;
    private String dateOfExpiry;
    private String visaDetail;
    private long drivingLicenceNo;
    private String vehicleType;
    private String validUpto;
    private String issuedState;
    private String detailOfVehicleProvider;
    private boolean isGovernmentVehicleProvider;
    private boolean isUsedForOnDuty;
    private boolean isResidentOfOtherCountry;
    private boolean isDisciplinaryProceeding;
    private String addtionalInfo;
    private String migrationDateOfIndia;

    private String country;


    @Column(length = 2000)
    private String otherCountryAddress;

    private boolean isEnable;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;

}
