package com.example.demo.service;

import com.example.demo.model.RecentlyPlayed;
import com.example.demo.repository.RecentlyPlayedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecentlyPlayedService {

    @Autowired
    private RecentlyPlayedRepository recentlyPlayedRepository;

    public List<RecentlyPlayed> getAllRecentlyPlayed() {
        return recentlyPlayedRepository.findAll();
    }
}
