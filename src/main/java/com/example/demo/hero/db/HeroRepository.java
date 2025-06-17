package com.example.demo.hero.db;

import com.example.demo.hero.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, String> {
}
