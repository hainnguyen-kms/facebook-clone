package com.example.facebook.controller;

import com.example.facebook.dto.request.CreateImageRequest;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.model.User;
import com.example.facebook.service.ImageService;
import com.example.facebook.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    ResponseEntity create(@RequestBody CreateImageRequest createImageRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_CREATED, imageService.create(createImageRequest, sessionUser))
        );
    }
}
