package com.euromacc.euromaccservice.converter;

import com.euromacc.euromaccservice.model.User;
import lombok.NonNull;
import org.springframework.data.elasticsearch.core.event.BeforeConvertCallback;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserConvertCallback implements BeforeConvertCallback<User> {
    @Override
    public @NonNull User onBeforeConvert(User user, @NonNull IndexCoordinates indexCoordinates) {

        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        return user;
    }
}
