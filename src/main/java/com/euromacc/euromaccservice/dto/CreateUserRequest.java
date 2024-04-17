package com.euromacc.euromaccservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {
    @NotBlank(message = "firstName is required")
    String firstName;
    @NotBlank(message = "lastName is required")
    String lastName;
    String email;
}
