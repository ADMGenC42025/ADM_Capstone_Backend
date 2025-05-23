package com.example.demo.repository;

import com.example.demo.model.RecentlyPlayed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentlyPlayedRepository extends JpaRepository<RecentlyPlayed, Long> {
	
	boolean existsByTrackId(Long trackId);

	void deleteByTrackId(Long trackId);
	
}