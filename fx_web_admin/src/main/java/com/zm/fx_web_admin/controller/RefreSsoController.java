package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_web_admin.service.RefreSsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
