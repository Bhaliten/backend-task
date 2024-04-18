package com.euromacc.euromaccservice.repository;

import com.euromacc.euromaccservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Disabled("playground")
class IUserRepositoryTest {

    @Autowired
    private IUserRepository repository;

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
    @Test
    void test2(){
        List<User> users = this.repository.findByFirstNameLikeAndLastNameLike("first", "last");
        Assertions.assertNotNull(users);

    }
}
