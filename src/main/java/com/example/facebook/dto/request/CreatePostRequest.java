package com.example.facebook.dto.request;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CreatePostRequest {
    private String text;
    private Date time;
    private List<UUID> tags;
    private List<UUID> photoUrls;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<UUID> getTags() {
        return tags;
    }

    public void setTags(List<UUID> tags) {
        this.tags = tags;
    }

    public List<UUID> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<UUID> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public CreatePostRequest() {
    }

    public CreatePostRequest(String text, Date time, List<UUID> tags, List<UUID> photoUrls) {
        this.text = text;
        this.time = time;
        this.tags = tags;
        this.photoUrls = photoUrls;
    }

}
