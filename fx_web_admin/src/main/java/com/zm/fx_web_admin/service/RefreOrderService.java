package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/11/18 12:27
 * @Company Matt
 */
@Service
public class RefreOrderService {

    @Autowired
    RestTemplate restTemplate;

    public void addOrder(OrderDetail orderDetail) {
        String result = restTemplate.postForObject("http://FXORDERROVIDER/order/addOrder", orderDetail, String.class);
        HashMap hashMap = JSONObject.parseObject(result, HashMap.class);
    }
}
