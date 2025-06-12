package org.example.hospital_management_system.clinic;


import jakarta.persistence.*;
import lombok.*;
import org.example.hospital_management_system.doctors.Doctor;
import org.example.hospital_management_system.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(nullable = false, length = 50)
    private String location;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @OneToMany(mappedBy = "clinic" , cascade = CascadeType.REMOVE)
    private List<Patient> patient ;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.REMOVE)
    private List<Doctor> doctor;

}
