package com.task.hrms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_module")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String controller;
    private String prefix;
    private String plugin;
    private String action;
    private String isActive;
    private boolean isEnable;
    @Column(length = 2000)
    private String menuIconCss;
    @ManyToOne
    @JsonIgnore
    private Module parentModule;
    @ManyToOne
    @JsonIgnore
    private Module subParentModule;

}
