package com.zm.fx_sso_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zm.fx_dao_common.dao")
public class FxSsoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxSsoProviderApplication.class, args);
    }
}
