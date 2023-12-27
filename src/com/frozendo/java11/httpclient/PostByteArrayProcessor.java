package com.frozendo.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class PostByteArrayProcessor {

    private static final String POST_ENDPOINT = "https://postman-echo.com/post";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String body = "Request Body!";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(POST_ENDPOINT))
                .timeout(Duration.ofSeconds(60))
                .POST(HttpRequest.BodyPublishers.ofByteArray(body.getBytes(StandardCharsets.UTF_8)))
                .build();

        HttpResponse<byte[]> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandlers.ofByteArray());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + new String(response.body(), StandardCharsets.UTF_8));
    }

}
