package com.hassamkiani.hospitalManagement.service;


import com.hassamkiani.hospitalManagement.entity.Insurance;
import com.hassamkiani.hospitalManagement.entity.Patient;
import com.hassamkiani.hospitalManagement.repository.InsuranceRepository;
import com.hassamkiani.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository
                .findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient Not found with ID: "+patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); // to maintain bidirectional consistency

        return patient;
    }


    @Transactional
    public Patient diassociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);

        return patient;
    }
}
