package com.example.demo.hero.db;

import com.example.demo.hero.Hero;
import com.example.demo.hero.HeroService;
import com.example.demo.hero.Universe;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@Profile("db")
public class HeroDbService implements HeroService {

    private final HeroRepository heroRepository;
    private final UniverseRepository universeRepository;

    public HeroDbService(HeroRepository heroRepository, UniverseRepository universeRepository) {
        this.heroRepository = heroRepository;
        this.universeRepository = universeRepository;
    }

    @Override
    public Collection<Hero> list() {
        return heroRepository.findAll();
    }

    @Override
    public Optional<Hero> findByName(String name) {
        return heroRepository.findById(name);
    }

    @Override
    public Optional<Universe> findUniverse(String hero) {
        return findByName(hero)
                .map(h -> h.universe())
                .flatMap(u -> universeRepository.findById(u));
    }
}
