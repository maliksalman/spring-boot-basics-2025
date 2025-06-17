package com.example.demo.hero.db;

import com.example.demo.hero.Universe;
import org.springframework.data.repository.CrudRepository;

public interface UniverseRepository extends CrudRepository<Universe, String> {
}
