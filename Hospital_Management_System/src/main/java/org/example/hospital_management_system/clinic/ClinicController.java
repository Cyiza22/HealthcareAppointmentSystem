package org.example.hospital_management_system.clinic;

import  org.example.hospital_management_system.clinic.ClinicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping("/create")
    public Clinic create(@RequestBody ClinicDTO dto) {
        return clinicService.createClinic(dto);
    }

    @GetMapping
    public List<Clinic> getAll() {
        return clinicService.getAllClinics();
    }

    @GetMapping("/{id}")
    public Optional<Clinic> getById(@PathVariable Long id) {
        return clinicService.getClinicById(id);
    }

    @PutMapping("/{id}")
    public Clinic update(@PathVariable Long id, @RequestBody Clinic updated) {
        return clinicService.updateClinic(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clinicService.deleteClinic(id);
    }
}
