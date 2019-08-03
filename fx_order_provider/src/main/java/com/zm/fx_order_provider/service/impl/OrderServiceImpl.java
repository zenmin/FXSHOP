package com.zm.fx_order_provider.service.impl;

import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_dao_common.bean.Order;
import com.zm.fx_dao_common.bean.OrderItem;
import com.zm.fx_dao_common.dao.ItemMapper;
import com.zm.fx_dao_common.dao.OrderDetailMapper;
import com.zm.fx_dao_common.dao.OrderItemMapper;
import com.zm.fx_dao_common.dao.OrderMapper;
import com.zm.fx_order_provider.constant.OrderConstant;
import com.zm.fx_order_provider.service.OrderService;
import com.zm.fx_util_common.bean.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/11/18 14:47
 * @Company Matt
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    static NumberFormat numberFormat = NumberFormat.getNumberInstance();

    static {
        numberFormat.setMaximumFractionDigits(2);
    }

    @Override
    public boolean addOrder(OrderDetail orderDetail) {
        String itemid = orderDetail.getItemid();
        Double allPrice = 0.0;
        Map<String,Object> items = new HashMap<>();
        if (itemid.indexOf(",") != -1) {
            //取商品信息
            String[] itemIds = itemid.split(",");
            for (String i : itemIds) {
                //从购物车取订单信息


//                allPrice += item.getPrice();
//                items.put(i,item);
            }
        } else {
            //取商品信息
            Item item = itemMapper.selectByPrimaryKey(Long.valueOf(itemid));
            allPrice = item.getPrice();
            items.put(itemid,item);
        }

        Long userId = orderDetail.getUserid();

        //生成订单编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssmm");
        String dateMils = simpleDateFormat.format(new Date());
        String orderId = dateMils + "" + (int) (userId / 2) + "" + (int) (Math.random() * 1000);

        //保存订单表
        Order order = new Order();
        order.setId(Long.valueOf(orderId));
        order.setNowprice(allPrice);
        order.setAllprice(allPrice);
        order.setPayway(orderDetail.getType());
        order.setCreated(new Date());
        order.setStarttime(new Date());
        order.setStatus(OrderConstant.ORDER_CREATE);
        order.setUpdated(new Date());
        order.setUserid(userId);
        orderMapper.insertSelective(order);

        //订单详细表
        com.zm.fx_dao_common.bean.OrderDetail daoOd = new com.zm.fx_dao_common.bean.OrderDetail();
        daoOd.setCreated(new Date());
        daoOd.setOrderid(Long.valueOf(orderId));
        daoOd.setUserid(userId);
        daoOd.setUsername(orderDetail.getUsername());
        daoOd.setUseraddress(orderDetail.getAddressid());
        daoOd.setUserphone(orderDetail.getUserphone());
        daoOd.setCreated(new Date());
        orderDetailMapper.insert(daoOd);

        if (itemid.indexOf(",") != -1) {
            for (String itemId : itemid.split(",")) {
                //取单个商品信息
                Object o = items.get(itemId);
                Item item = (Item) o;

                OrderItem orderItem = new OrderItem();
                orderItem.setOrderid(Long.valueOf(orderId));
                orderItem.setAllpruce(allPrice);
                orderItem.setCreated(new Date());
                orderItem.setIsreceive(0);
                orderItem.setItemname(item.getName());
                orderItem.setImg(item.getImgurl());
                orderItem.setItemdesc(item.getDescrible());
                orderItem.setItemid(Long.valueOf(item.getId()));
                orderItem.setNum(0);    //从购物车取

            }
        }


        return false;
    }


    @Test
    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssmm");
        Long userId = 1231232131232L;
        String dateMils = simpleDateFormat.format(new Date());
        String temp = userId + "" + dateMils;
        System.out.println();


    }

}
