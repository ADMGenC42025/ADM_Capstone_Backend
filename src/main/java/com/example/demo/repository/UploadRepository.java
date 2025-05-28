package com.example.demo.repository;

import com.example.demo.dto.UploadedTrackDTO;
import com.example.demo.model.Upload;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UploadRepository extends JpaRepository<Upload, Integer> {
    @Query("SELECT new com.example.demo.dto.UploadedTrackDTO(t.id, t.songName, t.uri, t.imageUrl, u.name, up.genre, up.dateReleased) " +
            "FROM Track t " +
            "JOIN Upload up ON t.id = up.trackId " +
            "JOIN User u ON up.authorId = u.id " +
            "WHERE LOWER(t.songName) LIKE LOWER(CONCAT('%', :query, '%'))")
     List<UploadedTrackDTO> searchUploadedTracks(@Param("query") String query);
	
}
