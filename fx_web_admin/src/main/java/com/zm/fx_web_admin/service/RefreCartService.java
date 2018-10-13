package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/26 15:04
 */
@Service
public class RefreCartService {

    @Autowired
    RestTemplate restTemplate;

    public Item getItem(String userid, Long productid){
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/item/findbyidsimple/"+productid, String.class);//直接写提供者名称/rest接口调用远程服务
        Item item = JSONObject.parseObject(forObject, Item.class);
        return item;
    }

    //添加购物车信息到redis
    @Async
    public Boolean addToCartToRedis(String userid, Item item){
        try {
            restTemplate.put("http://FXCARTPROVIDER/cart/addToCartToRedis/"+userid, item,String.class);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Item> getCart(String userid) {
        JSONArray forObject = restTemplate.getForObject("http://FXCARTPROVIDER/cart/queryCart/{1}", JSONArray.class, userid);
        List<Item> items = forObject.toJavaList(Item.class);
        return items;
    }
}
