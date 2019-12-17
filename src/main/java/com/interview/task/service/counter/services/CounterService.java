package com.interview.task.service.counter.services;

import com.interview.task.service.counter.model.*;

public interface CounterService {
    CounterCreateResponse createCounter();
    void updateCounter(String name, CounterUpdateRequest request);
    CounterValueResponse getCounterValue(String name);
    void removeCounter(String name);
    TotalCountResponse getTotalCount();
    CounterNamesResponse getCountersNames();
}
