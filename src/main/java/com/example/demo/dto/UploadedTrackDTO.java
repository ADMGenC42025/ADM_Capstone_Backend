package com.example.demo.dto;

import java.util.Date;

public class UploadedTrackDTO {
	
    private Long trackId;
    private String songName;
    private String uri;
    private String imageUrl;
    private String authorName;
    private String genre;
    private Date dateReleased;
    
    public UploadedTrackDTO() {}

    public UploadedTrackDTO(Long trackId, String songName, String uri, String imageUrl, String authorName, String genre, Date dateReleased) {
        this.trackId = trackId;
        this.songName = songName;
        this.uri = uri;
        this.imageUrl = imageUrl;
        this.authorName = authorName;
        this.genre = genre;
        this.dateReleased = dateReleased;
    }

    // Getters and setters
    public Long getTrackId() { return trackId; }
    public void setTrackId(Long trackId) { this.trackId = trackId; }

    public String getSongName() { return songName; }
    public void setSongName(String songName) { this.songName = songName; }

    public String getUri() { return uri; }
    public void setUri(String uri) { this.uri = uri; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Date getDateReleased() { return dateReleased; }
    public void setDateReleased(Date dateReleased) { this.dateReleased = dateReleased; }
	
    
}
