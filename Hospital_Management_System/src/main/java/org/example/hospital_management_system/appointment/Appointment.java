package org.example.hospital_management_system.appointment;

import jakarta.persistence.*;
import lombok.*;
import org.example.hospital_management_system.doctors.Doctor;
import org.example.hospital_management_system.patient.Patient;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

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
    private LocalDateTime appointmentDate;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String notes;

    @Column(nullable = false)
    private String status;


}

