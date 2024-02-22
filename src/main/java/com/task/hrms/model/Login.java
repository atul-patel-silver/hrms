package com.task.hrms.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_login")

public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeCode;

    private String password;

    private String role;

    private boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "login")
    private Employee employee;


}
