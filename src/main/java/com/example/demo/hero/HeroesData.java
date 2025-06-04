package com.example.demo.hero;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("data")
public record HeroesData(
        Map<String, Hero> heroes,
        Map<String, Universe> universes) {
}
