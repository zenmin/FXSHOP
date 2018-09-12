package com.zm.fx_search_provider.dao;

import com.zm.fx_util_common.bean.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/29 20:33
 */
public interface ItemRepo extends ElasticsearchRepository<Item,Integer> {
    Page<Item> findByTiitle(String tiitle,String name,Pageable pageable);
    Item findById(Long id);
}
