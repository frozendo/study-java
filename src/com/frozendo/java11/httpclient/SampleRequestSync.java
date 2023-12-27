package com.frozendo.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class SampleRequestSync {
    private static final String GET_ENDPOINT = "https://postman-echo.com/get";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(GET_ENDPOINT))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Sample sync response status = " + response.statusCode());
        System.out.println("Sample sync response body = " + response.body());
        System.out.println("Sample sync response final request = " + response.request());

    }

}
