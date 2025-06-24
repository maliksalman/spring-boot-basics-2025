package com.example.demo.hero.db;

import com.example.demo.hero.Universe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface UniverseRepository extends ListCrudRepository<Universe, String> {
}
