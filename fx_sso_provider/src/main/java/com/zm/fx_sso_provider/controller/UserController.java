package com.zm.fx_sso_provider.controller;

import com.zm.fx_sso_provider.service.UserService;
import com.zm.fx_util_common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/16 20:21
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/checkusername/{usernmae}")
    public Map<String,Object> checkUsername(@PathVariable String usernmae){
        Map<String, Object> map = userService.checkUsername(usernmae);
        return map;
    }

    @PutMapping("/user/reguser")
    public Map<String,Object> regUser(User user){
        Map<String, Object> map = userService.regUser(user);
        return map;
    }

}
