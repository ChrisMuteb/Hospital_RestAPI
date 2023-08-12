package com.lasuperbe.hospital_management_system.service;

import com.lasuperbe.hospital_management_system.entity.Doctor;


import java.util.List;

public interface HospitalService {
    List<Doctor> findAll();
    Doctor findById(Integer theId);
    Doctor save(Doctor theDoctor);
    void deleteById(Integer theId);
}
