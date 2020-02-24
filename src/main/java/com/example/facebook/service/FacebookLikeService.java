package com.example.facebook.service;

import com.example.facebook.dto.request.LikeRequest;
import com.example.facebook.model.FacebookLike;
import com.example.facebook.model.Post;
import com.example.facebook.model.User;
import com.example.facebook.repository.FacebookLikeRepository;
import com.example.facebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class FacebookLikeService {
    @Autowired
    FacebookLikeRepository facebookLikeRepository;
    @Autowired
    PostRepository postRepository;

    public FacebookLike likePost(LikeRequest likeRequest, User sessionUser) {
        Optional<Post> post = postRepository.findById(likeRequest.getId());
        if(post.isPresent()) {
            FacebookLike like = new FacebookLike();
            like.setType(likeRequest.getStatus());
            like.setUser(sessionUser);
            like.setPost(post.get());
            return facebookLikeRepository.save(like);
        }
        return null;
    }
}
