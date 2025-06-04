package com.example.demo.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties("first")
public record FirstValues(
        String text,
        int number,
        boolean flag,
        Duration ttl) {
}
