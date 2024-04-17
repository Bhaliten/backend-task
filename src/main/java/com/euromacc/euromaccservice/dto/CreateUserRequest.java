package com.euromacc.euromaccservice.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class CreateUserRequest {
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    String email;
}
