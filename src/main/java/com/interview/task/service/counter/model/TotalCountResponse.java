package com.interview.task.service.counter.model;

public class TotalCountResponse {
    private Long total;

    public TotalCountResponse(long total) {
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }
}
