package com.euromacc.euromaccservice.service;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserResponse;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.mapper.IUserMapper;
import com.euromacc.euromaccservice.model.User;
import com.euromacc.euromaccservice.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.UUID;


@MockitoSettings
class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private IUserRepository repository;
    @Mock
    private IUserMapper mapper;

    @Test
    void save() {
        UUID id = UUID.randomUUID();

        CreateUserRequest createUser = CreateUserRequest.builder()
                .lastName("last")
                .firstName("first")
                .email("email")
                .build();
        User savedUser = User.builder()
                .id(id)
                .firstName("first")
                .lastName("last")
                .email("email")
                .build();
        UserResponse mockedMapperUserResponse = UserResponse.builder()
                .id(id)
                .email("email")
                .lastName("last")
                .firstName("first")
                .build();

        Mockito.doReturn(savedUser)
                .when(this.repository)
                .save(Mockito.eq(savedUser.withId(null)));

        Mockito.doReturn(savedUser.withId(null))
                .when(this.mapper)
                .map(Mockito.eq(createUser));

        Mockito.doReturn(mockedMapperUserResponse)
                .when(this.mapper)
                .map(Mockito.eq(savedUser));

        UserResponse userResponse = this.service.save(createUser);

        Assertions.assertEquals(mockedMapperUserResponse, userResponse);
    }

    @Test
    void findBySearchRequest() {
        UUID id = UUID.randomUUID();
        User savedUser = User.builder()
                .id(id)
                .firstName("first")
                .lastName("last")
                .email("email")
                .build();
        UserResponse mockedMapperUserResponse = UserResponse.builder()
                .id(id)
                .email("email")
                .lastName("last")
                .firstName("first")
                .build();

        Mockito.doReturn(List.of(savedUser))
                .when(this.repository)
                .findByFirstNameLikeAndLastNameLike(Mockito.anyString(), Mockito.anyString());

        Mockito.doReturn(1L)
                .when(this.repository)
                .countByFirstNameLikeAndLastNameLike(Mockito.anyString(), Mockito.anyString());

        Mockito.doReturn(mockedMapperUserResponse)
                .when(this.mapper)
                .map(Mockito.eq(savedUser));

        UserSearchResponse userResponse = this.service.findBySearchRequest(UserSearchRequest.builder().firstName("first").lastName("last").build());

        Assertions.assertEquals(1L, userResponse.getTotal());
        Assertions.assertEquals(1L, userResponse.getUserList().size());
        Assertions.assertEquals(id, userResponse.getUserList().get(0).getId());


    }
}
