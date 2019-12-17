package com.interview.task.service.counter.model;

public class CounterUpdateRequest {
    private long counter;

    public CounterUpdateRequest() {
    }

    public CounterUpdateRequest(long value) {
        this.counter = value;
    }

    public long getCounter() {
        return counter;
    }
}
