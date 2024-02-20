package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StoreController  {
    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-addresses")
    public List<Address> getAllAddresses() {
        return mySqlRepository.findAll();
    }

    @GetMapping("/get-address/{id}")
    public Address getAddressById(@PathVariable("id") Integer id) {
        return mySqlRepository.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteRow(@PathVariable("id") Integer id) {
        if(!mySqlRepository.findById(id).equals(Optional.empty())) {
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public  Address updateAddress(
            @PathVariable("id") Integer id,
            @RequestBody Map<String, String> body) {
        Address address = mySqlRepository.findById(id).get();
        address.setStreet(body.get("street"));
        address.setNumber(Integer.parseInt(body.get("number")));
        address.setPostcode(body.get("postcode"));
        mySqlRepository.save(address);
        return address;
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody Map<String, String> body) {
        String street = body.get("street");
        Integer number = Integer.parseInt(body.get("number"));
        String postcode = body.get("postcode");

        Address address = new Address(number, street, postcode);
        mySqlRepository.save(address);
        return address;
    }
}
