package com.example.demo.controller;

import com.example.demo.model.Playlist;
import com.example.demo.model.Track;
import com.example.demo.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/{playlistId}/tracks")
    public ResponseEntity<Track> addTrackToPlaylist(
            @PathVariable Long playlistId,
            @RequestBody Track track) {
        Track savedTrack = playlistService.addTrackToPlaylist(playlistId, track);
        return ResponseEntity.ok(savedTrack);
    }

    @GetMapping("/{playlistId}/tracks")
    public ResponseEntity<Set<Track>> getTracksByPlaylist(@PathVariable Long playlistId) {
        return ResponseEntity.ok(playlistService.getTracksByPlaylist(playlistId));
    }
}

