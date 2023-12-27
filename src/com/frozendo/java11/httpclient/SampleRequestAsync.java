package com.frozendo.java11.httpclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class SampleRequestAsync {

    private static final String GET_ENDPOINT = "https://postman-echo.com/get";

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(GET_ENDPOINT))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();

        HttpClient
                .newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Sample async response status = " + response.statusCode());
                    System.out.println("Sample async response body = " + response.body());
                    System.out.println("Sample async response final request = " + response.request());
                });

        Thread.sleep(5000);
    }

}
