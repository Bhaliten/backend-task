package com.euromacc.euromaccservice.controller;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserResponse;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import com.euromacc.euromaccservice.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@MockitoSettings
public class UserControllerUnitTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    void saveValidRequestReturnsOk() {
        CreateUserRequest request = CreateUserRequest.builder().firstName("first").lastName("last").email("email").build();
        UserResponse expectedResponse = UserResponse.builder().id(UUID.randomUUID()).firstName("first").lastName("last").email("email").build();
        Mockito.when(this.userService.save(Mockito.any(CreateUserRequest.class))).thenReturn(expectedResponse);

        ResponseEntity<UserResponse> responseEntity = this.userController.save(request);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    void searchValidRequestReturnsOk() {
        UserSearchRequest request = UserSearchRequest.builder().firstName("first").lastName("last").build();
        UserSearchResponse expectedResponse = UserSearchResponse.builder().total(0L).userList(List.of()).build();
        Mockito.when(this.userService.findBySearchRequest(Mockito.any(UserSearchRequest.class))).thenReturn(expectedResponse);

        ResponseEntity<UserSearchResponse> responseEntity = this.userController.search(request);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(expectedResponse, responseEntity.getBody());
    }
}
