package com.zm.fx_item_provider;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_dao_common.dao.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxItemProviderApplicationTests {

    @Autowired
    ItemMapper itemMapper;

    @Test
    public void contextLoads() {
        double key = Math.random()*1000000+System.currentTimeMillis();
        System.out.println(key);
    }

}
