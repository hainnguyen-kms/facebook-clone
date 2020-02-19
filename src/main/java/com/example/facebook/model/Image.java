package com.example.facebook.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String url;

    @OneToMany()
    @JoinColumn(name="image_id", referencedColumnName = "id")
    Set<FacebookLike> likes;

    @OneToMany
    @JoinColumn(name="image_id",referencedColumnName = "id")
    Set<Comment> comments;

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
}
