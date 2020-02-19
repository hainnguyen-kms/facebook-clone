package com.example.facebook.dto.request;

import java.util.UUID;

public class FriendRequestDTO {
    private UUID userId;
    private UUID friendId;

    public FriendRequestDTO() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getFriendId() {
        return friendId;
    }

    public void setFriendId(UUID friendId) {
        this.friendId = friendId;
    }

    public FriendRequestDTO(UUID userId, UUID friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }
}
