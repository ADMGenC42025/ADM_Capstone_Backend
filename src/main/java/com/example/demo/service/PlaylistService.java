package com.example.demo.service;

import com.example.demo.model.Playlist;
import com.example.demo.model.Track;
import com.example.demo.repository.PlaylistRepo;
import com.example.demo.repository.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class PlaylistService {

    private final PlaylistRepo playlistRepo;

    @Autowired
    public PlaylistService(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }

    public Track addTrackToPlaylist(Long playlistId, Track track) {
        Playlist playlist = playlistRepo.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        playlist.addTrack(track);
        playlistRepo.save(playlist); // cascade saves the track too
        return track;
    }

    public Set<Track> getTracksByPlaylist(Long playlistId) {
        Playlist playlist = playlistRepo.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        return playlist.getTracks();
    }

    public void deleteTrackFromPlaylist(Long playlistId, Track track){
        Playlist playlist = playlistRepo.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("PlayList not found"));

        playlist.deleteTrack(track);
        playlistRepo.save(playlist);
    }
}

