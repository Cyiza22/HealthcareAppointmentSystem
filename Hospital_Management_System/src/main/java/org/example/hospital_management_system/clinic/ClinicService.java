package org.example.hospital_management_system.clinic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Optional<Clinic> getClinicById(Long id) {
        return clinicRepository.findById(id);
    }

    public Clinic updateClinic(Long id, Clinic clinicDetails) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow();

        clinic.setName(clinicDetails.getName());
        clinic.setLocation(clinicDetails.getLocation());
        clinic.setPhoneNumber(clinicDetails.getPhoneNumber());

        return clinicRepository.save(clinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }
}
