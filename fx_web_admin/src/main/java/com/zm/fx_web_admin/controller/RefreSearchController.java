package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/5 18:57
 */
@Controller
@RequestMapping("/item")
public class RefreSearchController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/search")
    public String searchPage(
            @RequestParam(value = "q",defaultValue = "") String q,
            @RequestParam(value = "page",required = false,defaultValue = "0") int page,
            @RequestParam(value = "size",required = false,defaultValue = "12") int size, Model model) {
        String forObject = restTemplate.getForObject("http://FXSEARCHPROVIDER/search?q={1}&page={2}&size={3}", String.class,q,page,size);
        JSONObject parse = (JSONObject) JSONObject.parse(forObject);

        model.addAttribute("data",parse.get("object"));
        parse.remove("object");
        model.addAttribute("page",parse);
        model.addAttribute("key",q);
        return "fxshop/product_list";
    }

    @GetMapping("/detail/{id}")
    public String searchDetail(@PathVariable Long id,Model model) {
        String forObject = restTemplate.getForObject("http://FXSEARCHPROVIDER/search/byid/{1}", String.class,id);
        Item item = JSONObject.parseObject(forObject, Item.class);
        //处理图片
        String imgurl = item.getImgurl();
        String mainImg = "";
        List<String> list = new ArrayList<>();
        if(imgurl.indexOf(",")!=-1){
            mainImg = imgurl.substring(0,imgurl.indexOf(","));
            String[] split = imgurl.split(",");
            for(String url : split){
                list.add(url);
            }
        }else{
            mainImg = imgurl;
        }
        model.addAttribute("mainImg",mainImg);
        model.addAttribute("imglist",list);
        model.addAttribute("data",item);
        return "fxshop/product_detailed";
    }

    @Test
    public void test1(){
        String a = "https://fxshopbucket.oss-cn-shenzhen.aliyuncs.com/F3D921535254373612.jpeg";
        System.out.println(a.length());
    }
}
