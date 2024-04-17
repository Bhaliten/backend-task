package com.euromacc.euromaccservice.mapper;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    com.euromacc.euromaccservice.dto.UserResponse map(UserResponse user);
    UserResponse map(CreateUserRequest user);
}
