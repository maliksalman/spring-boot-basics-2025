package com.example.demo.hero;

import org.springframework.data.annotation.Id;

public record Universe(
        @Id String name,
        boolean fictionalCities) {
}
