package com.zm.fx_web_admin.controller;

import com.zm.fx_util_common.bean.OrderDetail;
import com.zm.fx_web_admin.service.RefreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/11/18 12:27
 * @Company Matt
 */
@Controller
@RequestMapping("/order")
public class RefreOrderController {

    @Autowired
    RefreOrderService refreOrderServcie;

    @GetMapping("/address")
    public String toOrderAddress(@RequestParam String ids, Model model,String userid){
        model.addAttribute("ids",ids);
        model.addAttribute("userid",userid);
        return "fxshop/order_address";
    }

    @PostMapping("/addOrder")
    @ResponseBody
    public Map<String,String> addOrder(OrderDetail orderDetail){
        refreOrderServcie.addOrder(orderDetail);
        return null;
    }
}
