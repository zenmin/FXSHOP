package com.zm.fx_cms_provider.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_dao_common.bean.ContentCategory;
import com.zm.fx_dao_common.bean.IndexContent;
import com.zm.fx_dao_common.bean.IndexContentExample;
import com.zm.fx_dao_common.dao.ContentCategoryMapper;
import com.zm.fx_dao_common.dao.IndexContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Describle This Class Is 内容service
 * @Author ZengMin
 * @Date 2018/8/23 20:11
 */
@Service
@CacheConfig(cacheNames = "indexContent")
public class ContentService {

    @Autowired
    ContentCategoryMapper contentCategoryMapper;
    @Autowired
    IndexContentMapper indexContentMapper;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 查所有内容分类
     * @return
     */
    @Cacheable(cacheNames = "contentCates")
    public List<ContentCategory> getContentCates(){
        List<ContentCategory> contentCategories = contentCategoryMapper.selectByExample(null);
        return contentCategories;
    }

    /**
     * 取所有首页内容
     * @return
     */
    @Cacheable
    public Page getContents(){
        Page<IndexContent> page = new Page<>();
        List<IndexContent> indexContents = indexContentMapper.selectIndexAndCate(page,  new EntityWrapper<>());
        page.setRecords(indexContents);
        return page;
    }


    /**
     * 根据id取首页内容
     * @return
     */
    @Cacheable(key = "#id")
    public IndexContent getContentsById(Long id){
        return indexContentMapper.selectByPrimaryKey(id);
    }

    @CachePut(key = "#indexContent.id")
    public IndexContent addContent(IndexContent indexContent) {
        int i = indexContentMapper.insertSelective(indexContent);
        this.refreshIndexCache();
        return indexContent;
    }

    @CachePut(key = "#indexContent.id")
    public IndexContent updateContent(IndexContent indexContent) {
        int i = indexContentMapper.updateByPrimaryKey(indexContent);
        this.refreshIndexCache();
        return indexContent;
    }

    @CacheEvict(key = "#id")
    public Long deleteById(Long id) {
        int i = indexContentMapper.deleteByPrimaryKey(id);
        return id;
    }

    @Cacheable(cacheNames = "indexContentByParent" , key = "#pid")
    public List<IndexContent> getContentByPid(Long pid){
        IndexContentExample indexContentExample = new IndexContentExample();
        IndexContentExample.Criteria criteria = indexContentExample.createCriteria();
        criteria.andParentidEqualTo(pid);
        List<IndexContent> indexContents = indexContentMapper.selectByExample(indexContentExample);
        return indexContents;
    }

    @Async
    public void refreshIndexCache(){
        //刷新首页缓存
        redisTemplate.delete("indexContentByParent::2");
        redisTemplate.delete("indexContentByParent::13");
        this.getContentByPid(2L);
        this.getContentByPid(13L);
    }
}
