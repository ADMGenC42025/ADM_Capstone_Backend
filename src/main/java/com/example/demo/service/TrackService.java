package com.example.demo.service;

import com.example.demo.model.RecentlyPlayed;
import com.example.demo.model.Track;
import com.example.demo.repository.RecentlyPlayedRepository;
import com.example.demo.repository.TrackRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrackService {

    @Autowired
    private TrackRepo trackRepository;
    
    @Autowired
    private RecentlyPlayedRepository recentlyPlayedRepository;


    @Transactional
    public Track saveTrack(Track track) {
        Optional<Track> existingTrackOpt = trackRepository.findBySongName(track.getSongName());
        Track savedTrack;

        if (existingTrackOpt.isPresent()) {
            Track existingTrack = existingTrackOpt.get();

            // Check and handle RecentlyPlayed
            if (recentlyPlayedRepository.existsByTrackId(existingTrack.getId())) {
                recentlyPlayedRepository.deleteByTrackId(existingTrack.getId());
            }

            // Re-add to RecentlyPlayed
            RecentlyPlayed rp = new RecentlyPlayed();
            rp.setTrack(existingTrack);
            recentlyPlayedRepository.save(rp);

            savedTrack = existingTrack;
        } else {
            // New track
            savedTrack = trackRepository.save(track);

            RecentlyPlayed rp = new RecentlyPlayed();
            rp.setTrack(savedTrack);
            recentlyPlayedRepository.save(rp);
        }

        return savedTrack;
    }



    public Track getTrackById(Long id) {
        return trackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Track not found with id: " + id));
    }
}
