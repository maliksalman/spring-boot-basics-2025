package com.example.demo.hero.data;

import com.example.demo.hero.Hero;
import com.example.demo.hero.Universe;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

import java.util.Map;

@ConfigurationProperties("data")
@Profile("!db")
public record HeroesData(
        Map<String, Hero> heroes,
        Map<String, Universe> universes) {
}
