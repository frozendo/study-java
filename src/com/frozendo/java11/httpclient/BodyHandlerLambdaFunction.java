package com.frozendo.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class BodyHandlerLambdaFunction {

    private static final String POST_ENDPOINT = "https://postman-echo.com/post";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(POST_ENDPOINT))
                .timeout(Duration.ofSeconds(60))
                .POST(HttpRequest.BodyPublishers.ofString("Request Body"))
                .build();

        var response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, responseInfo -> {
                    if (responseInfo.statusCode() == 200) {
                        return HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);
                    }
                    return null;
                });

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + response.body());
    }

}
