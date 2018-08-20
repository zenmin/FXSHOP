package com.zm.fx_item_provider;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.zm.fx_dao_common.dao")
public class FxItemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxItemProviderApplication.class, args);
    }
}
