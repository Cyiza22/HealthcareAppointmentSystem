package org.example.hospital_management_system.patient;


import org.example.hospital_management_system.clinic.Clinic;
import org.example.hospital_management_system.clinic.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class PatientService {

    private  PatientRepository patientRepository;
    private  ClinicRepository clinicRepository;

    public Patient createPatient(PatientDTO dto, Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElseThrow(() -> new RuntimeException("Clinic not found"));
        Patient patient = new Patient();
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhoneNumber());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setClinic(clinic);
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() { return patientRepository.findAll(); }
    public Patient getPatient(Long id) { return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found")); }
    public void deletePatient(Long id) { patientRepository.deleteById(id); }
    public Patient updatePatient( Long id, PatientDTO patient) {
        var oldPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        oldPatient.setFirstName(patient.getFirstName());
        oldPatient.setLastName(patient.getLastName());
        oldPatient.setPhone(patient.getPhoneNumber());
        oldPatient.setEmail(patient.getEmail());
        return patientRepository.save(oldPatient);
    }
    }

