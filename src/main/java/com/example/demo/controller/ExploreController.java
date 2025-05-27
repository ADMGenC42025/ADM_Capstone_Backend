package com.example.demo.controller;

import com.example.demo.dto.UploadedTrackDTO;
import com.example.demo.service.ExploreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/explore")
@CrossOrigin(origins = "http://localhost:4200")
public class ExploreController {

    @Autowired
    private ExploreService exploreService;

    @GetMapping("/search-uploaded")
    public List<UploadedTrackDTO> searchUploadedTracks(@RequestParam String query) {
        return exploreService.searchUploadedTracks(query);
    }
}
