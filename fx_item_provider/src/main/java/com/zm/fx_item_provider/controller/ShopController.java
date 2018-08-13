package com.zm.fx_item_provider.controller;

import com.zm.fx_item_provider.service.impl.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/2 21:17
 */
@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/toshop")
    public String toShop(){
        String s = shopService.toShop();
        return s;
    }




}
