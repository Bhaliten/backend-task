package com.euromacc.euromaccservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {
    UUID id;
    String firstName;
    String lastName;
    String email;
}
