package com.example.facebook.dto.request;

import java.util.UUID;

public class CommentRequest {
    private UUID id;
    private String text;

    public CommentRequest() {
    }

    public CommentRequest(UUID id, String text) {
        this.id = id;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
