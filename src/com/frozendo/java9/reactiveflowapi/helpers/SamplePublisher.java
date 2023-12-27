package com.frozendo.java9.reactiveflowapi.helpers;

import java.util.UUID;
import java.util.concurrent.Flow;

public class SamplePublisher  implements Flow.Publisher<String> {

    private final boolean simulateError;

    public SamplePublisher(boolean simulateError) {
        this.simulateError = simulateError;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        System.out.println("##### Producing 10 random strings with SamplePublisher #####");
        try {
            for (int x = 1; x <= 10; x++) {
                if (simulateError && x > 3) {
                    throw new IllegalArgumentException("Error on publish new message");
                }
                String uuid = generateCode();
                System.out.println("UUID generate on publisher " + uuid);
                subscriber.onNext("Item number " + x + " : " + uuid);
            }
            System.out.println("Call on complete");
            subscriber.onComplete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            subscriber.onError(e);
        }


    }

    private String generateCode() {
        return UUID.randomUUID().toString();
    }

}
