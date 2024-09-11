package com.vibecart.gateway;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class APIGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIGateWayApplication.class, args);
    }
}