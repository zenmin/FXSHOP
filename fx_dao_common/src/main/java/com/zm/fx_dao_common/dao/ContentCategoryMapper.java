package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.zm.fx_dao_common.bean.ContentCategory;
import com.zm.fx_dao_common.bean.ContentCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface ContentCategoryMapper extends BaseMapper<ContentCategory> {
    long countByExample(ContentCategoryExample example);

    int deleteByExample(ContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    List<ContentCategory> selectByExample(ContentCategoryExample example);

    ContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentCategory record, @Param("example") ContentCategoryExample example);

    int updateByExample(@Param("record") ContentCategory record, @Param("example") ContentCategoryExample example);

    int updateByPrimaryKeySelective(ContentCategory record);

    int updateByPrimaryKey(ContentCategory record);
}