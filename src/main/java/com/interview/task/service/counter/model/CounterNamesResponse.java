package com.interview.task.service.counter.model;

import java.util.List;

public class CounterNamesResponse {
    private List<String> uniqueNames;

    public CounterNamesResponse(List<String> names) {
        this.uniqueNames = names;
    }

    public List<String> getUniqueNames() {
        return uniqueNames;
    }
}
