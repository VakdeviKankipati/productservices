package com.vakya.productservicesfeb29.configs;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ApplicationConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate createRestTemplate(){

        return new RestTemplate();
    }
}
