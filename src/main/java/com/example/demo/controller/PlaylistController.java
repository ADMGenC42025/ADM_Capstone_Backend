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
    public ResponseEntity<Track> addTrackToPlaylist(@PathVariable Long id, @RequestBody Track track) {
        Track savedTrack = playlistService.addTrackToPlaylist(id, track);
        return ResponseEntity.ok(savedTrack);
    }

    @GetMapping("/{playlistId}/tracks")
    public ResponseEntity<Set<Track>> getTracksByPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getTracksByPlaylist(id));
    }

    @PostMapping("/addPlaylist")
    public ResponseEntity<Playlist> addEmptyPlaylistWithTitle(@RequestParam String playlistTitle){
        return ResponseEntity.ok(playlistService.createNewPlaylist(playlistTitle));
    }

}

