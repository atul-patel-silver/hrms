package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_rolemodulemapping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleModuleMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private String add;
    private String view;

    private String edit;

    private String delete;

    private  boolean isEnable;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

}
