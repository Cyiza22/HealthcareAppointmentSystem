package org.example.hospital_management_system.patient;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient, @RequestParam Long clinicId) {
        Patient createdPatient = patientService.createPatient(patient, clinicId);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        Patient patient = patientService.getPatient(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}
