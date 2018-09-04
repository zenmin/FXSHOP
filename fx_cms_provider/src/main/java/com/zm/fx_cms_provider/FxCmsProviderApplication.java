package com.zm.fx_cms_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zm.fx_dao_common.dao")
@EnableCaching
public class FxCmsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxCmsProviderApplication.class, args);
    }
}
