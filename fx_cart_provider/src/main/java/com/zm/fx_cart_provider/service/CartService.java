package com.zm.fx_cart_provider.service;

import com.zm.fx_util_common.bean.Item;

import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/10/13 12:41
 */
public interface CartService {
    boolean addToCartToRedis(String userid,Item item);
    List<Item> queryCart(String userid);
    boolean updateToCartToRedis(String userid, Long itemid, Integer num);
    boolean deleteCartToRedis(Long userid, String itemid);
}
