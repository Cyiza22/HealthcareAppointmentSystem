package org.example.hospital_management_system.medicalrecord;

import org.example.hospital_management_system.doctors.Doctor;
import org.example.hospital_management_system.doctors.DoctorRepository;
import org.example.hospital_management_system.patient.Patient;
import org.example.hospital_management_system.patient.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository recordRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public MedicalRecordService(MedicalRecordRepository recordRepository,
                                PatientRepository patientRepository,
                                DoctorRepository doctorRepository) {
        this.recordRepository = recordRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public MedicalRecord create(MedicalRecordDTO dto) {
        // Find patient
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Find doctor
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Create and fill medical record
        MedicalRecord record = new MedicalRecord();
        record.setPatient(patient);
        record.setDoctor(doctor);
        record.setDiagnosis(dto.getDiagnosis());
        record.setPrescription(dto.getPrescription());
        record.setRecordDate(dto.getRecordDate());

        return recordRepository.save(record);
    }

    public List<MedicalRecord> getAll() {
        return recordRepository.findAll();
    }

    public MedicalRecord getById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical record not found"));
    }

    public MedicalRecord updateRecord(Long id, MedicalRecordDTO updatedRecord) {
        MedicalRecord record = getById(id);
        record.setDiagnosis(updatedRecord.getDiagnosis());
        record.setPrescription(updatedRecord.getPrescription());
        return recordRepository.save(record);
    }

    public void delete(Long id) {
        recordRepository.deleteById(id);
    }
}
