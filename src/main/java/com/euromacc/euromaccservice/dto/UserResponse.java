package com.euromacc.euromaccservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {
    UUID id;
    String firstName;
    String lastName;
    String email;
}
