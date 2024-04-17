package com.euromacc.euromaccservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Document(indexName = "users")
@Data
public class User {
    @Id
    UUID id;
    String firstName;
    String lastName;
    String email;
}
