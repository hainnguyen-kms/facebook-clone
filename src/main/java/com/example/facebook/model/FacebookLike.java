package com.example.facebook.model;

import com.example.facebook.util.LikeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class FacebookLike {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    private LikeStatus type;
    private Date time;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name="post_id", referencedColumnName = "id")
    @JsonIgnore
    private Post post;

    @OneToOne
    @JoinColumn(name="image_id", referencedColumnName = "id")
    @JsonIgnore
    private Image image;

    @OneToOne
    @JoinColumn(name="comment_id", referencedColumnName = "id")
    @JsonIgnore
    private Comment comment;

    public FacebookLike() {
    }

    public FacebookLike(UUID id, LikeStatus type, Date time) {
        this.id = id;
        this.type = type;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LikeStatus getType() {
        return type;
    }

    public void setType(LikeStatus type) {
        this.type = type;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @PostPersist
    void initLike() {
        time = new Date();
    }
}
