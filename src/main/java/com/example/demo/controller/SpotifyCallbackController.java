package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyCallbackController {

    @GetMapping("/api/spotify/callback")
    public String handleSpotifyCallback(@RequestParam("code") String code) {
        // You can log it or return it to paste into curl
        System.out.println("🎉 Received Spotify code: " + code);
        return "Authorization code received: " + code;
    }
}
