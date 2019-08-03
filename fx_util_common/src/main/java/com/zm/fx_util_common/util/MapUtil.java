package com.zm.fx_util_common.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/12/8 14:57
 * @Company Matt
 */
@Component
public class MapUtil {

    public static Map<String,Object> packMap(String k,Object v){
        Map<String,Object> map = new HashMap<>();
        map.put(k,v);
        return map;
    }

    public static Map<String,Object> ResponseSuccess(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","成功");
        return map;
    }


    public static Map<String,Object> ResponseError(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","成功");
        return map;
    }

    public static Map<String,Object> ResponseError(int code,String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }


}
