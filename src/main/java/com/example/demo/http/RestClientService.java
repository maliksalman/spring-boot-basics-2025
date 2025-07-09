package com.example.demo.http;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RestClientService {

    private final RestClient restClient;

    public RestClientService(RestClient restClient) {
        this.restClient = restClient;
    }

    public GetResponse doGetOperation() {
        return restClient.get()
                .uri("https://httpbin.org/get?foo=bar")
                .header("MyHeader01", "value01")
                .header("MyHeader02", "value02")
                .retrieve()
                .body(GetResponse.class);
    }
}
