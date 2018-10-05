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
    Page findAll(Map<String, Object> params, String start, String size, String sort);
    Item findById(String id);
    int updateItem(Item item);
    int deleteById(String id);
    int add(Item item);
    Item findByIdSimple(Long id);
}
