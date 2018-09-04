package com.zm.fx_search_provider.dao;

import com.zm.fx_util_common.bean.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/8/29 20:33
 */
public interface ItemRepo extends ElasticsearchRepository<Item,Integer> {
}
