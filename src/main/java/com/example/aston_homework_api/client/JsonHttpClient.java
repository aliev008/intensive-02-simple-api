package com.example.aston_homework_api.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class JsonHttpClient {
    private static final String DOG_API_URL = "https://dog.ceo/api/breeds/list/all";
    private static final String CAT_API_URL = "'https://api.thecatapi.com/v1/images/search";

    public String getPets(String petType) {
        String url = petType.equals("dog") ? DOG_API_URL : CAT_API_URL;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
