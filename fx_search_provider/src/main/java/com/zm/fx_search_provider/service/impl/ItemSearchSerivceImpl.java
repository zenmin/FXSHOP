package com.zm.fx_search_provider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_dao_common.bean.ItemDeatil;
import com.zm.fx_dao_common.dao.ItemDeatilMapper;
import com.zm.fx_dao_common.dao.ItemMapper;
import com.zm.fx_search_provider.dao.ItemRepo;
import com.zm.fx_search_provider.service.ItemSerchService;
import com.zm.fx_util_common.bean.Item;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Describle This Class Is ElasticSearch操作
 * @Author ZengMin
 * @Date 2018/8/30 20:57
 */
@Service
@CacheConfig(cacheNames = "ItemSearch")
public class ItemSearchSerivceImpl implements ItemSerchService {

    @Autowired
    ItemRepo itemRepo;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ItemDeatilMapper itemDeatilMapper;
    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    @Cacheable(unless = "#q == null")   //q!=null时在缓存
    public Page<Item> findAll(String q,int page, int size) {
        Page<Item> all = null;
        if(StringUtils.isEmpty(q) == false){
            //根据标题查询
            all = itemRepo.findByTiitle(q, q,new PageRequest(page, size));
        }else{
            all = itemRepo.findAll(new PageRequest(page, size));
        }
        return all;
    }

    /**
     * 根据id取
     * @param id
     * @return
     */
    @Override
    @Cacheable
    public Item findById(Long id) {
        Item one = itemRepo.findById(id);
        return one;
    }

    /**
     * 保存或更新
     * @param item
     * @return
     */
    @Override
    @CacheEvict(cacheNames = "ItemSearch")
    public Item save(Item item) {
        Item save = itemRepo.save(item);
        return save;
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        itemRepo.delete(id);
    }

    /**
     * 清空索引库
     */
    @Override
    @CacheEvict(cacheNames = "ItemSearch")
    public void deleteAll() {
        itemRepo.deleteAll();
    }

    /**
     * 更新索引库
     */
    @Override
    @CacheEvict(cacheNames = "ItemSearch")
    @RabbitListener(queues = "fxshop.index")
    public void updateIndex(String msg) {
        if(msg == null){
            throw new RuntimeException("消息体为空");
        }
        //刷新全部
        if(msg.equals("refreshIndex")){
            System.out.println("收到刷新全部索引库请求");
            List items = itemMapper.selectByExample(null);
            int num = 0;
            for (Object o : items){
                try{
                    com.zm.fx_dao_common.bean.Item temp = (com.zm.fx_dao_common.bean.Item) o;
                    ItemDeatil itemDeatil = new ItemDeatil();
                    itemDeatil.setItemid(temp.getId());
                    ItemDeatil it = itemDeatilMapper.selectOne(itemDeatil);
                    if(it != null){
                        temp.setDmsg(it.getBigmsg());
                    }
                    Item item = this.convertBean(temp);
                    Item save = itemRepo.save(item);
                    if(save != null){
                        num++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
            }
            System.out.println("更新 "+ num + " 条数据！");
        }else{
            try {
                com.zm.fx_dao_common.bean.Item item = JSONObject.parseObject(msg, com.zm.fx_dao_common.bean.Item.class);
                System.out.println("刷新单个索引库：" + item);
                Item item1 = this.convertBean(item);
                itemRepo.save(item1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private Item convertBean(com.zm.fx_dao_common.bean.Item temp){
        Item item = new Item();
        String id = temp.getId();
        item.setId(Long.valueOf(id));
        item.setStatus(temp.getStatus());
        item.setTiitle(temp.getTiitle());
        item.setPrice(temp.getPrice());
        item.setImgurl(temp.getImgurl());
        item.setName(temp.getName());
        String imgurl = temp.getImgurl();
        if(imgurl.startsWith(",")){
            imgurl = imgurl.substring(1,imgurl.length());
        }
        if(imgurl.endsWith(",")){
            imgurl = imgurl.substring(0,imgurl.length()-1);
        }
        item.setImgurl(imgurl);
        item.setDescrible(temp.getDescrible());
        item.setBarcode(temp.getBarcode());
        item.setUpdated(temp.getUpdated());
        item.setCategoryid(temp.getCategoryid());
        item.setCreated(temp.getCreated());
        item.setNum(temp.getNum());
        item.setDmsg(temp.getDmsg());
        return item;
    }

}
