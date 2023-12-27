package com.frozendo.java9.reactiveflowapi.helpers;

import java.util.concurrent.Flow;

public class OwnSubPublisher<Integer> implements Flow.Publisher<Integer> {

    private SampleSubscription<Integer> subscription;

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscription = new SampleSubscription<>(subscriber);
        subscriber.onSubscribe(subscription);
    }

    public void submit(Integer value) {
        subscription.emit(value);
    }
}
