package org.example.hospital_management_system.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentDTO {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotNull(message = "Appointment date is required")
    private LocalDateTime appointmentDate;

    @NotBlank(message = "Status is required")
    private String status; // e.g., SCHEDULED, COMPLETED, CANCELLED

    private String notes;

}
