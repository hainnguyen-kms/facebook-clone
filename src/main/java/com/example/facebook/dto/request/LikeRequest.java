package com.example.facebook.dto.request;

import com.example.facebook.util.LikeStatus;

import java.util.UUID;

public class LikeRequest {
    private UUID id;
    private LikeStatus status;

    public LikeRequest() {
    }

    public LikeRequest(UUID id, LikeStatus status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LikeStatus getStatus() {
        return status;
    }

    public void setStatus(LikeStatus status) {
        this.status = status;
    }
}
