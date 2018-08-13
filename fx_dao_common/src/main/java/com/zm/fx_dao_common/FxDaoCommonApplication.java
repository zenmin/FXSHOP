package com.zm.fx_dao_common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zm.fx_dao_common.dao")
@SpringBootApplication
public class FxDaoCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxDaoCommonApplication.class, args);
    }
}
