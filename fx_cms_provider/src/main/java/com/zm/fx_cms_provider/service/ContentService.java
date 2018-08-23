package com.zm.fx_cms_provider.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zm.fx_dao_common.bean.ContentCategory;
import com.zm.fx_dao_common.bean.IndexContent;
import com.zm.fx_dao_common.dao.ContentCategoryMapper;
import com.zm.fx_dao_common.dao.IndexContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Describle This Class Is 内容service
 * @Author ZengMin
 * @Date 2018/8/23 20:11
 */
@Service
public class ContentService {

    @Autowired
    ContentCategoryMapper contentCategoryMapper;
    @Autowired
    IndexContentMapper indexContentMapper;

    /**
     * 查所有内容分类
     * @return
     */
    public List<ContentCategory> getContentCates(){
        List<ContentCategory> contentCategories = contentCategoryMapper.selectByExample(null);
        return contentCategories;
    }

    /**
     * 取所有首页内容
     * @return
     */
    public Page getContents(){
        Page<IndexContent> page = new Page<>();
        List<IndexContent> indexContents = indexContentMapper.selectPage(page,  new EntityWrapper<>());
        page.setRecords(indexContents);
        return page;
    }


    /**
     * 根据id取所有首页内容
     * @return
     */
    public IndexContent getContentsById(Long id){
        return indexContentMapper.selectByPrimaryKey(id);
    }


    public int addContent(IndexContent indexContent) {
        return indexContentMapper.insertSelective(indexContent);
    }

    public int updateContent(IndexContent indexContent) {
        return indexContentMapper.updateByPrimaryKey(indexContent);
    }

    public int deleteById(Long id) {
        return indexContentMapper.deleteById(id);
    }
}
