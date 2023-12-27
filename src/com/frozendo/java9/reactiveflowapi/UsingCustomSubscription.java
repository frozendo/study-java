package com.frozendo.java9.reactiveflowapi;

import com.frozendo.java9.reactiveflowapi.helpers.OwnSubPublisher;
import com.frozendo.java9.reactiveflowapi.helpers.SampleProcessor;
import com.frozendo.java9.reactiveflowapi.helpers.SampleSubscriber;

public class UsingCustomSubscription {

    public static void main(String[] args) throws InterruptedException {
        OwnSubPublisher<Integer> publisher = new OwnSubPublisher<>();
        SampleSubscriber subscriber = new SampleSubscriber();
        SampleProcessor processor = new SampleProcessor();
        publisher.subscribe(processor);
        processor.subscribe(subscriber);

        for (int i = 1; i <= 10; i++) {
            publisher.submit(i);
        }

        Thread.sleep(2000);
    }

}
