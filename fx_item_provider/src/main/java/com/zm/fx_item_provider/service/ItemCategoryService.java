package com.zm.fx_item_provider.service;

import com.zm.fx_dao_common.bean.ItemCategory;

import java.util.List;

/**
 * @Describle This Class Is 分类接口
 * @Author ZengMin
 * @Date 2018/8/18 14:48
 */
public interface ItemCategoryService {
    public List<ItemCategory> getAllCate();

    public List<ItemCategory> getAllCateParent();

    public ItemCategory getAllCateById(Integer id);

    public List<ItemCategory> getAllCateByPid(Long id);


}
