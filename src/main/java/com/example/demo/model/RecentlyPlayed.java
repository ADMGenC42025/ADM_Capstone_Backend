package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RecentlyPlayed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @ManyToOne
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

	public RecentlyPlayed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecentlyPlayed(Long id, Track track) {
		super();
		this.id = id;
		this.track = track;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public String toString() {
		return "RecentlyPlayed [id=" + id + ", track=" + track + "]";
	}
    
}