package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_emergancy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emergency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String priority;
    private String firstName;
    private String middleName;
    private String lastName;
    private String relation;
    private Long phoneNo;
    private Long mobileNo;
    private String email;
    private String address;
    private boolean isEnable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "emp_id")
    private Employee employee;
}
