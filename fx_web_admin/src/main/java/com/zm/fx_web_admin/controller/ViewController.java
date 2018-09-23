package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.zm.fx_util_common.bean.IndexContent;
import com.zm.fx_web_admin.service.RefreContentService;
import com.zm.fx_web_admin.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Describle This Class Is 视图控制层
 * @Author ZengMin
 * @Date 2018/8/9 20:30
 */
@Controller
public class ViewController {

    @Autowired
    RefreContentService contentService;
    @Autowired
    RedisTemplate redisTemplate;
    @Value("${USERPREFIX}")
    private String USERPREFIX;
    @Value("${COOKIEUSER}")
    private  String COOKIEUSER;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/admin/{page}")
    public String toPage(@PathVariable String page) {
        return "admin/" +page;
    }

    @GetMapping("/fxshop/{page}")
    public String toIndexPage(@PathVariable String page, Model model, HttpSession session,
                              HttpServletRequest request, HttpServletResponse response) {
        this.getUserMsg(model,session,request);
        return "fxshop/" +page;
    }

    @GetMapping("/")
    public String toIndex(Model model, HttpSession session, HttpServletRequest request) {
        String contentByPid = contentService.getContentByPid(2L);
        List<IndexContent> indexContents = JSONArray.parseArray(contentByPid, IndexContent.class);
        model.addAttribute("lbimg",indexContents);
        //右侧轮播
        String ylbs = contentService.getContentByPid(13L);
        List<IndexContent> indexContentList = JSONArray.parseArray(ylbs, IndexContent.class);
        model.addAttribute("ylbs",indexContentList);
        this.getUserMsg(model,session,request);
        return "fxshop/index";
    }

    //取单点登录用户信息
    public void getUserMsg(Model model,HttpSession session,HttpServletRequest request){
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
                System.out.println(o);
                //如果用户存在 放session里面
                session.setAttribute("user",o);
                model.addAttribute("user",o);
            }
        }
    }

}
