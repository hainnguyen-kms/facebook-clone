package com.example.facebook.controller;

import com.example.facebook.dto.request.CreatePostRequest;
import com.example.facebook.dto.request.UpdatePostRequest;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.model.Post;
import com.example.facebook.model.User;
import com.example.facebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService userService;

    @PostMapping
    ResponseEntity create(@RequestBody @Valid CreatePostRequest createPostRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(userService.create(createPostRequest, sessionUser));
    }

    @PutMapping("/{id}")
    ResponseEntity update(@RequestBody @Valid UpdatePostRequest updatePostRequest, @PathVariable  UUID id) {
        return ResponseEntity.ok(userService.update(id, updatePostRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok(new SuccessRequestResponse());
    }
}
