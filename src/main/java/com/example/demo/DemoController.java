package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {
    
    @GetMapping("/hello")
    public Message sayHello(@RequestParam("subject") String name) {
        return new Message("Hello, " + name, new Date());
    }

    @GetMapping("/path/{subject}")
    public Message handlePath(@PathVariable("subject") String name) {
        return new Message("Hello, " + name, new Date());
    }

    @PostMapping("/post")
    public Message postSomething(@RequestBody NameAge entity) {
       
        return new Message(entity.name(), new Date());
    }
    
}
