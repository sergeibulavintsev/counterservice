package com.interview.task.service.counter.model;

public class CounterValueResponse {
    private final long value;

    public CounterValueResponse(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
