package com.example.demo.hero;

import java.util.Collection;
import java.util.Optional;

public interface HeroService {

    Collection<Hero> list();

    Optional<Hero> findByName(String name);

    Optional<Universe> findUniverse(String hero);
}
