package com.example.facebook.model;

import com.example.facebook.util.LikeStatus;
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
}
