package com.lasuperbe.hospital_management_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Integer id;
    @Column(name = "doc_firstname")
    private String firstname;
    @Column(name = "doc_lastname")
    private String lastname;

    // define constructors

    public Doctor() {
    }

    public Doctor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // define getter/setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // define object representation

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
