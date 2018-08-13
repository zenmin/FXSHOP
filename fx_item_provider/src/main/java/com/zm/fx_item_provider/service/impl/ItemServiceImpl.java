package com.zm.fx_item_provider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_dao_common.dao.ItemMapper;
import com.zm.fx_item_provider.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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


    @Override
    public List<Item> findAll(Map<String,Object> params, String start, String size, String sort) {
        if(StringUtils.isEmpty(start)){
            start = "0";
        }
        if(StringUtils.isEmpty(size)){
            size = "10";
        }
        List list = itemMapper.selectPage(
                new Page<Item>(Integer.parseInt(start), Integer.parseInt(size)),
                new EntityWrapper()
        );
        return list;
    }
}
