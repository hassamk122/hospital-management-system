package com.hassamkiani.hospitalManagement.repository;

import com.hassamkiani.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
