package com.frozendo.java9.reactiveflowapi.helpers;

import java.util.concurrent.Flow;

public class SampleProcessor implements Flow.Processor<Integer, String> {

    private final int qtdToRequest;

    private Flow.Subscriber<? super String> subscriber;

    private Flow.Subscription subscription;
    private int qtdProcessed;
    private int totalProcessed;

    public SampleProcessor() {
        this.qtdToRequest = 5;
        this.qtdProcessed = 0;
        this.totalProcessed = 0;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscription received, request " + qtdToRequest + " items");
        subscription.request(qtdToRequest);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Number " + item + " received in processor, change and call subscriber");
        String itemProcess = "The number received was: " + item;
        subscriber.onNext(itemProcess);
        qtdProcessed++;
        totalProcessed++;

        if (qtdProcessed >= qtdToRequest) {
            System.out.println();
            System.out.println("Total requested items processed. Requesting for more");
            qtdProcessed = 0;
            subscription.request(qtdToRequest);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Items processed by processor " + totalProcessed);
        subscriber.onComplete();
        this.subscription = null;
    }
}
