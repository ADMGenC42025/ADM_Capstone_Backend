package com.example.demo.controller;

import com.example.demo.model.RecentlyPlayed;
import com.example.demo.service.RecentlyPlayedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recently-played")
@CrossOrigin(origins = "http://localhost:4200")
public class RecentlyPlayedController {

    @Autowired
    private RecentlyPlayedService recentlyPlayedService;

    // Get all recently played
    @GetMapping
    public List<RecentlyPlayed> getAllRecentlyPlayed() {
        return recentlyPlayedService.getAllRecentlyPlayed();
    }
}
