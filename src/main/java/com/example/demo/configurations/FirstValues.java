package com.example.demo.configurations;

import java.time.Duration;

public record FirstValues(
        String myText,
        int myNumber,
        boolean myFlag,
        Duration ttl) {
}
