package com.euromacc.euromaccservice.service;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserResponse;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;

public interface IUserService {
    UserResponse save(CreateUserRequest createUserRequest);
    UserSearchResponse findBySearchRequest(UserSearchRequest searchRequest);
}
