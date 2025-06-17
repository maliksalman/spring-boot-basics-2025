package com.example.demo.hero.db;

import com.example.demo.hero.Hero;
import com.example.demo.hero.HeroService;
import com.example.demo.hero.Universe;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class HeroDbService implements HeroService {

    @Override
    public Collection<Hero> list() {
        return List.of();
    }

    @Override
    public Optional<Hero> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Universe> findUniverse(String hero) {
        return Optional.empty();
    }
}
