package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class MyConfigurations {

    @Bean
    public FirstValues firstValues(@Value("${my.text}") String aText,
                                   @Value("${my.number}") int aNum,
                                   @Value("${my.flag}") boolean aFlag,
                                   @Value("${my.ttl}") Duration aTtl) {
        return new FirstValues(aText, aNum, aFlag, aTtl);
    }

}
