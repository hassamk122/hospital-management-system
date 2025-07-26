package com.hassamkiani.hospitalManagement.repository;

import com.hassamkiani.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
