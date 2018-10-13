package com.zm.fx_cart_provider.controller;

import com.zm.fx_cart_provider.service.impl.CartServiceImpl;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Describle This Class Is 购物车处理controller
 * @Author ZengMin
 * @Date 2018/10/6 10:49
 */
@RestController
public class CartController {

    @Autowired
    CartServiceImpl cartService;

    @PutMapping("/cart/addToCartToRedis/{userid}")
    public boolean addToCartToRedis(@PathVariable String userid,@RequestBody Item item){
        boolean b = cartService.addToCartToRedis(userid, item);
        return b;
    }

    //根据用户id查询购物车信息
    @GetMapping("/cart/queryCart/{userid}")
    public List<Item> queryCart(@PathVariable String userid){
        List<Item> userCarts = cartService.queryCart(userid);
        return userCarts;
    }
}
