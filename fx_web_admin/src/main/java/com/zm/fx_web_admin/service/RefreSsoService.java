package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/15 20:31
 */
@Service
public class RefreSsoService {

    @Autowired
    RestTemplate restTemplate;

    public JSONObject sendSms(String tel){
        String forObject = restTemplate.getForObject("http://FXSSOPROVIDER//msg/send/{1}", String.class, tel);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        return jsonObject;
    }




}
