package com.example.demo.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpConfig {

    @Bean
    public RestClient restClient(RestClient.Builder builder, @Value("${httpbin.base-url}") String baseUrl) {
        return builder
                .baseUrl(baseUrl)
                .build();
    }
}
