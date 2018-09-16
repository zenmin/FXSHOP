package com.zm.fx_sso_provider;

import com.zm.fx_dao_common.bean.User;
import com.zm.fx_dao_common.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxSsoProviderApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("username","zm");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

}
