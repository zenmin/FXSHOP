package com.zm.fx_item_provider.service;

import com.zm.fx_dao_common.bean.Item;

import java.util.List;
import java.util.Map;

/**
 * @Describle This Class Is 商品接口
 * @Author ZengMin
 * @Date 2018/8/12 10:11
 */
public interface ItemService {
    public List<Item> findAll(Map<String, Object> params, String start, String size, String sort);
}
