package com.zm.fx_web_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/9 20:30
 */
@Controller
public class ViewController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }

    @GetMapping("/top")
    @ResponseBody
    public String top(){
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/top", String.class);
        return  forObject;
    }
}
