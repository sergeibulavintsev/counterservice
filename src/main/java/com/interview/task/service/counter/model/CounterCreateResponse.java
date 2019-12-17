package com.interview.task.service.counter.model;

public class CounterCreateResponse {
    private String name;

    public CounterCreateResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
