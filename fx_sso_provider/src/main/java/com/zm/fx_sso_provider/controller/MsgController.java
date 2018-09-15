package com.zm.fx_sso_provider.controller;

import com.zm.fx_sso_provider.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Describle This Class Is 短信接口
 * @Author ZengMin
 * @Date 2018/9/15 11:30
 */
@RestController
public class MsgController {

    @Autowired
    MsgService msgService;

    @GetMapping("/msg/send/{tel}")
    public Map<String,Object> sendMsg(@PathVariable String tel){
        Map<String, Object> map = msgService.sendMsg(tel);
        return map;
    }


}
