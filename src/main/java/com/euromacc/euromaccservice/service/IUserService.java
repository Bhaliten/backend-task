package com.euromacc.euromaccservice.service;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.model.User;

public interface IUserService {
    User save(CreateUserRequest createUserRequest);
    UserSearchResponse findBySearchDto(UserSearchRequest searchRequest);
}
