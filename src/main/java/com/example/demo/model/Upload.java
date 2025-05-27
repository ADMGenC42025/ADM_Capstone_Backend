package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "upload")
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "track_id")
    private Long trackId;
    
//    @Column(name ="song_name" )
//    private String songName;



	@Lob
    @Column(name = "audio_file")
    private byte[] audioFile;

    private String genre;

    @Column(name = "date_released")
    private Date dateReleased;

    // Getters and setters
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getAuthorId() { return authorId; }

    public void setAuthorId(String authorId) { this.authorId = authorId; }

    public Long getTrackId() { return trackId; }

    public void setTrackId(Long trackId) { this.trackId = trackId; }

    public byte[] getAudioFile() { return audioFile; }

    public void setAudioFile(byte[] audioFile) { this.audioFile = audioFile; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public Date getDateReleased() { return dateReleased; }

    public void setDateReleased(Date dateReleased) { this.dateReleased = dateReleased; }
    
//    public String getSongName() {
//		return songName;
//	}
//
//	public void setSongName(String songName) {
//		this.songName = songName;
//	}
}
