package com.example.demo.http;

import com.example.demo.hero.Universe;

import java.util.List;
import java.util.Map;

public record PostResponse(
    List<Universe> json,
    Map<String, String> headers) { }
