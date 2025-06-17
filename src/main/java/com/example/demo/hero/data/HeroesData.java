package com.example.demo.hero.data;

import com.example.demo.hero.Hero;
import com.example.demo.hero.Universe;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("data")
public record HeroesData(
        Map<String, Hero> heroes,
        Map<String, Universe> universes) {
}
