package com.zm.fx_item_provider.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_dao_common.bean.Item;

import java.util.Map;

/**
 * @Describle This Class Is 商品接口
 * @Author ZengMin
 * @Date 2018/8/12 10:11
 */
public interface ItemService {
    public Page findAll(Map<String, Object> params, String start, String size, String sort);
    public Item findById(String id);
    public int updateItem(Item item);
    public int deleteById(String id);
    public int add(Item item);
}
