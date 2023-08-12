package com.lasuperbe.hospital_management_system.rest;

import com.lasuperbe.hospital_management_system.entity.Bill;
import com.lasuperbe.hospital_management_system.entity.Doctor;
import com.lasuperbe.hospital_management_system.entity.Insurance;
import com.lasuperbe.hospital_management_system.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalRestController {
    private HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    // expose "/doctors" and return a list of doctors
    @GetMapping("/doctors")
    public List<Doctor> findAll(){ return hospitalService.findAll();}

    // expose "/doctors/{doctorId}" and return a doctors
    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctor(@PathVariable Integer doctorId){
        Doctor doctor = hospitalService.findById(doctorId);

        if(doctor == null)
            throw new RuntimeException("Doctor id not found - " + doctorId);
        return doctor;
    }

    // add mapping for POST /doctors - add new employee
    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor theDoctor){
        theDoctor.setId(0);
        Doctor dbDoctor = hospitalService.save(theDoctor);

        return dbDoctor;
    }

    // add mapping for PUT /doctors - update existing doctor
    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody Doctor theDoctor){
        Doctor dbDoctor = hospitalService.save(theDoctor);
        return dbDoctor;
    }

    // add mapping for DELETE /doctors/{doctorId} - delete doctor
    @DeleteMapping("/doctors/{doctorId}")
    public String deleteDoctor(@PathVariable Integer doctorId){
        Doctor tempDoctor = hospitalService.findById(doctorId);
        if(tempDoctor == null)
            throw new RuntimeException("Doctor id not found - " + doctorId);

        hospitalService.deleteById(doctorId);

        return "Deleted doctor id - " + doctorId;
    }

    // Bill
    // expose "/bills" and return a list of doctors
    @GetMapping("/bills")
    public List<Bill> bill_findAll(){ return hospitalService.bill_findAll();}

    // expose "/bills/{billId}" and return a bill
    @GetMapping("/bills/{billId}")
    public Bill getBill(@PathVariable Integer billId){
        Bill bill = hospitalService.bill_findById(billId);

        if(bill == null)
            throw new RuntimeException("Bill id not found - " + billId);
        return bill;
    }

    // add mapping for POST /bills - add new bill
    @PostMapping("/bills")
    public Bill addBill(@RequestBody Bill theBill){
        theBill.setId(0);
        Bill dbBill = hospitalService.bill_save(theBill);

        return dbBill;
    }

    // add mapping for PUT /bills - update existing bill
    @PutMapping("/bills")
    public Bill updateBill(@RequestBody Bill theBill){
        Bill dbBill = hospitalService.bill_save(theBill);
        return dbBill;
    }

    // add mapping for DELETE /bills/{billId} - delete doctor
    @DeleteMapping("/bills/{billId}")
    public String deleteBill(@PathVariable Integer billId){
        Bill tempBill = hospitalService.bill_findById(billId);
        if(tempBill == null)
            throw new RuntimeException("Bill id not found - " + billId);

        hospitalService.bill_deleteById(billId);

        return "Deleted doctor id - " + billId;
    }

    // Insurance
    // expose "/insurances" and return a list of insurances
    @GetMapping("/insurances")
    public List<Insurance> ins_findAll(){ return hospitalService.ins_findAll();}

    // expose "/insurances/{billId}" and return an insurance
    @GetMapping("/insurances/{insId}")
    public Insurance getIns(@PathVariable Integer insId){
        Insurance ins = hospitalService.ins_findById(insId);

        if(ins == null)
            throw new RuntimeException("Bill id not found - " + insId);
        return ins;
    }

    // add mapping for POST /insurances - add new insurance
    @PostMapping("/insurances")
    public Insurance addInsurance(@RequestBody Insurance theIns){
        theIns.setId(0);
        Insurance dbIns = hospitalService.ins_save(theIns);

        return dbIns;
    }

    // add mapping for PUT /insurances - update existing insurance
    @PutMapping("/insurances")
    public Insurance updateInsurance(@RequestBody Insurance theIns){
        Insurance dbIns = hospitalService.ins_save(theIns);
        return dbIns;
    }

    // add mapping for DELETE /insurances/{insId} - delete doctor
    @DeleteMapping("/insurances/{insId}")
    public String deleteIns(@PathVariable Integer insId){
        Insurance tempBill = hospitalService.ins_findById(insId);
        if(tempBill == null)
            throw new RuntimeException("Insurance id not found - " + insId);

        hospitalService.ins_deleteById(insId);

        return "Deleted doctor id - " + insId;
    }
}
