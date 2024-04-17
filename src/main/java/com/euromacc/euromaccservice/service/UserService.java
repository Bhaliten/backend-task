package com.euromacc.euromaccservice.service;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserResponse;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.mapper.IUserMapper;
import com.euromacc.euromaccservice.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository repository;
    private final IUserMapper mapper;

    @Override
    public UserResponse save(CreateUserRequest createUserRequest) {
        return this.mapper.map(this.repository.save(this.mapper.map(createUserRequest)));
    }

    @Override
    public UserSearchResponse findBySearchDto(UserSearchRequest searchRequest) {
        return null;
//        return this.repository.searchSimilar(
//                User.builder().lastName(searchRequest.getLastName()).firstName(searchRequest.getFirstName()).build(),
//                null,
//                Pageable.ofSize(100)
//        );
    }
}
