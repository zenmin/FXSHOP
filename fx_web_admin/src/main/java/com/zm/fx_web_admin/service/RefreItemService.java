package com.zm.fx_web_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/12 11:36
 */
@Service
public class RefreItemService {

    @Autowired
    RestTemplate restTemplate;

    public String findAll(){
        //实际上是调用了FX_ITEM_PROVIDER的rest请求
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/item/findall", String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }
}
