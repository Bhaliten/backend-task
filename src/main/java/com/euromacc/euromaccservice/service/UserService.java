package com.euromacc.euromaccservice.service;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.model.User;
import com.euromacc.euromaccservice.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository repository;

    @Override
    public User save(CreateUserRequest createUserRequest) {
        return null;
//        return this.repository.save();
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
