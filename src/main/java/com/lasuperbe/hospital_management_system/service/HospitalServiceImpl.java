package com.lasuperbe.hospital_management_system.service;

import com.lasuperbe.hospital_management_system.dao.DoctorRepository;
import com.lasuperbe.hospital_management_system.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService{
    private DoctorRepository doctorRepository;

    public HospitalServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Integer theId) {
        Optional<Doctor> result = doctorRepository.findById(theId);
        Doctor theDoctor = null;

        if(result.isPresent())
            theDoctor = result.get();
        else
            throw new RuntimeException("Did not find doctor id - " + theId);
        return theDoctor;
    }

    @Override
    public Doctor save(Doctor theDoctor) {
        return doctorRepository.save(theDoctor);
    }

    @Override
    public void deleteById(Integer theId) {
        doctorRepository.deleteById(theId);
    }
}
