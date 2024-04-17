package com.euromacc.euromaccservice.controller;

import com.euromacc.euromaccservice.dto.CreateUserRequest;
import com.euromacc.euromaccservice.dto.UserResponse;
import com.euromacc.euromaccservice.dto.UserSearchRequest;
import com.euromacc.euromaccservice.dto.UserSearchResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class UserControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void save() {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .email("email@gmail.com")
                .firstName("First")
                .lastName("Last")
                .build();

        this.client.post()
                .uri("/api/elasticsearch/create")
                .bodyValue(createUserRequest)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(UserResponse.class)
                .value(response -> {
                    Assertions.assertNotNull(response.getId());
                    Assertions.assertEquals(createUserRequest.getEmail(), response.getEmail());
                    Assertions.assertEquals(createUserRequest.getLastName(), response.getLastName());
                    Assertions.assertEquals(createUserRequest.getFirstName(), response.getFirstName());
                });
    }

    @Test
    void saveWithoutNames() {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .email("email@gmail.com")
                .build();

        this.client.post()
                .uri("/api/elasticsearch/create")
                .bodyValue(createUserRequest)
                .exchange()
                .expectStatus()
                .isBadRequest()
        ;

    }

    @Test
    void search() {
        UserSearchRequest userSearchRequest = UserSearchRequest.builder().lastName("last").firstName("first").build();
        this.client.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/elasticsearch/search")
                                .queryParam("firstName", userSearchRequest.getFirstName())
                                .queryParam("lastName", userSearchRequest.getLastName())
                                .build())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(UserSearchResponse.class)
                .value(userSearchResponse -> {
                    Assertions.assertEquals(userSearchResponse.getTotal(), userSearchResponse.getUserList().size());
                    userSearchResponse.getUserList().forEach(user -> {
                        Assertions.assertNotNull(user.getId());
                        Assertions.assertTrue(user.getFirstName().toLowerCase().contains(userSearchRequest.getFirstName()));
                        Assertions.assertTrue(user.getLastName().toLowerCase().contains(userSearchRequest.getLastName()));
                    });
                })
        ;
    }


    @Test
    void searchWithoutNames() {
        this.client.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/api/elasticsearch/search")
                                .build())
                .exchange()
                .expectStatus()
                .isBadRequest();
    }
}
