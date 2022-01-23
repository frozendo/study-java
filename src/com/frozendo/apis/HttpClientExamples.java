package com.frozendo.apis;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class HttpClientExamples {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClientExamples execute = new HttpClientExamples();
        execute.sampleRequestSync();
        execute.sampleRequestAsync();

        execute.tryHttpVersion2();
        execute.arrayByteBodyHandler();

        execute.postSample();
        execute.postByteArrayProcessor();
        execute.putSample();

        execute.authenticationSync();
        execute.authenticationAsync();
    }

    private void sampleRequestSync() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Sample Sync Request #####");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandler.asString());

        System.out.println("Sample sync request status = " + response.statusCode());
        System.out.println("Sample sync request body = " + response.body());
        System.out.println("Sample sync request final request = " + response.finalRequest());

        System.out.println();
    }

    private void sampleRequestAsync() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Sample Async Request #####");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();

        HttpClient
                .newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandler.asString())
                .thenAccept(response -> {
                    System.out.println("Sample async request status = " + response.statusCode());
                    System.out.println("Sample async request body = " + response.body());
                    System.out.println("Sample async request final request = " + response.finalRequest());
                });

        Thread.sleep(1200);

        System.out.println();
    }

    private void tryHttpVersion2() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Try use http version 2 #####");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandler.asString());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response version = " + response.version());

        System.out.println();
    }

    private void arrayByteBodyHandler() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Byte Array Body Handler #####");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();

        HttpResponse<byte[]> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandler.asByteArray());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body array = " + response.body());

        System.out.println();
    }

    private void postSample() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Post Sample #####");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .timeout(Duration.ofSeconds(60))
                .POST(HttpRequest.BodyProcessor.fromString("Request body!"))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandler.asString());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + response.body());

        System.out.println();
    }

    private void postByteArrayProcessor() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Post Byte Array Processor #####");

        String body = "Request Body!";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .timeout(Duration.ofSeconds(60))
                .POST(HttpRequest.BodyProcessor.fromByteArray(body.getBytes(StandardCharsets.UTF_8)))
                .build();

        HttpResponse<byte[]> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandler.asByteArray());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + new String(response.body(), StandardCharsets.UTF_8));

        System.out.println();
    }

    private void putSample() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Put Sample #####");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/put"))
                .timeout(Duration.ofSeconds(60))
                .PUT(HttpRequest.BodyProcessor.fromString("Request body!"))
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .send(request, HttpResponse.BodyHandler.asString());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + response.body());

        System.out.println();
    }

    private void authenticationSync() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("##### Authentication async example #####");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/basic-auth"))
                .timeout(Duration.ofSeconds(60))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "postman",
                                "password".toCharArray());
                    }
                }).build()
                .send(request, HttpResponse.BodyHandler.asString());

        System.out.println("Request status = " + response.statusCode());
        System.out.println("Response body = " + response.body());

        System.out.println();
    }

    private void authenticationAsync() throws InterruptedException, URISyntaxException {
        System.out.println("##### Authentication async example #####");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/basic-auth"))
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
                .sendAsync(request, HttpResponse.BodyHandler.asString())
                .thenAccept(response -> {
                    System.out.println("Sample async request status = " + response.statusCode());
                    System.out.println("Sample async request body = " + response.body());
                });

        Thread.sleep(1200);

        System.out.println();
    }

}
