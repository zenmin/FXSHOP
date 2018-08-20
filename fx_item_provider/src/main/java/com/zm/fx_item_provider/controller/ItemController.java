package com.zm.fx_item_provider.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_item_provider.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Page findAll(Map<String,Object> params, String start, String size, String sort){
        return itemService.findAll(params,start,size,sort);
    }
    @GetMapping("/item/findbyid/{id}")
    public Item findAll(@PathVariable  String id){
        return itemService.findById(id);
    }

    @PostMapping("/item/update")
    public int findAll(@RequestBody Item item){
        return itemService.updateItem(item);
    }

    @DeleteMapping("/item/delete/{id}")
    public int delete(@PathVariable String id){
        int i = itemService.deleteById(id);
        return i;
    }

    @PutMapping("/item/add")
    public int add(@RequestBody Item item){
        int add = itemService.add(item);
        return add;
    }
}
