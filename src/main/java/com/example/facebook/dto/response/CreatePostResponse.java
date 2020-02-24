package com.example.facebook.dto.response;

import com.example.facebook.model.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreatePostResponse {
    private UUID id;
    private String text;
    private Date time;
    private List<UUID> likes;
    private List<UUID> comments;
    private List<UUID> images;
    private List<UUID> tags;

    public CreatePostResponse() {
    }

    public CreatePostResponse(UUID id, String text, Date time, List<UUID> likes, List<UUID> comments, List<UUID> images, List<UUID> tags) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.likes = likes;
        this.comments = comments;
        this.images = images;
        this.tags = tags;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<UUID> getLikes() {
        return likes;
    }

    public void setLikes(List<UUID> likes) {
        this.likes = likes;
    }

    public List<UUID> getComments() {
        return comments;
    }

    public void setComments(List<UUID> comments) {
        this.comments = comments;
    }

    public List<UUID> getImages() {
        return images;
    }

    public void setImages(List<UUID> images) {
        this.images = images;
    }

    public List<UUID> getTags() {
        return tags;
    }

    public void setTags(List<UUID> tags) {
        this.tags = tags;
    }

    public static CreatePostResponse of(Post newPost) {
        CreatePostResponse result = new CreatePostResponse();
        result.setId(newPost.getId());
        result.setText(newPost.getText());
        result.setTime(newPost.getTime());
        if(newPost.getLikes() != null) {
            result.setLikes(newPost.getLikes().stream().map(FacebookLike::getId).collect(Collectors.toList()));
        }
        if(newPost.getComments() != null) {
            result.setComments(newPost.getComments().stream().map(Comment::getId).collect(Collectors.toList()));
        }
        if(newPost.getImages() != null) {
            result.setImages(newPost.getImages().stream().map(Image::getId).collect(Collectors.toList()));
        }
        if(newPost.getTags() != null)
        result.setTags(newPost.getTags().stream().map(User::getId).collect(Collectors.toList()));
        return result;
    }
}
