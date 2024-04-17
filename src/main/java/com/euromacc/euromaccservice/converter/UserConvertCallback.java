package com.euromacc.euromaccservice.converter;

import com.euromacc.euromaccservice.model.UserResponse;
import lombok.NonNull;
import org.springframework.data.elasticsearch.core.event.BeforeConvertCallback;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserConvertCallback implements BeforeConvertCallback<UserResponse> {
    @Override
    public @NonNull UserResponse onBeforeConvert(UserResponse user, @NonNull IndexCoordinates indexCoordinates) {

        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        return user;
    }
}
