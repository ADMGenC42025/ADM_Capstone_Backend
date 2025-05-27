package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "track_id")
    private Set<Track> tracks = new HashSet<>();



    public Playlist(){
        super();
    }

    public Playlist(Long id, Set<Track> track){
        this.id = id;
        this.tracks = track;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track){
        this.tracks.add(track);
    }

    public void deleteTrack(Track track){
        this.tracks.remove(track);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }




}
