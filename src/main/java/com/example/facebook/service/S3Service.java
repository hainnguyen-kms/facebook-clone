package com.example.facebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service {
    @Autowired
    AmazonClient amazonClient;

    public String upload(MultipartFile file) {
        return amazonClient.uploadFile(file);
    }
}
