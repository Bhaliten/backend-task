package com.euromacc.euromaccservice.repository;

import com.euromacc.euromaccservice.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends ElasticsearchRepository<User, UUID> {
}
