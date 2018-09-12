package com.zm.fx_search_provider.service;

import com.zm.fx_util_common.bean.Item;
import org.springframework.data.domain.Page;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/30 20:57
 */
public interface ItemSerchService {
    Page<Item> findAll(String q,int page,int size);
    Item findById(Long id);
    Item save(Item item);
    void delete(Integer id);
    void deleteAll();
    void updateIndex(String msg);
}
