package com.zm.fx_item_provider;

import com.zm.fx_dao_common.dao.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxItemProviderApplicationTests {

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    CacheManager cacheManager;

    @Test
    public void contextLoads() {
//        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","zm");
//        valueOperations.set("map",map);
        Class<? extends CacheManager> aClass = cacheManager.getClass();
        System.out.println(aClass);
    }


}
