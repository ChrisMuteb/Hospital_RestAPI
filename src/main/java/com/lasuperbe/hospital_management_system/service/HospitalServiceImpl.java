package com.lasuperbe.hospital_management_system.service;

import com.lasuperbe.hospital_management_system.dao.BillRepository;
import com.lasuperbe.hospital_management_system.dao.DoctorRepository;
import com.lasuperbe.hospital_management_system.dao.InsuranceRepository;
import com.lasuperbe.hospital_management_system.entity.Bill;
import com.lasuperbe.hospital_management_system.entity.Doctor;
import com.lasuperbe.hospital_management_system.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService{
    private DoctorRepository doctorRepository;
    private BillRepository billRepository;
    private InsuranceRepository insuranceRepository;
    @Autowired
    public HospitalServiceImpl(DoctorRepository doctorRepository, BillRepository billRepository, InsuranceRepository insuranceRepository) {
        this.doctorRepository = doctorRepository;
        this.billRepository = billRepository;
        this.insuranceRepository = insuranceRepository;
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

    // Bill
    @Override
    public List<Bill> bill_findAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill bill_findById(Integer theId) {
        Optional<Bill> result = billRepository.findById(theId);
        Bill theBill = null;

        if(result.isPresent())
            theBill = result.get();
        else
            throw new RuntimeException("Did not find bill id - " + theId);

        return theBill;
    }

    @Override
    public Bill bill_save(Bill theBill) {
        return billRepository.save(theBill);
    }

    @Override
    public void bill_deleteById(Integer theId) {
        billRepository.deleteById(theId);
    }

    // Insurance
    @Override
    public List<Insurance> ins_findAll() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance ins_findById(Integer theId) {
        Optional<Insurance> result = insuranceRepository.findById(theId);
        Insurance theInsurance = null;
        if(result.isPresent())
            theInsurance = result.get();
        else
            throw new RuntimeException("insurance id - " + theId);
        return theInsurance;
    }

    @Override
    public Insurance ins_save(Insurance theIns) {
        return insuranceRepository.save(theIns);
    }

    @Override
    public void ins_deleteById(Integer theId) {
        insuranceRepository.deleteById(theId);
    }
}
