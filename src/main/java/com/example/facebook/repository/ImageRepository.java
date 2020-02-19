package com.example.facebook.repository;

import com.example.facebook.model.Image;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


@EnableScan
public interface ImageRepository extends CrudRepository<Image, UUID> {
    List<Image> findByIdIn(Iterable<UUID> imageId);
}
