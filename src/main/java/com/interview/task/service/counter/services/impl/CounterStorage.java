package com.interview.task.service.counter.services.impl;

import com.interview.task.service.counter.services.CounterNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CounterStorage {
    private final ConcurrentHashMap<String, AtomicLong> counters = new ConcurrentHashMap<>();

    public void add(String name) {
        counters.put(name, new AtomicLong());
    }

    public void setValue(String name, long value) {
        var counter = counters.get(name);
        if (counter == null) {
            throw new CounterNotFoundException();
        }
        counter.addAndGet(value);
    }

    public long getCounter(String name) {
        var counter = counters.get(name);
        if (counter == null) {
            throw new CounterNotFoundException();
        }
        return counter.get();
    }

    public void remove(String name) {
        if (counters.remove(name) == null) {
            throw new CounterNotFoundException();
        }
    }

    public long getTotal() {
        return counters.values()
                .stream()
                .mapToLong(AtomicLong::get)
                .sum();
    }

    public List<String> getNames() {
        return Collections.list(counters.keys());
    }

}
