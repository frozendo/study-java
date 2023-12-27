package com.frozendo.java9.reactiveflowapi.helpers;

import java.util.concurrent.Flow;

public class SampleSubscriber implements Flow.Subscriber<String> {

    private int totalProcessed = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscription receive: " + subscription);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Receive item: " + item);
        totalProcessed++;
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on flow process");
        throwable.printStackTrace();
        System.out.println();
    }

    @Override
    public void onComplete() {
        System.out.println("Total items processed " + totalProcessed);
        System.out.println();
    }
}
