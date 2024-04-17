package com.euromacc.euromaccservice.repository;

import com.euromacc.euromaccservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IUserRepositoryTest {

    @Autowired
    IUserRepository repository;

    @Test
    void test(){
        User user = User.builder()
                .email("email")
                .firstName("first")
                .lastName("last")
                .build();
        this.repository.save(user);
        Assertions.assertNotNull(this.repository.count());
    }
}
