package com.zm.fx_search_provider.controller;

import com.zm.fx_search_provider.service.ItemSerchService;
import com.zm.fx_util_common.bean.Item;
import com.zm.fx_util_common.bean.SearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static com.zm.fx_util_common.bean.SearchEntity.convertObj;

/**
 * @Describle This Class Is 商品搜索
 * @Author ZengMin
 * @Date 2018/8/30 20:56
 */
@RestController
public class ItemSearchController {

    @Autowired
    ItemSerchService itemSerchService;

    @GetMapping("/search")
    public SearchEntity findAll(@RequestParam(value = "q",required = false,defaultValue = "") String q
                                ,@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                              @RequestParam(value = "size",required = false,defaultValue = "10") int size) {
        Page<Item> all = itemSerchService.findAll(q,page,size);
        SearchEntity searchEntity = convertObj(all);    //包装page
        return searchEntity;
    }
    /**
     * 根据id取
     * @param id
     * @return
     */
    @GetMapping("/search/byid/{id}")
    public Item findById(@PathVariable Integer id) {
        Item one = itemSerchService.findById(id);
        return one;
    }

    /**
     * 保存或更新
     * @param item
     * @return
     */
    @PostMapping("/search")
    public Item save(@RequestBody Item item) {
        Item save = itemSerchService.save(item);
        return save;
    }

    /**
     * 根据id删除
     * @param id
     */
    @DeleteMapping("/search/{id}")
    public void delete(@PathVariable Integer id) {
        itemSerchService.delete(id);
    }

    /**
     * 清空索引库
     */
    @DeleteMapping("/search/clear")
    public void deleteAll() {
        itemSerchService.deleteAll();
    }

}
