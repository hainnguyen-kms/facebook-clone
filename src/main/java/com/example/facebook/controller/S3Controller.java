package com.example.facebook.controller;

import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/upload")
public class S3Controller {
    @Autowired
    S3Service s3Service;

    @PostMapping
    ResponseEntity upload(@RequestPart(value = "file") MultipartFile file) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, s3Service.upload(file))
        );
    }
}
