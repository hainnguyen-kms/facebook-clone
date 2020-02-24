package com.example.facebook.controller;

import com.example.facebook.dto.request.CommentRequest;
import com.example.facebook.dto.request.CreatePostRequest;
import com.example.facebook.dto.request.LikeRequest;
import com.example.facebook.dto.request.UpdatePostRequest;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.model.Post;
import com.example.facebook.model.User;
import com.example.facebook.service.CommentService;
import com.example.facebook.service.FacebookLikeService;
import com.example.facebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    FacebookLikeService facebookLikeService;
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, postService.getById(id))
        );
    }

    @GetMapping("/user/{userId}")
    ResponseEntity getByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, postService.getByUserId(userId))
        );
    }

    @PostMapping("/like")
    ResponseEntity likeImageById(@RequestBody @Valid LikeRequest likeRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, facebookLikeService.likePost(likeRequest, sessionUser))
        );
    }

    @PostMapping("/comment")
    ResponseEntity commentPostById(@RequestBody @Valid CommentRequest commentRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
            new SuccessRequestResponse(null, HttpServletResponse.SC_OK, commentService.commentPost(commentRequest, sessionUser))
        );
    }

    @PostMapping
    ResponseEntity create(@RequestBody @Valid CreatePostRequest createPostRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_CREATED,postService.create(createPostRequest, sessionUser))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity update(@RequestBody @Valid UpdatePostRequest updatePostRequest, @PathVariable  UUID id) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, postService.update(id, updatePostRequest))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable UUID id) {
        postService.delete(id);
        return ResponseEntity.ok(new SuccessRequestResponse(null, HttpServletResponse.SC_OK, null));
    }
}
