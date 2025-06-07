package org.example.hospital_management_system.clinic;

import jakarta.validation.constraints.*;

public class ClinicDTO {

    @NotBlank(message = "Clinic name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

}

