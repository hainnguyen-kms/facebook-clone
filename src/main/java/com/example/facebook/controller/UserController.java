package com.example.facebook.controller;

import com.example.facebook.dto.request.FriendRequestDTO;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.model.User;
import com.example.facebook.service.UserService;
import com.example.facebook.util.FriendRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/friend-request")
    public ResponseEntity requestFriend(@RequestBody FriendRequestDTO friendRequestData, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, userService.requestFriend(friendRequestData, sessionUser))
        );
    }
    @PostMapping("/friend-request/accept")
    public ResponseEntity accept(@RequestBody FriendRequestDTO friendRequestData, @AuthenticationPrincipal User sessionUser) {
        userService.actionFriendRequest(friendRequestData, sessionUser, FriendRequestStatus.ACCEPT);
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, "Success")
        );
    }
    @PostMapping("/friend-request/reject")
    public ResponseEntity reject(@RequestBody FriendRequestDTO friendRequestData, @AuthenticationPrincipal User sessionUser) {
        userService.actionFriendRequest(friendRequestData, sessionUser, FriendRequestStatus.REJECT);
        return ResponseEntity.ok(
                new SuccessRequestResponse(null, HttpServletResponse.SC_OK, "Success")
        );
    }
}
