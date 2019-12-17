package com.interview.task.service.counter.services.impl;

import com.interview.task.service.counter.services.CounterNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

class TestCounterStorage {
    private CounterStorage storage;

    @BeforeEach
    void init() {
        storage = new CounterStorage();
    }

    @Test
    void testUpdateCounter() {
        var name = "test";
        storage.add(name);
        storage.setValue(name, 10L);
        assertEquals(10L, storage.getCounter(name));
    }

    @Test
    void testGetTotalCount() {
        var test1 = "Test1";
        var test2 = "Test2";
        storage.add(test1);
        storage.add(test2);
        storage.setValue(test1, 10L);
        storage.setValue(test2, 30L);
        assertEquals(40L, storage.getTotal());
    }

    @Test
    void testGetNames() {
        var test1 = "Test1";
        var test2 = "Test2";
        storage.add(test1);
        storage.add(test2);
        assertEquals(List.of(test1, test2), storage.getNames());
    }

    @Test
    void testRemoveCounter() {
        var test1 = "test1";
        storage.add(test1);
        storage.remove(test1);
        assertEquals(0, storage.getNames().size());
    }

    @Test
    void testRemoveNonExistingCounter() {
        assertThrows(CounterNotFoundException.class, () -> storage.remove("aaaa"));
    }
}
