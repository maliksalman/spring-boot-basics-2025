package com.example.demo.hero.data;

import com.example.demo.hero.Hero;
import com.example.demo.hero.HeroService;
import com.example.demo.hero.Universe;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@Profile("!db")
public class HeroDataService implements HeroService {

    private final HeroesData data;

    public HeroDataService(HeroesData data) {
        this.data = data;
    }

    @Override
    public Collection<Hero> list() {
        return data.heroes().values();
    }

    @Override
    public Optional<Hero> findByName(String name) {
        return Optional.ofNullable(data.heroes().get(name));
    }

    @Override
    public Optional<Universe> findUniverse(String hero) {
        return findByName(hero)
                    .map(h -> data.universes().get(h.universe()));
    }
}
