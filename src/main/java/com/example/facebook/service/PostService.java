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
        newPost.setTags(tags);
        newPost.setComments(new ArrayList<>());
        newPost.setLikes(new ArrayList<>());
        newPost.setImages(new ArrayList<>());

        return CreatePostResponse.of(postRepository.save(newPost));
    }

    public Object update(UUID id, @Valid UpdatePostRequest updatePostRequest) {
        Optional<Post> oldPost = postRepository.findById(id);
        if(oldPost.isPresent()) {
            Post post = oldPost.get();
            if(updatePostRequest.getTags() != null) {
                post.setTags(userRepository.findByIdIn(updatePostRequest.getTags()));
            }
            if(updatePostRequest.getPhotos() != null) {
                post.setImages(imageRepository.findByIdIn(updatePostRequest.getPhotos()));
            }
            if(updatePostRequest.getText() != null) {
                post.setText(updatePostRequest.getText());
            }

            return CreatePostResponse.of(postRepository.save(post));
        }
        return null;
    }

    public void delete(UUID id) {
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(value -> postRepository.delete(value));
    }

    public Optional<Post> getById(UUID id) {
        return postRepository.findById(id);
    }

    public List<Post> getByUserId(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(User::getPosts).orElse(null);
    }
}
