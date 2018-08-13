package com.zm.fx_item_provider.controller;

import com.zm.fx_item_provider.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/12 10:12
 */
@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/item/findall")
    public String findAll(Map<String,Object> params, String start, String size, String sort){
        return itemService.findAll(params,start,size,sort).toString();
    }

    @GetMapping("/top")
    public String top(Map<String,Object> params, String start, String size, String sort){
        return itemService.findAll(params,start,size,sort).toString();
    }
}
