package com.interview.task.service.counter.services.impl;

import com.interview.task.service.counter.model.*;
import com.interview.task.service.counter.services.CounterService;

import java.util.UUID;

public class CounterServiceImpl implements CounterService {
    private final CounterStorage storage;

    public CounterServiceImpl(CounterStorage storage) {
        this.storage = storage;
    }

    @Override
    public CounterCreateResponse createCounter() {
        var uniqueName = generateUniqueName();
        storage.add(uniqueName);
        return new CounterCreateResponse(uniqueName);
    }

    @Override
    public void updateCounter(String name, CounterUpdateRequest request) {
        storage.setValue(name, request.getCounter());
    }

    @Override
    public CounterValueResponse getCounterValue(String name) {
        return new CounterValueResponse(storage.getCounter(name));
    }

    @Override
    public void removeCounter(String name) {
        storage.remove(name);
    }

    @Override
    public TotalCountResponse getTotalCount() {
        return new TotalCountResponse(storage.getTotal());
    }

    @Override
    public CounterNamesResponse getCountersNames() {
        return new CounterNamesResponse(storage.getNames());
    }

    private String generateUniqueName() {
        return UUID.randomUUID().toString();
    }
}
