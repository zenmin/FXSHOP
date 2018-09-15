package com.zm.fx_sso_provider.service;

import com.zm.fx_sso_provider.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Describle This Class Is 短信接口
 * @Author ZengMin
 * @Date 2018/9/15 11:30
 */
@Service
public class MsgService {

    @Autowired
    SendSms sendSms;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Value("${MSGPREFIX}")  //redis key前缀
    private String MSGPREFIX;
    @Value("${MSGPTIMEREFIX}")
    private String MSGPTIMEREFIX;   //超时验证前缀


    public Map<String,Object> sendMsg(String tel){
    ValueOperations valueOperations = redisTemplate.opsForValue();
        Map<String,Object> map = new HashMap<>();
        //后端校验60秒内是否发送过短信 防止无限请求接口
        Long expire = redisTemplate.getExpire(MSGPTIMEREFIX + tel);
        if(expire == -2){
            //发送短信
            int send = sendSms.send(tel);
            valueOperations.set(MSGPREFIX + tel,send);      //验证码有效期5分钟
            valueOperations.set(MSGPTIMEREFIX + tel,send);  //设置超时60s


            redisTemplate.expire(MSGPTIMEREFIX + tel,60,TimeUnit.SECONDS);  //60s后过期
            redisTemplate.expire(MSGPREFIX + tel,5,TimeUnit.MINUTES);  //5分钟后过期
            map.put("code","200");
            map.put("msg","短信发送成功");
        }else{
            map.put("code","500");
            map.put("msg","你在60秒内已经发送过短信，请稍后再试！");
        }
        return map;
    }
}
