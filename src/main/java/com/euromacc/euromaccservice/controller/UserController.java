package com.euromacc.euromaccservice.controller;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserResponse;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/elasticsearch")
public class UserController {

    private final IUserService service;


    @PostMapping("/create")
    public ResponseEntity<UserResponse> save(@RequestBody @Valid CreateUserRequest request) {
        return ResponseEntity.ok(this.service.save(request));
    }

    @GetMapping("/search")
    public ResponseEntity<UserSearchResponse> search(@Valid UserSearchRequest request) {
        return ResponseEntity.ok(this.service.findBySearchRequest(request));
    }
}
