package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class SpotifyTokenService {

    private final String clientId = "be30edfb49da49d6a846516fa96d77e8";
    private final String clientSecret = "8b362d18c5034c68bf1174840db087c2";
    private final String refreshToken = "AQAP0TMfJtM2szn5yI4eLng54pH5b37Old_CtIyQSM36jZSb3GqvpioulMzx0kT_m0FA_PUXqGWM-cNhxh2pPSRkWFrZYgxQfn5rsJs-CYCkEucMUo2zxeO2aUqGWYZgGXo";

    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/spotify/token")
    public String getAccessToken() throws IOException {
        URL url = new URL("https://accounts.spotify.com/api/token");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String body = "grant_type=refresh_token"
                + "&refresh_token=" + URLEncoder.encode(refreshToken, "UTF-8")
                + "&client_id=" + URLEncoder.encode(clientId, "UTF-8")
                + "&client_secret=" + URLEncoder.encode(clientSecret, "UTF-8");

        try (OutputStream os = conn.getOutputStream()) {
            os.write(body.getBytes(StandardCharsets.UTF_8));
        }

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            InputStream errorStream = conn.getErrorStream();
            String errorMsg = new BufferedReader(new InputStreamReader(errorStream))
                .lines().collect(Collectors.joining("\n"));
            throw new IOException("Spotify token request failed: " + errorMsg);
        }

        InputStream responseStream = conn.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(responseStream);
        return node.get("access_token").asText();
    }
}
