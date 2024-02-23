package com.task.hrms.services;

import com.task.hrms.model.Address;

import java.util.List;

public interface AddressService {
    Address save(Address address);

    Address findById(Long id);

    List<Address> findAll();

    void delete(Long id);

    List<Address> findByEmployeeId(Long id);
}
