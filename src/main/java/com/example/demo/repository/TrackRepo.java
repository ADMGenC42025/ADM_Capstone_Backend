package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Track;

public interface TrackRepo extends JpaRepository<Track, Long>{

	Optional<Track> findBySongName(String songName);

}
