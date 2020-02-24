package com.example.facebook.controller;

import com.example.facebook.dto.request.CommentRequest;
import com.example.facebook.dto.request.CreateImageRequest;
import com.example.facebook.dto.request.LikeRequest;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.model.User;
import com.example.facebook.service.CommentService;
import com.example.facebook.service.FacebookLikeService;
import com.example.facebook.service.ImageService;
import com.example.facebook.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    FacebookLikeService facebookLikeService;
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    ResponseEntity getById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, imageService.getById(id))
        );
    }

    @PostMapping
    ResponseEntity create(@RequestBody CreateImageRequest createImageRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_CREATED, imageService.create(createImageRequest, sessionUser))
        );
    }

    @PostMapping("/like")
    ResponseEntity likePostById(@RequestBody @Valid LikeRequest likeRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, facebookLikeService.likeImage(likeRequest, sessionUser))
        );
    }

    @PostMapping("/comment")
    ResponseEntity commentImageById(@RequestBody @Valid CommentRequest commentRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, commentService.commentImage(commentRequest, sessionUser))
        );
    }
}
