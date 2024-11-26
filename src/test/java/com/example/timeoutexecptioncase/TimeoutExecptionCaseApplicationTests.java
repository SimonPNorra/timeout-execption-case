package com.example.timeoutexecptioncase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
class TimeoutExecptionCaseApplicationTests {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RegisterExtension
    public static WireMockExtension WIRE_MOCK = new WireMockExtension();

    @Test
    void contextLoads() {
        RestTemplate restTemplate = restTemplateBuilder
                .connectTimeout(Duration.ofMillis(200))
                .readTimeout(Duration.ofMillis(200))
                .build();

        WIRE_MOCK.stubFor(get(urlPathMatching("/test"))
                .willReturn(ok("single").withFixedDelay(99999999)));

        for (int i = 0; i < 100; i++) {
            try {
                restTemplate.getForEntity("http://localhost:" + WIRE_MOCK.port() + "/test", String.class);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getClass().getName());
            }
        }
    }

}
