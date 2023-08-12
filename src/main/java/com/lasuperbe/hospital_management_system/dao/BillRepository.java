package com.lasuperbe.hospital_management_system.dao;

import com.lasuperbe.hospital_management_system.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
