package com.zm.fx_dao_common;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_dao_common.bean.Admin;
import com.zm.fx_dao_common.bean.IndexContent;
import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_dao_common.dao.AdminMapper;
import com.zm.fx_dao_common.dao.IndexContentMapper;
import com.zm.fx_dao_common.dao.ItemCategoryMapper;
import com.zm.fx_dao_common.dao.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FxDaoCommonApplicationTests {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ItemCategoryMapper itemCategoryMapper;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    IndexContentMapper indexContentMapper;
    /**
     * 模糊查询
     */
    @Test
    public void sleect1() {
        List<Admin> admins = adminMapper.selectList(
                new EntityWrapper<Admin>().like("username","a")
        );
        System.out.println(admins);
    }
    /**
     * 分页查询
     */
    @Test
    public void sleect2() {
//        Page<ItemCategory> itemCategoryPage = new Page<>(1, 10);
//        List<ItemCategory> itemCategories = itemCategoryMapper.selectPage(itemCategoryPage
//                ,new EntityWrapper<>()
//        );
//        itemCategoryPage.setRecords(itemCategories);
        Page<Item> itemCategoryPage = new Page<>(1, 10);
        List<Item> itemCategories = itemMapper.selectPage(itemCategoryPage
         ,new EntityWrapper<>()
        );
        itemCategoryPage.setRecords(itemCategories);
        System.out.println(itemCategoryPage);
    }

    @Test
    public void sleect3() {
        Page<Item> page = new Page<>(1,1); //分页类
        EntityWrapper entityWrapper = new EntityWrapper();  //查询参数
        List list = itemMapper.selectMyPage(page, entityWrapper);
        page.setRecords(list).toString();
        System.out.println(page.getRecords());
    }

    @Test
    public void sleect4() {
        IndexContent indexContent = indexContentMapper.selectByPrimaryKey(12314L);
        System.out.println(indexContent);
    }

    /**
     * 新增
     */
    @Test
    public void insert1() {
        Admin admin = new Admin();
        admin.setCreated(new Date());
        admin.setPassword("345");
        admin.setRole("我问问");
        admin.setUsername("zm1");
        admin.setUpdated(new Date());
        Integer insert = adminMapper.insert(admin);
        System.out.println(insert);
    }

    /**
     * 新增
     */
    @Test
    public void insert2() {

        for (int i=0;i<100;i++) {
            Item item = new Item();
            item.setBarcode("12345678");
            item.setCategoryid(Long.valueOf(10));
            item.setDescrible("描述");
            item.setName("商品2");
            item.setNum(100);
            item.setPrice(12.32);
            item.setStatus(1);
            item.setTiitle("商品标题");
            item.setUpdated("2018-01-01");
            item.setCreated("2018-01-01");
            Integer insert = itemMapper.insert(item);
            System.out.println(insert);
        }
    }

    @Test
    public void del(){
        int i = itemMapper.deleteByPrimaryKey("1028875515693408257");
        System.out.println(i);
    }
}
