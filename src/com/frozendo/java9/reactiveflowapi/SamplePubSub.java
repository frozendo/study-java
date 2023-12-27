package com.frozendo.java9.reactiveflowapi;

import com.frozendo.java9.reactiveflowapi.helpers.SamplePublisher;
import com.frozendo.java9.reactiveflowapi.helpers.SampleSubscriber;

public class SamplePubSub {

    public static void main(String[] args) {
        SamplePublisher publisher = new SamplePublisher(false);
        SampleSubscriber subscriber = new SampleSubscriber();
        publisher.subscribe(subscriber);
    }

}
