package com.interview.task.service.counter.config;

import com.interview.task.service.counter.services.CounterService;
import com.interview.task.service.counter.services.impl.CounterServiceImpl;
import com.interview.task.service.counter.services.impl.CounterStorage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    private static final int DEFAULT_PORT = 8080;

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            factory.setPort(DEFAULT_PORT);
            factory.setContextPath("/v1");
        };
    }

    @Bean
    public CounterStorage counterStorage() {
        return new CounterStorage();
    }

    @Bean
    public CounterService counterService(CounterStorage storage) {
        return new CounterServiceImpl(storage);
    }
}
