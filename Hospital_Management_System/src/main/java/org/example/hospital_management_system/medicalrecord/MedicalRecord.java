package org.example.hospital_management_system.medicalrecord;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.hospital_management_system.doctors.Doctor;
import org.example.hospital_management_system.patient.Patient;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private String diagnosis;

    @Column(nullable = false)
    private String prescription;

    @Column(nullable = false)
    private LocalDateTime recordDate;


}
