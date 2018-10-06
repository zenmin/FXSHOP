package com.zm.fx_cart_provider.service;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/10/6 10:49
 */
@Service
public class CartService {

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
}
