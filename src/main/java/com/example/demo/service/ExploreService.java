package com.example.demo.service;

import com.example.demo.dto.UploadedTrackDTO;
import com.example.demo.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExploreService {

    @Autowired
    private UploadRepository uploadRepository;

    public List<UploadedTrackDTO> searchUploadedTracks(String query) {
        return uploadRepository.searchUploadedTracks(query);
    }
}
