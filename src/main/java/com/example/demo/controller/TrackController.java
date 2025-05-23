package com.example.demo.controller;

import com.example.demo.model.Track;
import com.example.demo.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tracks")
@CrossOrigin(origins = "http://localhost:4200") // allow frontend access
public class TrackController {

    @Autowired
    private TrackService trackService;

    // End point to save a new track
    @PostMapping
    public Track saveTrack(@RequestBody Track track) {
        return trackService.saveTrack(track);
    }

    //Get track by ID
    @GetMapping("/{id}")
    public Track getTrack(@PathVariable Long id) {
        return trackService.getTrackById(id);
    }
}
