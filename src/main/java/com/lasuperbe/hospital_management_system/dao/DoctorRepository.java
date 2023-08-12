package com.lasuperbe.hospital_management_system.dao;

import com.lasuperbe.hospital_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
