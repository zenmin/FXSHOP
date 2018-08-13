package com.zm.fx_web_admin.controller;

import com.zm.fx_web_admin.service.RefreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
    public String findAll(){
       return refreItemService.findAll();
    }

}
