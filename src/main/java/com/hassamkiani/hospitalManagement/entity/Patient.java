package com.hassamkiani.hospitalManagement.entity;

import com.hassamkiani.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        // gives table name
        name = "patient",
        uniqueConstraints ={
                // this makes sure no patient with same name and dob can be inserted
                @UniqueConstraint(name = "unique_patient_name_birthDate", columnNames = {"name", "birth_date"})
        },
        indexes = {
                @Index(name = "idx_patient_birthDate", columnList = "birth_date")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate birthDate;

    private String gender;

    @Column(unique = true,nullable = false)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;


    @OneToOne(cascade = {CascadeType.ALL} ,orphanRemoval = true )
    @JoinColumn(name = "patient_insurance_id") // Owning Side
    private Insurance insurance;


    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY , cascade = {CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();
}
