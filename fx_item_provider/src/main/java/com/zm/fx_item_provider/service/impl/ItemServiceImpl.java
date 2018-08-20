package com.zm.fx_item_provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_dao_common.bean.ItemDeatil;
import com.zm.fx_dao_common.dao.ItemCategoryMapper;
import com.zm.fx_dao_common.dao.ItemDeatilMapper;
import com.zm.fx_dao_common.dao.ItemMapper;
import com.zm.fx_item_provider.service.ItemService;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/12 10:11
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ItemDeatilMapper itemDeatilMapper;

    //查全部
    @Override
    public Page<Item> findAll(Map<String,Object> params, String start, String size, String sort) {
        if(StringUtils.isEmpty(start)){
            start = "1";
        }
        if(StringUtils.isEmpty(size)){
            size = "10";
        }
        Page<Item> page = new Page<Item>(Integer.parseInt(start),Integer.parseInt(size)); //分页类
        EntityWrapper entityWrapper = new EntityWrapper();  //查询参数
        List list = itemMapper.selectMyPage(page, entityWrapper);
        page.setRecords(list);
        return page;
    }

    //查询
    @Override
    public Item findById(String id) {
        return itemMapper.selectMyPageByid(id);
    }

    //更新
    @Override
    @Transactional
    public int updateItem(Item item) {
        Integer update = itemMapper.updateByPrimaryKeySelective(item);
        ItemDeatil itemDeatil = new ItemDeatil();
        itemDeatil.setUpdated(new Date());
        itemDeatil.setBigmsg(item.getDmsg());
        itemDeatilMapper.update(itemDeatil,new EntityWrapper<ItemDeatil>().eq("itemid",item.getId()));
        return update;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(String id) {
        int i = itemMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 新增商品
     * @param item
     * @return
     */
    @Override
    @Transactional
    public int add(Item item) {
        item.setId(String.valueOf(System.currentTimeMillis()));
        Integer insert = itemMapper.insertSelective(item);
        ItemDeatil itemDeatil = new ItemDeatil();
        itemDeatil.setBigmsg(item.getDmsg());
        itemDeatil.setItemid(item.getId());
        itemDeatil.setUpdated(new Date());
        itemDeatil.setCreated(new Date());
        itemDeatilMapper.insert(itemDeatil);
        return insert;
    }

}
