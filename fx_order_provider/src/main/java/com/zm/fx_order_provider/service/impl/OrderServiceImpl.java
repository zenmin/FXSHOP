package com.zm.fx_order_provider.service.impl;

import com.zm.fx_dao_common.dao.OrderMapper;
import com.zm.fx_order_provider.service.OrderService;
import com.zm.fx_util_common.bean.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/11/18 14:47
 * @Company Matt
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean addOrder(OrderDetail orderDetail) {
        return false;
    }
}
