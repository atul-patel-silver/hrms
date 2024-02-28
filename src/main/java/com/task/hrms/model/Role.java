package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    private String name;
    private String roleDescription;
    private String isActive;
    private String isAdmin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isEnable;

}
