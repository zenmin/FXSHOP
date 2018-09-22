package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.User;
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
        String forObject = restTemplate.getForObject("http://FXSSOPROVIDER/msg/send/{1}", String.class, tel);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        return jsonObject;
    }


    public JSONObject checkUsername(String usernmae) {
        String forObject = restTemplate.getForObject("http://FXSSOPROVIDER/user/checkusername/{1}", String.class, usernmae);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        return jsonObject;
    }

    public JSONObject regUser(User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            String s = restTemplate.postForObject("http://FXSSOPROVIDER/user/reguser", user, String.class);
            jsonObject = JSONObject.parseObject(s);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            jsonObject.put("msg","注册失败！");
        }

        return jsonObject;
    }
}
