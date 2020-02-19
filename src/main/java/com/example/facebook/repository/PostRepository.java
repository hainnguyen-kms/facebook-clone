package com.example.facebook.repository;

import com.example.facebook.model.Post;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;


@EnableScan
public interface PostRepository extends CrudRepository<Post, UUID> {
}
