package com.zm.fx_web_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient  //开启服务发现
@SpringBootApplication
public class FxWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxWebAdminApplication.class, args);
    }

    @LoadBalanced   //启用负载均衡 服务识别
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
