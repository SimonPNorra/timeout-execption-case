package com.example.timeoutexecptioncase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
@ConditionalOnProperty(value = "under-test", havingValue = "true")
public class TimeoutTestService {

    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public TimeoutTestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        RestTemplate restTemplate = restTemplateBuilder
                .connectTimeout(Duration.ofMillis(200))
                .readTimeout(Duration.ofMillis(200))
                .build();

        for (int i = 0; i < 100; i++) {
            try {
                restTemplate.getForEntity("http://localhost:8080/timeout", String.class);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getClass().getName());
            }
        }
    }
}
