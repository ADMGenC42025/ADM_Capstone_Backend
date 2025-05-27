package com.example.demo.repository;

import com.example.demo.model.Playlist;
import com.example.demo.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist, Long> {

    public List<Playlist> getAllPlaylist();

    public Playlist getPlayListByPlaylistID(long playlistID);

    public void addSongToPlaylist(Track tempTrack);

    public void removeSongToPlaylist(Track tempTrack);
}
