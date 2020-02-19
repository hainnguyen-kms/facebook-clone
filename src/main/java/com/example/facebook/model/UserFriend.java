package com.example.facebook.model;

import com.example.facebook.util.FriendRequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="user_friends")
@IdClass(UserFriendId.class)
public class UserFriend {
    @Id
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", columnDefinition = "BINARY(16)")
    @JsonIgnore
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="friend_id", referencedColumnName = "id", columnDefinition = "BINARY(16)")
    @JsonIgnore
    private User friend;

    @Column(name = "is_accepted")
    @Enumerated(EnumType.STRING)
    private FriendRequestStatus isAccepted;

    public UserFriend() {
    }

    public UserFriend(User user, User friend, FriendRequestStatus isAccepted) {
        this.user = user;
        this.friend = friend;
        this.isAccepted = isAccepted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public FriendRequestStatus getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(FriendRequestStatus isAccepted) {
        this.isAccepted = isAccepted;
    }
}
