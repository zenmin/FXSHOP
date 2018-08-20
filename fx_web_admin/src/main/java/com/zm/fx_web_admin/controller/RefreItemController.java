package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import com.zm.fx_web_admin.service.RefreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describle This Class Is 商品服务
 * @Author ZengMin
 * @Date 2018/8/12 11:33
 */
@RestController
@RequestMapping("/item")
public class RefreItemController {

    @Autowired
    RefreItemService refreItemService;

    @GetMapping("/findall")
    public JSONObject findAll(int start, int size, @RequestParam(value = "sort",required = false) String sort){
        String all = refreItemService.findAll(start,size,sort);
        JSONObject jsonObject = JSONObject.parseObject(all);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    @GetMapping("/findbyid/{id}")
    public JSONObject findAll(@PathVariable String id){
        String all = refreItemService.findById(id);
        JSONObject jsonObject = JSONObject.parseObject(all);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 更新商品
     * @param item
     * @return
     */
    @PostMapping("/update")
    public JSONObject findAll(Item item){
        JSONObject jsonObject = new JSONObject();
        Boolean aBoolean = refreItemService.updateItem(item);
        if(aBoolean){
            jsonObject.put("status","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("status","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public JSONObject delete(@PathVariable String id){
        JSONObject jsonObject = new JSONObject();
        Boolean delete = refreItemService.delete(id);
        if(delete){
            jsonObject.put("status","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("status","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 新增商品
     * @param item
     * @return
     */
    @PutMapping("/add")
    public JSONObject add(Item item){
        JSONObject jsonObject = new JSONObject();
        Boolean delete = refreItemService.add(item);
        if(delete){
            jsonObject.put("status","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("status","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }
}
