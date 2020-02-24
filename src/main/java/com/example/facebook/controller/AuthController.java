package com.example.facebook.controller;

import com.example.facebook.dto.request.AuthenticationRequest;
import com.example.facebook.dto.response.SuccessRequestResponse;
import com.example.facebook.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
        return ResponseEntity.ok(new SuccessRequestResponse(
                null, HttpServletResponse.SC_OK, authService.signin(data)
        ));
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody AuthenticationRequest data) {
        return ResponseEntity.ok(new SuccessRequestResponse(
                null, HttpServletResponse.SC_CREATED, authService.signup(data)
        ));
    }
}