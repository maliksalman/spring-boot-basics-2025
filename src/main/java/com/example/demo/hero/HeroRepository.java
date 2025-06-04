package com.example.demo.hero;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class HeroRepository {

    private final HeroesData data;

    public HeroRepository(HeroesData data) {
        this.data = data;
    }

    public Collection<Hero> list() {
        return data.heroes().values();
    }

    public Optional<Hero> findByName(String name) {
        return Optional.ofNullable(data.heroes().get(name));
    }

    public Optional<Universe> findUniverse(String hero) {
        return findByName(hero)
                    .map(h -> data.universes().get(h.universe()));
    }
}
