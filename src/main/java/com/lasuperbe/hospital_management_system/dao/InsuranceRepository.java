package com.lasuperbe.hospital_management_system.dao;

import com.lasuperbe.hospital_management_system.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
