package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/26 15:04
 */
@Service
public class RefreCartService {

    @Autowired
    RestTemplate restTemplate;

    public Item addToCart(String userid, Long productid){
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/item/findbyidsimple/"+productid, String.class);//直接写提供者名称/rest接口调用远程服务
        Item item = JSONObject.parseObject(forObject, Item.class);
        return item;
    }

    //添加购物车信息到redis
    @Async
    public String addToCartToRedis(String userid, Item item){
        String forObject = restTemplate.postForObject("http://FXCARTPROVIDER/addToCartToRedis", item,String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }
}
