package com.interview.task.service.counter.api;

import com.interview.task.service.counter.model.*;
import com.interview.task.service.counter.services.CounterNotFoundException;
import com.interview.task.service.counter.services.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@RestController
public class CounterController {
    private Logger logger = LoggerFactory.getLogger(CounterController.class);
    private CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        logger.error("Exception occurred while handling http request", ex);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CounterNotFoundException.class)
    public final ResponseEntity<String> handleCounterNotFound(Exception ex, WebRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/counters")
    @ResponseStatus(HttpStatus.CREATED)
    public CounterCreateResponse createCounter() {
        return counterService.createCounter();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/counters/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String updateCounter(@PathVariable String name, @RequestBody CounterUpdateRequest request) {
        counterService.updateCounter(name, request);
        return "OK";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/counters/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String removeCounter(@PathVariable String name) {
        counterService.removeCounter(name);
        return "OK";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/counters/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CounterValueResponse getCounterValue(@PathVariable String name) {
        return counterService.getCounterValue(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/counters/total", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TotalCountResponse getAllCountersValues() {
        return counterService.getTotalCount();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/counters/names", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CounterNamesResponse getCountersNames() {
        return counterService.getCountersNames();
    }
}
