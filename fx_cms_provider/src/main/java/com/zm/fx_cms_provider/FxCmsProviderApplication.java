package com.zm.fx_cms_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zm.fx_dao_common.dao")
public class FxCmsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxCmsProviderApplication.class, args);
    }
}
