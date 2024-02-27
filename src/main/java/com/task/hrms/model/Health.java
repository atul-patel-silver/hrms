package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_health")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double height;
    private double weight;
    private String bloodGroup;
    private String identificationMark1;
    private String identificationMark2;
    private boolean isHandicapped;
    private boolean isEnable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
