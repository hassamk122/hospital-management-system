package com.hassamkiani.hospitalManagement.service;


import com.hassamkiani.hospitalManagement.entity.Appointment;
import com.hassamkiani.hospitalManagement.entity.Doctor;
import com.hassamkiani.hospitalManagement.entity.Patient;
import com.hassamkiani.hospitalManagement.repository.AppointmentRepository;
import com.hassamkiani.hospitalManagement.repository.DoctorRepository;
import com.hassamkiani.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId){

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not Found"));

        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null){
            throw new IllegalArgumentException("Appointment Not ");
        }

        appointment.setPatient(patient);

        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);


        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        return appointment;
    }

}
