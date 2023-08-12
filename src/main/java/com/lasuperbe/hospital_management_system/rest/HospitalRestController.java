package com.lasuperbe.hospital_management_system.rest;

import com.lasuperbe.hospital_management_system.entity.Doctor;
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
}
