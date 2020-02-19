package com.example.facebook.service;

import com.example.facebook.dto.request.CreatePostRequest;
import com.example.facebook.dto.request.UpdatePostRequest;
import com.example.facebook.dto.response.CreatePostResponse;
import com.example.facebook.model.*;
import com.example.facebook.repository.ImageRepository;
import com.example.facebook.repository.PostRepository;
import com.example.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ImageRepository imageRepository;

    public CreatePostResponse create(CreatePostRequest createPostRequest, User sessionUser) {
        List<User> tags = new ArrayList<>();
        if(createPostRequest.getTags() != null) {
            tags = userRepository.findByIdIn(createPostRequest.getTags());
        }


        Post newPost = new Post();
        newPost.setUser(sessionUser);
        newPost.setText(createPostRequest.getText());
        newPost.setTime(createPostRequest.getTime());
        newPost.setTag(tags);
        newPost.setComments(new ArrayList<>());
        newPost.setLikes(new ArrayList<>());
        newPost.setImages(new ArrayList<>());

        return CreatePostResponse.of(postRepository.save(newPost));
    }

    public Object update(UUID id, @Valid UpdatePostRequest updatePostRequest) {
        Optional<Post> oldPost = postRepository.findById(id);
        if(oldPost.isPresent()) {
            List<User> tags = new ArrayList();
            List<Image> photos = new ArrayList();
            if(updatePostRequest.getTags() != null) {
                tags = userRepository.findByIdIn(updatePostRequest.getTags());
            }
            if(updatePostRequest.getPhotos() != null) {
                photos = imageRepository.findByIdIn(updatePostRequest.getPhotos());
            }
            Post post = oldPost.get();
            post.setImages(photos);
            post.setText(updatePostRequest.getText());
            post.setTag(tags);

            return CreatePostResponse.of(postRepository.save(post));
        }
        return null;
    }

    public void delete(UUID id) {
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(value -> postRepository.delete(value));
    }
}
