package com.zm.fx_order_provider.controller;

import com.zm.fx_order_provider.service.OrderService;
import com.zm.fx_util_common.bean.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/11/18 14:46
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/addOrder")
    public Map<String,String> addOrder(@RequestBody OrderDetail orderDetail){
        boolean b = orderService.addOrder(orderDetail);
        return null;
    }

}
