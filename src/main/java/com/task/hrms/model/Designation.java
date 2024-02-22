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
@Table(name = "tbl_designation")
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designationTitle;

    @Column(length = 2000)
    private String description;

    private boolean isEnable;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "designation")
    private List<Employee> employees;

}
