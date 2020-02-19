package com.example.facebook.dto.request;

import java.util.List;
import java.util.UUID;

public class UpdatePostRequest {
    private String text;
    private List<UUID> tags;
    private List<UUID> photos;

    public UpdatePostRequest() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<UUID> getTags() {
        return tags;
    }

    public void setTags(List<UUID> tags) {
        this.tags = tags;
    }

    public List<UUID> getPhotos() {
        return photos;
    }

    public void setPhotos(List<UUID> photos) {
        this.photos = photos;
    }

    public UpdatePostRequest(String text, List<UUID> tags, List<UUID> photos) {
        this.text = text;
        this.tags = tags;
        this.photos = photos;
    }
}
