package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import com.zm.fx_util_common.bean.UserCart;
import com.zm.fx_web_admin.service.RefreCartService;
import com.zm.fx_web_admin.service.ViewService;
import com.zm.fx_web_admin.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Describle This Class Is 购物车
 * @Author ZengMin
 * @Date 2018/9/26 15:04
 */
@Controller
@RequestMapping("/cart")
public class RefreCartController {

    @Autowired
    RefreCartService refreCartService;

    @Value("${COOKIECART}")
    private String COOKIECART;

    @Autowired
    ViewService viewService;

    @PostMapping("/add")
    @ResponseBody
    public JSONObject addToCart(String userid, Long productid, HttpServletResponse response, HttpServletRequest request){
        Item item = refreCartService.getItem(userid, productid);
        JSONObject jsonObject = new JSONObject();
        if(item == null){
            jsonObject.put("code","500");
            jsonObject.put("msg","添加失败，商品不存在，可能已经下架，请刷新页面！");
            return jsonObject;
        }
        item.setItemDeatil(null);
        item.setItemCategory(null);
        //处理图片
        String imgurl = item.getImgurl();
        if(imgurl.indexOf(",") == 0){
            imgurl = imgurl.substring(1,imgurl.length());
            item.setImgurl(imgurl);
        }
        if(imgurl.indexOf(",")!=-1){
            String[] split = imgurl.split(",");
            item.setImgurl(split[0].replace(",",""));
        }
        /**
         * 异步任务  添加购物车信息到redis
         */
         refreCartService.addToCartToRedis(userid, item);
        /**
         * Cookie 购物车操作
         * *******************************8
         */
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
            jsonObject.put("code","200");
            jsonObject.put("msg","添加成功！");
        }else{
            //如果不为空
            UserCart userCart = JSONObject.parseObject(cookieValue, UserCart.class);
            List<Item> items = userCart.getItems();
            Item temp;          //准备一个item
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
                    jsonObject.put("code","200");
                    jsonObject.put("msg","添加成功！");
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
            jsonObject.put("code","200");
            jsonObject.put("msg","添加成功！");
        }
        return jsonObject;
    }

    //从redis中获取购物车信息  防止用户清掉Cookie
    @GetMapping("/queryCart/{userid}")
    @ResponseBody
    public List<Item> queryCart(@PathVariable String userid, HttpServletResponse response, HttpServletRequest request){
        List<Item> list =  refreCartService.getCart(userid);
        //如果服务器上购物车信息存在
        if(list.size() >0){
            UserCart userCart = new UserCart();
            userCart.setItems(list);
            userCart.setUserid(userid);
            String userCartJson = JSONObject.toJSONString(userCart);
            //同步Cookie和服务器购物车数据
            CookieUtils.setCookie(request,response,COOKIECART,userCartJson,-1,"UTF-8");
        }
        return list;
    }

    @GetMapping("/toCart")
    public String toCart(Model model, HttpSession session,HttpServletRequest request){
        //取用户信息
        viewService.getUserMsg(model,session,request);
        Object user = session.getAttribute("user");
        if(user == null){
            model.addAttribute("errorMsg","登录已经失效 请重新登录!");
            return "/fxshop/login";
        }else{
            JSONObject user1 = JSONObject.parseObject(user.toString());
            String cookieValue = CookieUtils.getCookieValue(request, COOKIECART,"UTF-8");
            //如果不为空
            UserCart userCart = JSONObject.parseObject(cookieValue, UserCart.class);
            if(userCart.getUserid().equals(user1.get("id").toString())){
                //是此用户的购物车
                List<Item> items = userCart.getItems();
                model.addAttribute("cart",items);
            }else{
                //从redis取当前用户购物车
                List<Item> list =  refreCartService.getCart(user1.get("id").toString());
                //如果服务器上购物车信息存在
                if(list.size() >0){
                    model.addAttribute("cart",list);
                }else{
                    model.addAttribute("errorMsg","购物车信息不存在！");
                    return "/";
                }
            }
            return "fxshop/shop_cart";
        }
    }

    /**
     * @param session
     * @param request
     * @param type 1加减 2删除
     * @return
     */
    @PostMapping("/udpateCart")
    @ResponseBody
    public boolean updateCart(HttpSession session,HttpServletResponse response,HttpServletRequest request,Integer type,Long itemid,Integer num){
        String cookieValue = CookieUtils.getCookieValue(request, COOKIECART,"UTF-8");
        UserCart userCart = JSONObject.parseObject(cookieValue, UserCart.class);
        String userid = userCart.getUserid();
        List<Item> items = userCart.getItems();
        switch (type){
             case 1:
                 List<Item> newCookieItem = new ArrayList<>();
                 items.stream().forEach( o ->{
                     Long id = o.getId();
                     if(itemid.equals(id)){
                         Double price = o.getPrice();
                         o.setCartNum(num);
                         o.setCartPrice(price * num);
                         refreCartService.updateToCartToRedis(userid,itemid,num);//更新服务器商品数量
                     }
                     newCookieItem.add(o);
                 });
                 userCart.setItems(newCookieItem);



                 break;
             case 2:

                 break;
         }

        String userCartJson = JSONObject.toJSONString(userCart);
        CookieUtils.setCookie(request,response,COOKIECART,userCartJson,-1,"UTF-8");
        return true;
    }
}
