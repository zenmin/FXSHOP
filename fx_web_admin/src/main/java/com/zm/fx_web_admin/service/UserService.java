package com.zm.fx_web_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/4 10:30
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public String toShop(){
        //实际上是调用了SHOPPROVIDER的rest请求
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/toshop", String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }
}
