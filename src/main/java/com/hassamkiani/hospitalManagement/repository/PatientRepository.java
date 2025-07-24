package com.hassamkiani.hospitalManagement.repository;


import com.hassamkiani.hospitalManagement.dto.BloodGroupResponse;
import com.hassamkiani.hospitalManagement.entity.Patient;
import com.hassamkiani.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    Patient findByBirthDate(LocalDate birthDate);
    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("Select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")  LocalDate birthDate );


    // Projection
    @Query("SELECT new com.hassamkiani.hospitalManagement.dto.BloodGroupResponse(p.bloodGroup, COUNT(p)) " +
            "FROM Patient p GROUP BY p.bloodGroup")
    List<BloodGroupResponse> countEachGroupType();

    //Pagination
    @Query(value = "select * from patient",nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("update Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") long id);

}
