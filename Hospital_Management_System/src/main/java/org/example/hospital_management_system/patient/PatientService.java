package org.example.hospital_management_system.patient;


import org.example.hospital_management_system.clinic.Clinic;
import org.example.hospital_management_system.clinic.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class PatientService {
        @Autowired
        private PatientRepository patientRepository;

        @Autowired
        private ClinicRepository clinicRepository;

        public Patient createPatient(Patient patient, Long clinicId) {
            Clinic clinic = clinicRepository.findById(clinicId)
                    .orElseThrow(() -> new RuntimeException("Clinic not found"));
            patient.setId(clinic.getId());
            return patientRepository.save(patient);
        }

        public Patient getPatient(Long id) {
            return patientRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
        }
    }

