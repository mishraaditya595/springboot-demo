package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name =  "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Number")
    private Integer number;
    @Column(name = "Street")
    private String street;
    @Column(name = "Postcode")
    private String postcode;

    public Address() {
    }

    public Address(Integer number, String street, String postcode) {
        this.number = number;
        this.street = street;
        this.postcode = postcode;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
