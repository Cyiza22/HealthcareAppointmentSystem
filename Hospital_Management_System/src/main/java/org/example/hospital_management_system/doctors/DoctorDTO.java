package org.example.hospital_management_system.doctors;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DoctorDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Specialty is required")
    private String specialty;

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Clinic ID is required")
    private Long clinicId;

}

