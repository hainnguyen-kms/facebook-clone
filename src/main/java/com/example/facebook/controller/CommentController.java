package com.example.facebook.controller;

import com.example.facebook.dto.request.CommentRequest;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.model.User;
import com.example.facebook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/replies/{commentId}")
    ResponseEntity likePostById(@PathVariable UUID commentId, @RequestBody @Valid CommentRequest replyRequest, @AuthenticationPrincipal User sessionUser) {
        return ResponseEntity.ok(
            new SuccessRequestResponse(null, HttpServletResponse.SC_OK, commentService.replyComment(commentId, replyRequest, sessionUser))
        );
    }
}
