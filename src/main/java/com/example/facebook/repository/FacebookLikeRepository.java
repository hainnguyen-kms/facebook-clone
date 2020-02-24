package com.example.facebook.repository;

import com.example.facebook.model.FacebookLike;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


@EnableScan
public interface FacebookLikeRepository extends CrudRepository<FacebookLike, UUID> {
}
