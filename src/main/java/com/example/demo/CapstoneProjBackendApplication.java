package com.example.demo;

import com.example.demo.controller.PlaylistController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CapstoneProjBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CapstoneProjBackendApplication.class, args);
		PlaylistController playlistController = (PlaylistController) context.getBean("playlistController");

		playlistController.addEmptyPlaylistWithTitle("Omer's Playlist #1");
	}

}
