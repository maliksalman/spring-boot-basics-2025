package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    private final FirstValues firstValues;
    private final Resource gibberish;

    public ConfigController(FirstValues firstValues,
                            @Value("${my.gibberish}") Resource gibberish) {
        this.firstValues = firstValues;
        this.gibberish = gibberish;
    }

    @GetMapping("/first")
    public FirstValues firstValues() {
        return firstValues;
    }

    @GetMapping("/gibberish")
    public String gibberish() throws IOException {
        byte[] byteArray = gibberish.getContentAsByteArray();
        return new String(byteArray);
    }
}
