package com.zm.fx_web_admin.controller;

import com.zm.fx_web_admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/4 10:33
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toshop")
    public String toShop(){
       return userService.toShop();
    }
}
