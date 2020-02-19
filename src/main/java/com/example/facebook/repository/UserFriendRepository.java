package com.example.facebook.repository;

import com.example.facebook.model.UserFriend;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


@EnableScan
public interface UserFriendRepository extends CrudRepository<UserFriend, UUID> {
    Optional<UserFriend> findByUserIdAndFriendId(UUID userId, UUID friendId);
}
