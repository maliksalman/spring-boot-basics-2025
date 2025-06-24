package com.example.demo.hero.db;

import com.example.demo.hero.Hero;
import org.springframework.data.repository.ListCrudRepository;

public interface HeroRepository extends ListCrudRepository<Hero, String> {
}
