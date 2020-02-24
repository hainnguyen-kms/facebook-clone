package com.example.facebook.dto.response;

import java.util.UUID;

public class CreateImageResponse {
    private UUID imageId;

    public CreateImageResponse() {
    }

    public CreateImageResponse(UUID imageId) {
        this.imageId = imageId;
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }
}
