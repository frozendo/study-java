package com.frozendo.java9.reactiveflowapi;

import com.frozendo.java9.reactiveflowapi.helpers.SampleProcessor;
import com.frozendo.java9.reactiveflowapi.helpers.SampleSubscriber;

import java.util.concurrent.SubmissionPublisher;

public class PubSubWithProcessor {

    public static void main(String[] args) {
        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
            SampleSubscriber subscriber = new SampleSubscriber();
            SampleProcessor processor = new SampleProcessor();
            publisher.subscribe(processor);
            processor.subscribe(subscriber);

            for (int i = 1; i <= 10; i++) {
                publisher.submit(i);
            }

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
