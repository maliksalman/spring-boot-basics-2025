package com.example.demo.hero;

import org.springframework.data.annotation.Id;

public record Hero(
        @Id String name,
        String secretIdentity,
        int age,
        String universe) {
}
