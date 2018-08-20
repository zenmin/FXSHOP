package com.zm.fx_item_provider.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/6/18 11:08
 */
@Configuration
@Component
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //配置druid监控访问的servlet
    @Bean
    public ServletRegistrationBean duridServlet(){
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","admin");
        servletRegistrationBean.setInitParameters(map);
        System.out.println("DruidServlet已就位...");
        return servletRegistrationBean;
    }

    //配置druid监控的filter
    @Bean
    public FilterRegistrationBean druidFlilter(){
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("exclusions","*.js,*.html,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(stringStringMap);
        System.out.println("DruidFilter已就位...");
        return filterRegistrationBean;
    }


}
