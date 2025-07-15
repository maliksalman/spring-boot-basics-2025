package com.example.demo.http;

import com.example.demo.hero.Universe;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class RestClientService {

    private final RestClient restClient;

    public RestClientService(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * When you want to perform a GET operation and retrieve the body
     */
    public GetResponse doGetOperation() {
        return restClient.get()
                .uri("/get?foo=bar")
                .header("MyHeader01", "value01")
                .header("MyHeader02", "value02")
                .retrieve()
                .body(GetResponse.class);
    }

    /**
     * When you want to perform a POST operation by posting some JSON and
     * retrieve the body
     */
    public PostResponse doPostOperation() {
        return restClient.post()
                .uri("/post")
                .header("MyHeader01", "value01")
                .header("MyHeader02", "value02")
                .contentType(MediaType.APPLICATION_JSON)
                .body(List.of(new Universe("mcu", true), new Universe("dc", false)))
                .retrieve()
                .body(PostResponse.class);
    }

    /**
     * When you want to retrieve not just the body but also
     * http-status-code, and response headers
     */
    public void doOperationAndDealWithEntity() {

        ResponseEntity<PostResponse> entity = restClient.post()
                .uri("/post")
                .header("MyHeader01", "value01")
                .header("MyHeader02", "value02")
                .contentType(MediaType.APPLICATION_JSON)
                .body(List.of(new Universe("mcu", true), new Universe("dc", false)))
                .retrieve()
                .toEntity(PostResponse.class);

        // get the body and do something with it
        PostResponse body = entity.getBody();

        // get the status code and check for different HTTP response code
        HttpStatusCode statusCode = entity.getStatusCode();

        // get the headers and extract information from it
        HttpHeaders headers = entity.getHeaders();
    }

    /**
     * When you want to retrieve just the http-status-code and
     * response headers but don't care of response body
     */
    public void doOperationAndDealWithBodilessEntity() {

        ResponseEntity<Void> bodilessEntity = restClient.post()
                .uri("/post")
                .header("MyHeader01", "value01")
                .header("MyHeader02", "value02")
                .contentType(MediaType.APPLICATION_JSON)
                .body(List.of(new Universe("mcu", true), new Universe("dc", false)))
                .retrieve()
                .toBodilessEntity();

        // should be false
        boolean hasBody = bodilessEntity.hasBody();

        // get the status code and check for different HTTP response code
        HttpStatusCode statusCode = bodilessEntity.getStatusCode();

        // get the headers and extract information from it
        HttpHeaders headers = bodilessEntity.getHeaders();
    }

    /**
     * Dealing with various HTTP response status codes in a fluent API for
     * corner cases
     */
    public void doOperationWithFluentStatusProcessing() {
        PostResponse response = restClient.post()
                .uri("/post")
                .header("MyHeader01", "value01")
                .header("MyHeader02", "value02")
                .contentType(MediaType.APPLICATION_JSON)
                .body(List.of(new Universe("mcu", true), new Universe("dc", false)))
                .retrieve()
                .onStatus(s -> s.value() == 404, (req, resp) -> {
                    throw new RuntimeException(); // usually a custom exception is thrown
                })
                .onStatus(s -> s.value() == 503, (req, resp) -> {
                    throw new RuntimeException(); // usually a custom exception is thrown
                })
                .body(PostResponse.class);

        // do something with the response object
    }
}
