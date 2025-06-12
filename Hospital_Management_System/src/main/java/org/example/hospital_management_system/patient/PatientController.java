package org.example.hospital_management_system.patient;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private PatientService patientService;

    @PostMapping("/add_new")
    public ResponseEntity<Patient> create(@RequestBody PatientDTO dto, @RequestParam Long clinicId) {
        Patient patient =  patientService.createPatient(dto, clinicId);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Long id) {
        Patient patient1 = patientService.getPatient(id);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody PatientDTO patient) {
        Patient patient1 = patientService.updatePatient(id, patient);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient successfully deleted",HttpStatus.OK);
    }
}
