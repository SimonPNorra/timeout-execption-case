package com.example.timeoutexecptioncase;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WireMockExtension extends WireMockServer implements BeforeAllCallback, AfterAllCallback {

    public WireMockExtension() {
        super(wireMockConfig()
                .port(49111)
                .notifier(new Slf4jNotifier(true))
                .preserveHostHeader(true));
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        this.start();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        this.stop();
        this.resetAll();
    }
}
