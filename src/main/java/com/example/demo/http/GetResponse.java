package com.example.demo.http;

import java.util.Map;

public record GetResponse(
   String origin,
   String url,
   Args args,
   Map<String, String> headers
) {

    record Args(
            String foo
    ) {}

}
