package com.euromacc.euromaccservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSearchResponse {
    Long total;
    List<UserResponse> userList;
}
