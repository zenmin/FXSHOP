package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import com.zm.fx_util_common.bean.UserCart;
import com.zm.fx_web_admin.service.RefreCartService;
import com.zm.fx_web_admin.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describle This Class Is 购物车
 * @Author ZengMin
 * @Date 2018/9/26 15:04
 */
@RestController
@RequestMapping("/cart")
public class RefreCartController {

    @Autowired
    RefreCartService refreCartService;

    @Value("${COOKIECART}")
    private String COOKIECART;

    @PostMapping("/add")
    public JSONObject addToCart(String userid, Long productid, HttpServletResponse response, HttpServletRequest request){
        Item item = refreCartService.addToCart(userid, productid);
        item.setItemDeatil(null);
        item.setItemCategory(null);
        /**
         * 异步任务  添加购物车信息到redis
         */
         refreCartService.addToCartToRedis(userid, item);
        /**
         * Cookie 购物车操作
         * *******************************8
         */
        JSONObject jsonObject = new JSONObject();
        if(item == null){
            jsonObject.put("code","500");
            jsonObject.put("msg","添加失败，商品不存在，可能已经下架，请刷新页面！");
            return jsonObject;
        }
        String cookieValue = CookieUtils.getCookieValue(request, COOKIECART,"UTF-8");
        if(StringUtils.isEmpty(cookieValue)){
            //为空  新增cookie 信息
            UserCart userCart = new UserCart();
            userCart.setUserid(userid);
            List<Item> list = new ArrayList<>();
            item.setCartNum(1);
            item.setCartPrice(item.getPrice());
            list.add(item);
            userCart.setItems(list);
            String userCartJson = JSONObject.toJSONString(userCart);
            CookieUtils.setCookie(request,response,COOKIECART,userCartJson,-1,"UTF-8");
        }else{
            //如果不为空
            UserCart userCart = JSONObject.parseObject(cookieValue, UserCart.class);
            List<Item> items = userCart.getItems();
            Item temp = new Item();          //准备一个item

            //遍历Cookie
            for(Item i : items){
                //如果购物车中该商品已经存在  加数量 变价格
                if(i.getId().toString().equals(productid.toString())){
                    temp = i;
                    Integer cartNum = temp.getCartNum();
                    cartNum++;
                    temp.setCartNum(cartNum);
                    temp.setCartPrice(temp.getPrice()*cartNum);
                    items.remove(i);
                    items.add(temp);
                    userCart.setItems(items);
                    String userCartJson = JSONObject.toJSONString(userCart);
                    CookieUtils.setCookie(request,response,COOKIECART,userCartJson,-1,"UTF-8");
                    jsonObject.put("200","添加成功！");
                    return jsonObject;
                }
            }
            //如果不存在  直接add
            item.setCartPrice(item.getPrice());
            item.setCartNum(1);
            items.add(item);
            userCart.setItems(items);
            String userCartJson = JSONObject.toJSONString(userCart);
            CookieUtils.setCookie(request,response,COOKIECART,userCartJson,-1,"UTF-8");
            jsonObject.put("200","添加成功！");
        }
        return jsonObject;
    }
}
