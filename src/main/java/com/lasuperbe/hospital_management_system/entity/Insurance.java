package com.lasuperbe.hospital_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance {
    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private Integer id;
    @Column(name = "ins_benefitcontact")
    private String benefitContract;
    @Column(name = "ins_phonenumber")
    private String phoneNumber;
    @Column(name = "ins_claimaddress")
    private String Address;

    // constructor

    public Insurance() {
    }

    public Insurance(String benefitContract, String phoneNumber, String address) {
        this.benefitContract = benefitContract;
        this.phoneNumber = phoneNumber;
        Address = address;
    }

    // getter/setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBenefitContract() {
        return benefitContract;
    }

    public void setBenefitContract(String benefitContract) {
        this.benefitContract = benefitContract;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    // toString

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", benefitContract='" + benefitContract + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
