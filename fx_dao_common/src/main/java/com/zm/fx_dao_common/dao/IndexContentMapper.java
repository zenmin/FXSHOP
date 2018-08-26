package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zm.fx_dao_common.bean.IndexContent;
import com.zm.fx_dao_common.bean.IndexContentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface IndexContentMapper extends BaseMapper<IndexContent> {
    long countByExample(IndexContentExample example);

    int deleteByExample(IndexContentExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(IndexContent record);

    int insertSelective(IndexContent record);

    List<IndexContent> selectByExample(IndexContentExample example);

    IndexContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IndexContent record, @Param("example") IndexContentExample example);

    int updateByExample(@Param("record") IndexContent record, @Param("example") IndexContentExample example);

    int updateByPrimaryKeySelective(IndexContent record);

    int updateByPrimaryKey(IndexContent record);

    List<IndexContent> selectIndexAndCate(RowBounds rowBounds, @Param("ew") Wrapper<?> wrapper);
}