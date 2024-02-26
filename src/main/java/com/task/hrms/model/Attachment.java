package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_attachment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String documentType;
    private String titleOfDocument;
    private String description;
    private String documentImage;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    private boolean isEnable;
}
