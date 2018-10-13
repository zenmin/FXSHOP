package com.zm.fx_cart_provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_cart_provider.service.CartService;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/10/6 10:49
 */
@Service
public class CartServiceImpl implements CartService {

    @Value("${CART}")
    private String CART;

    @Autowired
    RedisTemplate redisTemplate;

    public boolean addToCartToRedis(String userid,Item item){
        try {
            //  先检查Redis中本用户的本商品是否存在  存在加数量  不存在 添加
            ValueOperations cartops = redisTemplate.opsForValue();
            Object o = cartops.get(CART + userid + ":" + item.getId());
            if (o == null) {
                //不存在  添加
                item.setCartNum(1);
                item.setCartPrice(item.getPrice());
                cartops.set(CART + userid + ":" + item.getId(), JSONObject.toJSONString(item)); //此处放json  不然有坑
                return true;
            } else {
                //已经存在  加数量   算价格
                Item oldItem = JSONObject.parseObject(o.toString(), Item.class);
                int num = oldItem.getCartNum();
                num++;
                oldItem.setCartNum(num);
                oldItem.setCartPrice(oldItem.getPrice() * num);
                cartops.set(CART + userid + ":" + item.getId(), JSONObject.toJSONString(oldItem));
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Item> queryCart(String userid){
        //先取到所有商品信息的key
        Set keys = redisTemplate.keys(CART + userid + ":*");
        //批量获取购物车信息
        List<Object> list = redisTemplate.opsForValue().multiGet(keys);
        List<Item> result = new ArrayList<>();
        list.stream().forEach( o ->{
            Item items = JSONObject.parseObject(o.toString(), Item.class);
            result.add(items);
        });
        return result;
    }
}
