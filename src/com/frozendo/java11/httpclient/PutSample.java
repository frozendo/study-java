package com.frozendo.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PutSample {

    private static final String PUT_ENDPOINT = "https://postman-echo.com/put";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(PUT_ENDPOINT))
                .PUT(HttpRequest.BodyPublishers.ofString("Request body!"))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(60))
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + response.body());
    }

}
