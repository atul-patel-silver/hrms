package com.task.hrms.services.implementation;

import com.task.hrms.model.Address;
import com.task.hrms.repository.AddressRepository;
import com.task.hrms.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImple implements AddressService {


    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return this.addressRepository.findById(id).get();
    }

    @Override
    public List<Address> findAll() {
        return this.addressRepository.findAllEnable();
    }

    @Override
    public void delete(Long id) {
        Address address = this.addressRepository.findById(id).get();
        address.setEnable(false);
        this.addressRepository.save(address);
    }

    @Override
    public List<Address> findByEmployeeId(Long id) {
        return this.addressRepository.findByEmployeeId(id);
    }
}
