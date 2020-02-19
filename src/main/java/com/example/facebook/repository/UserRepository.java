package com.example.facebook.repository;

import com.example.facebook.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@EnableScan
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByName(String username);
    List<User> findByIdIn(Iterable<UUID> userId);
}
