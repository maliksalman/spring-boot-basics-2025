package com.example.demo.hero;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroRepository repository;

    public HeroController(HeroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Collection<Hero> listHeroes() {
        return repository.list();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Hero> findHeroByName(@PathVariable("name") String name) {
        Optional<Hero> optionalHero = repository.findByName(name);
        if (optionalHero.isPresent()) {
            return new ResponseEntity<>(optionalHero.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}/universe")
    public ResponseEntity<Universe> findUniverseByHeroName(@PathVariable("name") String name) {
        return repository.findUniverse(name)
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
