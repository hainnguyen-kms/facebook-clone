package com.example.facebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    List<FacebookLike> likes;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="parent_id", referencedColumnName = "id")
    List<Comment> replies;

    @OneToOne
    @JoinColumn(name="post_id", referencedColumnName = "id")
    @JsonIgnore
    private Post post;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public Comment() {
    }

    public Comment(UUID id, Date time, String text, List<FacebookLike> likes, List<Comment> replies) {
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

    public List<FacebookLike> getLikes() {
        return likes;
    }

    public void setLikes(List<FacebookLike> likes) {
        this.likes = likes;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
