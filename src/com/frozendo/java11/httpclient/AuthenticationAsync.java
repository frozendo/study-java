package com.frozendo.java11.httpclient;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AuthenticationAsync {

    private static final String AUTH_ENDPOINT = "https://postman-echo.com/basic-auth";

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(AUTH_ENDPOINT))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();
        HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "postman",
                                "password".toCharArray());
                    }
                }).build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Sample async request status = " + response.statusCode());
                    System.out.println("Sample async request body = " + response.body());
                });

        Thread.sleep(5000);
    }

}
