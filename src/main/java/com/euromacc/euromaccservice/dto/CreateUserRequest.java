package com.euromacc.euromaccservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class CreateUserRequest {
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    String email;
}
