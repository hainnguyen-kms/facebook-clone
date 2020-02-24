package com.example.facebook.service;

import com.example.facebook.dto.request.LikeRequest;
import com.example.facebook.model.*;
import com.example.facebook.repository.CommentRepository;
import com.example.facebook.repository.FacebookLikeRepository;
import com.example.facebook.repository.ImageRepository;
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
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    CommentRepository commentRepository;

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

    public FacebookLike likeImage(LikeRequest likeRequest, User sessionUser) {
        Optional<Image> imageOptional = imageRepository.findById(likeRequest.getId());
        if(imageOptional.isPresent()) {
            FacebookLike like = new FacebookLike();
            like.setType(likeRequest.getStatus());
            like.setUser(sessionUser);
            like.setImage(imageOptional.get());
            return facebookLikeRepository.save(like);
        }
        return null;
    }

    public FacebookLike likeComment(LikeRequest likeRequest, User sessionUser) {
        Optional<Comment> commentOptional = commentRepository.findById(likeRequest.getId());
        if(commentOptional.isPresent()) {
            FacebookLike like = new FacebookLike();
            like.setType(likeRequest.getStatus());
            like.setUser(sessionUser);
            like.setComment(commentOptional.get());
            return facebookLikeRepository.save(like);
        }
        return null;
    }
}
