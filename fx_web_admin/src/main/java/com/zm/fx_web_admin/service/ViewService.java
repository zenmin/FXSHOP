package com.zm.fx_web_admin.service;

import com.alibaba.fastjson.JSONArray;
import com.zm.fx_web_admin.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/10/14 10:58
 */
@Service
public class ViewService {

    @Autowired
    RedisTemplate redisTemplate;
    @Value("${USERPREFIX}")
    private String USERPREFIX;
    @Value("${COOKIEUSER}")
    private  String COOKIEUSER;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //取单点登录用户信息
    public void getUserMsg(Model model, HttpSession session, HttpServletRequest request){
        //取用户信息  先取 session中的
        Object user = session.getAttribute("user");
        if(user != null){
            model.addAttribute("user",user);
        }else{
            //再从Redis里面取
            String userid = CookieUtils.getCookieValue(request, COOKIEUSER);
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            String s = stringStringValueOperations.get(USERPREFIX + userid);
            if(!StringUtils.isEmpty(s)){
                JSONArray objects = JSONArray.parseArray(s);
                Object o = objects.get(1);
                //如果用户存在 放session里面
                session.setAttribute("user",o);
                model.addAttribute("user",o);
            }
        }
    }

}
