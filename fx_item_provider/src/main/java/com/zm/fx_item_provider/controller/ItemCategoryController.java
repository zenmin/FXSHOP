package com.zm.fx_item_provider.controller;

import com.zm.fx_dao_common.bean.ItemCategory;
import com.zm.fx_item_provider.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Describle This Class Is 分类管理
 * @Author ZengMin
 * @Date 2018/8/18 14:48
 */
@RestController
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;

    /**
     * 查全部
     * @return
     */
    @GetMapping("/itemcate/findall")
    public List<ItemCategory> getAllCate(){
        List<ItemCategory> allCate = itemCategoryService.getAllCate();
        return allCate;
    }
    /**
     * 查父节点
     * @return
     */
    @GetMapping("/itemcate/findparent")
    public List<ItemCategory> getCateParent(){
        List<ItemCategory> allCate = itemCategoryService.getAllCateParent();
        return allCate;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/itemcate/findbyid/{id}")
    public ItemCategory getCateParent(@PathVariable Integer id){
        ItemCategory itemCategory = itemCategoryService.getAllCateById(id);
        return itemCategory;
    }

    /**
     * 根据父节点id查询
     * @param pid
     * @return
     */
    @GetMapping("/itemcate/findbypid/{pid}")
    public List<ItemCategory> getCateByPid(@PathVariable Long pid){
        List<ItemCategory> cates = itemCategoryService.getAllCateByPid(pid);
        return cates;
    }

}
