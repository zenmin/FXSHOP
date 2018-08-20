package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Describle This Class Is 商品接口调用Service
 * @Author ZengMin
 * @Date 2018/8/12 11:36
 */
@Service
public class RefreItemService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 查询全部
     * @param start
     * @param size
     * @param sort
     * @return
     */
    public String findAll(int start, int size, String sort){
        //实际上是调用了FX_ITEM_PROVIDER的rest请求
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/item/findall?start="+start+"&size="+size+"&sort="+sort, String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    public String findById(String id){
        //实际上是调用了FX_ITEM_PROVIDER的rest请求
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/item/findbyid/"+id, String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }

    /**
     * 更新商品
     * @param item
     * @return
     */
    public Boolean updateItem(Item item){
        item.setUpdated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //实际上是调用了FX_ITEM_PROVIDER的rest请求
        try {
            restTemplate.postForEntity("http://FXITEMPROVIDER/item/update", item, String.class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    public Boolean delete(String id){
        try {
            restTemplate.delete("http://FXITEMPROVIDER/item/delete/"+id, String.class);//直接写提供者名称/rest接口调用远程服务
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 根据id新增商品
     * @param item
     * @return
     */
    public Boolean add(Item item){
        item.setUpdated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            restTemplate.put("http://FXITEMPROVIDER/item/add", item);//直接写提供者名称/rest接口调用远程服务
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
