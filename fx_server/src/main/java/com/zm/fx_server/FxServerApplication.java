package com.zm.fx_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FxServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxServerApplication.class, args);
    }
}
