package com.example.demo.hero;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class HeroRepository {

    private final Map<String, Hero> heroes;

    public HeroRepository() {
        heroes = new HashMap<>();
        heroes.put("superman", new Hero("superman", "Clark Kent", 35, "dc"));
        heroes.put("batman", new Hero("batman", "Bruce Wayne", 50, "dc"));
        heroes.put("flash", new Hero("flash", "Barry Allen", 20, "dc"));
    }

    public Collection<Hero> list() {
        return heroes.values();
    }

    public Optional<Hero> findByName(String name) {
        return Optional.ofNullable(heroes.get(name));
    }

    public Optional<Universe> findUniverse(String hero) {
        return findByName(hero)
                    .map(h -> new Universe(h.universe(), true));
    }
}
