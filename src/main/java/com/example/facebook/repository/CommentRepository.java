package com.example.facebook.repository;

import com.example.facebook.model.Comment;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


@EnableScan
public interface CommentRepository extends CrudRepository<Comment, UUID> {
}
