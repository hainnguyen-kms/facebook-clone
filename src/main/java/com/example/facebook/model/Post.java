package com.example.facebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    private String text;
    private Date time;

    @OneToMany
    @JoinColumn(name="post_id", referencedColumnName = "id")
    List<FacebookLike> likes;

    @OneToMany
    @JoinColumn(name="post_id",referencedColumnName = "id")
    List<Comment> comments;

    @OneToMany
    @JoinColumn(name="post_id", referencedColumnName = "id")
    List<Image> images;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    User user;

    @ManyToMany
    List<User> tags;

    @PrePersist
    void initDate() {
        time = new Date();
    }

    public Post() {
    }

    public Post(UUID id, @NotNull String text, Date time, List<FacebookLike> likes, List<Comment> comments, List<Image> images, User user, List<User> tags) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.likes = likes;
        this.comments = comments;
        this.images = images;
        this.user = user;
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

    public List<FacebookLike> getLikes() {
        return likes;
    }

    public void setLikes(List<FacebookLike> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getTags() {
        return tags;
    }

    public void setTags(List<User> tag) {
        this.tags = tag;
    }
}
