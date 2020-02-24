package com.example.facebook.dto.request;

import java.util.List;

public class CreateImageRequest {
    private List<String> imageUrls;

    public CreateImageRequest() {
    }

    public CreateImageRequest(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
