package com.zm.fx_search_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableRabbit       //开启RabbitMQ注解扫描
@MapperScan("com.zm.fx_dao_common.dao")
@EnableCaching
public class FxSearchProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxSearchProviderApplication.class, args);
    }
}
