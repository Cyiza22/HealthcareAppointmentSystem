package org.example.hospital_management_system.medicalrecord;

import org.example.hospital_management_system.medicalrecord.MedicalRecord;
import org.example.hospital_management_system.medicalrecord.MedicalRecordDTO;
import org.example.hospital_management_system.medicalrecord.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService recordService;

    public MedicalRecordController(MedicalRecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> create(@Valid @RequestBody MedicalRecordDTO dto) {
        return ResponseEntity.ok(recordService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAll() {
        return ResponseEntity.ok(recordService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(recordService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
