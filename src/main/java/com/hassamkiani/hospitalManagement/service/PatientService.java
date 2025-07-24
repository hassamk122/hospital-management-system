package com.hassamkiani.hospitalManagement.service;


import com.hassamkiani.hospitalManagement.entity.Patient;
import com.hassamkiani.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        // by using @Transactional it stores persistent context for same operations
        // p1 and p2 have same address and are equal
        // in this way we call db only once and use stored context to access information

        //      Entity      EntityManager   PersistentContext            Database
        //      patient -->  find()  -->        find it in    -->      if not found
        //                                   the persistent context    , select db call
        //                             <--      store result in        <-----
        //                                         persistent context
        //

        return p1;
    }
}
