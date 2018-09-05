package com.zm.fx_search_provider;

import com.zm.fx_dao_common.dao.ItemMapper;
import com.zm.fx_search_provider.config.AMQPConfig;
import com.zm.fx_search_provider.dao.ItemRepo;
import com.zm.fx_util_common.bean.Item;
import org.apache.commons.collections.IteratorUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxSearchProviderApplicationTests {

    @Autowired
    ItemRepo itemRepo;
    @Autowired
    AMQPConfig amqpConfig;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        Item item = new Item();
        item.setId(1234567L);
        item.setUpdated("2019-10-10 00:00:00");
        item.setCategoryid(1L);
        item.setCreated("2019-10-10 00:00:00");
        item.setBarcode("12345677");
        item.setDescrible("描述描述");
        item.setName("商品 2");
        item.setImgurl("http://baidu.com");
        item.setPrice(12.12);
        item.setTiitle("标题标题1");
        item.setStatus(1);
        itemRepo.save(item);

    }

    /**
     * 分页查询
     * 返回的是一个迭代器
     */
    @Test
    public void search(){
        Page<Item> all = itemRepo.findAll(new PageRequest(0, 10));
        Iterator<Item> iterator = all.iterator();
        System.out.println(IteratorUtils.toList(iterator));
        System.out.println("总页码：" + all.getTotalPages());
        System.out.println(all.getSize());
        System.out.println(all.getNumber());
        System.out.println(all.getTotalElements());
    }


    @Test
    public void search1(){
        Page<Item> page = itemRepo.findByTiitleLikeAndDescribleLike("OPPO", "OPPO",new PageRequest(0, 10));
        System.out.println(page.getContent());
    }

    @Test
    public void searchById(){
        Item one = itemRepo.findOne(123456);
    }

    @Autowired
    ItemMapper itemMapper;

    @Test
    public void testAMQPAdmin(){
        List<com.zm.fx_dao_common.bean.Item> items = itemMapper.selectByExample(null);
        System.out.println(items);
//        rabbitTemplate.convertAndSend("fxshop.exchange","fxshop.refreshIndex","refreshIndex");
    }

}
