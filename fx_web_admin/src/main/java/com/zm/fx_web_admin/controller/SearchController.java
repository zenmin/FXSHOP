package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/5 18:57
 */
@Controller
@RequestMapping("/item")
public class SearchController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/search")
    public String searchPage(String q,int page, int size, Model model) {
        String forObject = restTemplate.getForObject("http://FXSEARCHPROVIDER/search?q={1}&page={2}&size={3}", String.class,q,page,size);
        Object parse = JSONObject.parse(forObject);
        model.addAttribute("data",parse);
        System.out.println(parse);
        return "fxshop/product_list";
    }
}
