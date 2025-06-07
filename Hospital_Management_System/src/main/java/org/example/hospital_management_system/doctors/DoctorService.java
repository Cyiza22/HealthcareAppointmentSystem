package org.example.hospital_management_system.doctors;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor create(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setFullName(dto.getFirstName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setContactInfo(dto.getEmail());

        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
