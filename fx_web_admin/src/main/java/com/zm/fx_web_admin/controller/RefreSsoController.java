package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.User;
import com.zm.fx_web_admin.service.RefreSsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/15 20:28
 */
@Controller
@RequestMapping("/sso")
public class RefreSsoController {

    @Autowired
    RefreSsoService refreSsoService;

    @GetMapping("/sendmsg/{tel}")
    @ResponseBody
    public JSONObject sendSms(@PathVariable String tel, HttpSession sessions){
        JSONObject jsonObject = refreSsoService.sendSms(tel);
        return jsonObject;
    }

    @GetMapping("/checkUsername/{usernmae}")
    @ResponseBody
    public JSONObject checkUsername(@PathVariable String usernmae){
        JSONObject jsonObject = refreSsoService.checkUsername(usernmae);
        return jsonObject;
    }

    @PutMapping("/reguser")
    @ResponseBody
    public JSONObject regUser(User user){
        System.out.println(user);
        JSONObject jsonObject = refreSsoService.regUser(user);
        return jsonObject;
    }

}
