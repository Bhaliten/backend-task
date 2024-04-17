package com.euromacc.euromaccservice.service;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.model.UserResponse;

public interface IUserService {
    UserResponse save(CreateUserRequest createUserRequest);
    UserSearchResponse findBySearchDto(UserSearchRequest searchRequest);
}
