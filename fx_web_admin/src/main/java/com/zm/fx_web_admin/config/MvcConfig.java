package com.zm.fx_web_admin.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/9 20:42
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 定义不过controler的视图
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    /**
     * 定义访问后缀
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(false);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    @Bean
    public ServletRegistrationBean regDispatcherServlet(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(dispatcherServlet);
        registrationBean.addUrlMappings("*.html");  //处理页面请求
        registrationBean.addUrlMappings("*.do");    //处理资源请求
        registrationBean.addUrlMappings("/");
        return registrationBean;
    }

}
