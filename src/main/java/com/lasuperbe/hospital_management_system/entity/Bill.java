package com.lasuperbe.hospital_management_system.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "bill")
public class Bill {
    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer id;
    @Column(name="bill_amountinsured")
    private Integer amountInsured;
    @Column(name = "bill_amountnotinsured")
    private Integer amountNotInsured;
    @Column(name = "bill_datesent")
    private String dateSent;
    @Column(name = "bill_status")
    private String status;

    // constructor
    public Bill() {
    }


    public Bill(Integer amountInsured, Integer amountNotInsured, String dateSent, String status) {
        this.amountInsured = amountInsured;
        this.amountNotInsured = amountNotInsured;
        this.dateSent = dateSent;
        this.status = status;
    }

    // getter/setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountInsured() {
        return amountInsured;
    }

    public void setAmountInsured(Integer amountInsured) {
        this.amountInsured = amountInsured;
    }

    public Integer getAmountNotInsured() {
        return amountNotInsured;
    }

    public void setAmountNotInsured(Integer amountNotInsured) {
        this.amountNotInsured = amountNotInsured;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amountInsured=" + amountInsured +
                ", amountNotInsured=" + amountNotInsured +
                ", dateSent='" + dateSent + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
