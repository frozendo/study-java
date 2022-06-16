package com.frozendo.apis;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveFlowExamples {

    public static void main(String[] args) throws InterruptedException {
        ReactiveFlowExamples execute = new ReactiveFlowExamples();
        execute.samplePubSub();
        execute.samplePubSubWhenErrorOccur();
        execute.pubSubWithProcessor();

        execute.usingCustomSubscription();
    }

    private void samplePubSub() {
        SamplePublisher publisher = new SamplePublisher(false);
        SampleSubscriber subscriber = new SampleSubscriber();
        publisher.subscribe(subscriber);
    }

    private void samplePubSubWhenErrorOccur() {
        SamplePublisher publisher = new SamplePublisher(true);
        SampleSubscriber subscriber = new SampleSubscriber();
        publisher.subscribe(subscriber);
    }

    private void pubSubWithProcessor() {
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

    private void usingCustomSubscription() throws InterruptedException {
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

    private static class SamplePublisher implements Flow.Publisher<String> {

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

    private static class SampleSubscriber implements Flow.Subscriber<String> {

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

    private static class SampleProcessor implements Flow.Processor<Integer, String> {

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

    private static class OwnSubPublisher<Integer> implements Flow.Publisher<Integer> {

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

    private static class SampleSubscription<T> implements Flow.Subscription {
        private final List<T> list;
        private final Flow.Subscriber<? super T> subscriber;

        private int index;
        private Thread subThread;

        public SampleSubscription(Flow.Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
            this.list = new LinkedList<>();
            this.index = 0;
        }

        @Override
        public void request(long n) {
            Runnable runnable = () -> {
                if (index < list.size()) {
                    long requested = n + index;
                    while (index < requested) {
                        T value = getItem();
                        subscriber.onNext(value);
                        index++;
                    }
                } else {
                    subscriber.onComplete();
                }
            };
            subThread = new Thread(runnable);
            if (!list.isEmpty()) {
                subThread.start();
            }
        }

        private T getItem() {
            T item = list.get(index);
            if (Objects.isNull(item)) {
                item = getItem();
            }
            return item;
        }

        @Override
        public void cancel() {
            subThread.interrupt();
        }

        public void emit(T item) {
            list.add(item);
            if (Objects.nonNull(subThread) && !subThread.isAlive()) {
                subThread.start();
            }
        }
    }

}
