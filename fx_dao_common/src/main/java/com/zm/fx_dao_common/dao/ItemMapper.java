package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zm.fx_dao_common.bean.Item;
import com.zm.fx_dao_common.bean.ItemExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ItemMapper extends BaseMapper<Item> {
    long countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(String id);

    Integer insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> findAllandCategory(ItemExample itemExample);

    //查询全部
    List<Item> selectMyPage(RowBounds rowBounds, @Param("ew") Wrapper<?> wrapper);
    //根据id查商品详情
    Item selectMyPageByid(@Param("id") String id);
}