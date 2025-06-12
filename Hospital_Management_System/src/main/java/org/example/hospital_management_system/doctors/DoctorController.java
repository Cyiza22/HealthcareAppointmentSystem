package org.example.hospital_management_system.doctors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/new")
    public ResponseEntity<Doctor> create(@Valid @RequestBody DoctorDTO dto , long clinicId) {
        return ResponseEntity.ok(doctorService.create(dto, clinicId));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getById(id));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Doctor> update(@RequestParam Long id, @RequestBody DoctorDTO updatedDoctor) {
        Doctor doc = doctorService.updateDoctor(id, updatedDoctor);
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
