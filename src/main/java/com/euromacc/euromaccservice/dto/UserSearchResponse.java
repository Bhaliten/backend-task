package com.euromacc.euromaccservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserSearchResponse {
    Long total;
    List<UserResponse> userList;
}
