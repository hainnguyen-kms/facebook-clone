package com.example.facebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String url;
    private Date time;

    @OneToMany()
    @JoinColumn(name="image_id", referencedColumnName = "id")
    Set<FacebookLike> likes;

    @OneToMany
    @JoinColumn(name="image_id",referencedColumnName = "id")
    Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    User user;

    public Image() {
    }

    public Image(UUID id, String url, Set<FacebookLike> likes, Set<Comment> comments) {
        this.id = id;
        this.url = url;
        this.likes = likes;
        this.comments = comments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<FacebookLike> getLikes() {
        return likes;
    }

    public void setLikes(Set<FacebookLike> likes) {
        this.likes = likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostPersist
    public void initImage() {
        time = new Date();
    }
}
