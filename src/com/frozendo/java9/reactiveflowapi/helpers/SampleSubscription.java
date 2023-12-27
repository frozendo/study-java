package com.frozendo.java9.reactiveflowapi.helpers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Flow;

public class SampleSubscription<T> implements Flow.Subscription {
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
