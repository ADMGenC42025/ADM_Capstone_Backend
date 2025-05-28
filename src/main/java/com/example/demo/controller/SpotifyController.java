package com.example.demo.controller;

import com.example.demo.service.SpotifyTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyTokenService spotifyTokenService;

    @GetMapping("/token")
    public ResponseEntity<String> getAccessToken() {
        try {
            String token = spotifyTokenService.getAccessToken();
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}

