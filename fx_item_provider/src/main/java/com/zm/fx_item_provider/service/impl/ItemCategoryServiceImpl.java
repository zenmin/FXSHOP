package com.zm.fx_item_provider.service.impl;

import com.zm.fx_dao_common.bean.ItemCategory;
import com.zm.fx_dao_common.bean.ItemCategoryExample;
import com.zm.fx_dao_common.dao.ItemCategoryMapper;
import com.zm.fx_item_provider.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Describle This Class Is 分类管理
 * @Author ZengMin
 * @Date 2018/8/18 14:48
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    ItemCategoryMapper itemCategoryMapper;

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<ItemCategory> getAllCate() {
        List<ItemCategory> itemCategories = itemCategoryMapper.selectByExample(null);
        return itemCategories;
    }

    /**
     * 查父节点
     *
     * @return
     */
    @Override
    public List<ItemCategory> getAllCateParent() {
        ItemCategoryExample itemCategoryExample = new ItemCategoryExample();
        ItemCategoryExample.Criteria criteria = itemCategoryExample.createCriteria();
        criteria.andParentidEqualTo(0L);
        List<ItemCategory> itemCategories = itemCategoryMapper.selectByExample(itemCategoryExample);
        return itemCategories;
    }

    /**
     * 根据id获取分类
     *
     * @return
     */
    @Override
    public ItemCategory getAllCateById(Integer id) {
        return itemCategoryMapper.selectById(id);
    }

    /**
     * 根据父节点查子节点
     *
     * @param id
     * @return
     */
    @Override
    public List<ItemCategory> getAllCateByPid(Long id) {
        ItemCategoryExample itemCategoryExample = new ItemCategoryExample();
        ItemCategoryExample.Criteria criteria = itemCategoryExample.createCriteria();
        criteria.andParentidEqualTo(id);
        List<ItemCategory> itemCategories = itemCategoryMapper.selectByExample(itemCategoryExample);
        return itemCategories;
    }
}