package com.example.facebook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "abc";
    }
    @GetMapping("/home2")
    public String home2() {
        return "abc2";
    }
}
