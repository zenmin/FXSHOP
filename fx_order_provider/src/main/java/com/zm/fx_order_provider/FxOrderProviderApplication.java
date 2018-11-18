package com.zm.fx_order_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zm.fx_dao_common.dao")
public class FxOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxOrderProviderApplication.class, args);
    }
}
