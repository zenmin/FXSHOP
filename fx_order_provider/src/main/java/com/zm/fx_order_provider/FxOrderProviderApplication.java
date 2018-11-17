package com.zm.fx_order_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FxOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxOrderProviderApplication.class, args);
    }
}
