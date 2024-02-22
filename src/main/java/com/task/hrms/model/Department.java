package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmentName;


    @Column(length = 2000)
    private String description;

    private boolean isEnable;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private List<Employee> employees;


}
