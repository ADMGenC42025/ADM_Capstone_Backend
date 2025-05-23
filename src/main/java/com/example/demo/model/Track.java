package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class Track {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String songName;
	private String artistName;
	private String album;
	private String uri;
	private String imageUrl;
	
	public Track() {
		super();
	}

	public Track(long id, String songName, String artistName, String album, String uri, String imageUrl) {
		super();
		this.id = id;
		this.songName = songName;
		this.artistName = artistName;
		this.album = album;
		this.uri = uri;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", songName=" + songName + ", artistName=" + artistName + ", album=" + album
				+ ", uri=" + uri + ", imageUrl=" + imageUrl + "]";
	}

}
