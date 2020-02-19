package com.example.facebook.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    private Date time;
    private String text;

    @OneToMany()
    @JoinColumn(name="comment_id", referencedColumnName = "id")
    Set<FacebookLike> likes;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    Set<Comment> replies;

    public Comment() {
    }

    public Comment(UUID id, Date time, String text, Set<FacebookLike> likes, Set<Comment> replies) {
        this.id = id;
        this.time = time;
        this.text = text;
        this.likes = likes;
        this.replies = replies;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<FacebookLike> getLikes() {
        return likes;
    }

    public void setLikes(Set<FacebookLike> likes) {
        this.likes = likes;
    }

    public Set<Comment> getReplies() {
        return replies;
    }

    public void setReplies(Set<Comment> replies) {
        this.replies = replies;
    }
}
