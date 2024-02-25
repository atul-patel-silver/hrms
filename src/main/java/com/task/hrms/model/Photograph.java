package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_photograph")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Photograph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;
    private String sign;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;
    private boolean isEnable;
}
