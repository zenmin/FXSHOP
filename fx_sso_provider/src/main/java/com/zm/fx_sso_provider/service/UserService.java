package com.zm.fx_sso_provider.service;

import com.zm.fx_dao_common.bean.User;
import com.zm.fx_dao_common.dao.UserMapper;
import com.zm.fx_util_common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/16 20:22
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Value("${MSGPREFIX}")
    private String MSGPREFIX;

    @Value("${USERPREFIX}")

    private String USERPREFIX;

    public Map<String,Object> checkUsername(String usernmae) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        map.put("username",usernmae);
        List<User> users = userMapper.selectByMap(map);
        if(users.size()>0){
            result.put("code","500");
            result.put("msg","用户名已经存在！");
        }else{
            result.put("code","200");
            result.put("msg","用户名可用！");
        }
        return result;
    }

    public Map<String,Object> regUser(com.zm.fx_util_common.bean.User user) {
        Map<String,Object> map = new HashMap<>();
        //先检查验证码是否正确
        ValueOperations valueOperations =  redisTemplate.opsForValue();
        Object code = valueOperations.get(MSGPREFIX + user.getPhone());
        if(code == null){
            map.put("code","500");
            map.put("msg","验证码失效！");
            return map;
        }
        System.out.println("手机验证码：" + code.toString());
        if(user.getRegcode().equals(code.toString())){
            //验证码正确

            //执行密码MD5加密
            String temp = user.getPassword();
            String password = MD5Util.MD5Encode(temp, "UTF-8");
            user.setPassword(password);
            int i = userMapper.insertSelective(this.convert(user));
            if(i > 0){
                map.put("code","200");
                map.put("msg","注册成功！");
                //清空redis中的手机号验证码
                redisTemplate.delete(MSGPREFIX + user.getPhone());
            }else{
                map.put("code","500");
                map.put("msg","注册失败！");
            }
        }else{
            map.put("code","500");
            map.put("msg","验证码失效或不正确！");
        }
        return map;
    }

    private User convert(com.zm.fx_util_common.bean.User user){
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setId(user.getId());
        user1.setAddress(user.getAddress());
        user1.setEmail(user.getEmail());
        user1.setEmailispass(user.getEmailispass());
        user1.setPhone(user.getPhone());
        user1.setPhoneispass(user.getPhoneispass());
        user1.setRealname(user.getRealname());
        return user1;
    }

    //登录逻辑
    public Map<String,Object> loginByUser(com.zm.fx_util_common.bean.User user) {
        Map<String,Object> result = new HashMap<>();
        //加密密码
        String password = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
        Map<String, Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("password",password);
        List<User> users = userMapper.selectByMap(map);
        if(users.size()>0){
            User user1 = users.get(0);
            //置空密码
            user1.setPassword("密码你猜啊！");
            Long userid = user1.getId();
            //登录成功  把用户信息放Redis里面
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(USERPREFIX+userid,user1);
            redisTemplate.expire(USERPREFIX+userid,30,TimeUnit.MINUTES);    //30分钟失效
            result.put("code","200");
            result.put("msg","登陆成功!");
            result.put("user",user1);
        }else{
            result.put("code","500");
            result.put("msg","用户名或密码不正确!");
        }
        return result;
    }

}
