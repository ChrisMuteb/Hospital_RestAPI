package com.lasuperbe.hospital_management_system.service;

import com.lasuperbe.hospital_management_system.entity.Bill;
import com.lasuperbe.hospital_management_system.entity.Doctor;
import com.lasuperbe.hospital_management_system.entity.Insurance;


import java.util.List;

public interface HospitalService {
    // Doctor
    List<Doctor> findAll();
    Doctor findById(Integer theId);
    Doctor save(Doctor theDoctor);
    void deleteById(Integer theId);

    // Bill
    List<Bill> bill_findAll();
    Bill bill_findById(Integer theId);
    Bill bill_save(Bill theBill);
    void bill_deleteById(Integer theId);

    // Bill
    List<Insurance> ins_findAll();
    Insurance ins_findById(Integer theId);
    Insurance ins_save(Insurance theIns);
    void ins_deleteById(Integer theId);
}
