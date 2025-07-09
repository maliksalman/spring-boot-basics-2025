package com.example.demo.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/http")
public class HttpController {

    private final RestClientService service;

    public HttpController(RestClientService service) {
        this.service = service;
    }

    @GetMapping
    public GetResponse doGetOperation() {
        return service.doGetOperation();
    }

}
