package com.zm.fx_cart_provider.controller;

import com.zm.fx_cart_provider.service.CartService;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle This Class Is 购物车处理controller
 * @Author ZengMin
 * @Date 2018/10/6 10:49
 */
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PutMapping("/cart/addToCartToRedis/{userid}")
    public boolean addToCartToRedis(@PathVariable String userid,@RequestBody Item item){
        boolean b = cartService.addToCartToRedis(userid, item);
        return b;
    }


}
