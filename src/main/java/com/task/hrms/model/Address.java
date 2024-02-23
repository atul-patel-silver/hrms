package com.task.hrms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressType;
    private String address;
    private String country;
    private String state;
    private String district;
    private String city;
    private Long pincode;

    private boolean allAddressAreSame;

    private String addressOwner;

    private boolean isEnable;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType='" + addressType + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", allAddressAreSame=" + allAddressAreSame +
                ", addressOwner='" + addressOwner + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }
}
