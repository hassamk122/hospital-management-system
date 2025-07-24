package com.hassamkiani.hospitalManagement;


import com.hassamkiani.hospitalManagement.dto.BloodGroupResponse;
import com.hassamkiani.hospitalManagement.entity.Patient;
import com.hassamkiani.hospitalManagement.entity.type.BloodGroupType;
import com.hassamkiani.hospitalManagement.repository.PatientRepository;
import com.hassamkiani.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
       List<Patient> patients = patientRepository.findAll();

        System.out.println(patients);
    }

    @Test
    public void testTransactionMethods(){


        Page<Patient> patients = patientRepository
                .findAllPatients(PageRequest.of(0, 2, Sort.by("name")));

        for (Patient p : patients) {
            System.out.println(p);
        }


//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//
//        for(Object[] p:bloodGroupList){
//            System.out.println(p[0]+""+p[1]);
//        }

//        List<Patient> patients = patientRepository.findAllPatients();

//        int updateName = patientRepository.updateNameWithId("Hassam",6);
//        System.out.println(updateName);
//        for(Patient p : patients){
//            System.out.println(p);
//        }
//        List<BloodGroupResponse> bloodGroupList = patientRepository.countEachGroupType();
//
//        for(BloodGroupResponse p: bloodGroupList){
//            System.out.println(p);
//        }


    }



}
