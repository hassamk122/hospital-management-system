package com.hassamkiani.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;


    @Column(length = 500)
    private String reason;


    @ManyToOne    // many appointment to one patient
    @ToString.Exclude
    @JoinColumn(name = "patient_id" ,nullable = false)
    private Patient patient;


    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "doctor_id" ,nullable = false)
    private Doctor doctor;
}
