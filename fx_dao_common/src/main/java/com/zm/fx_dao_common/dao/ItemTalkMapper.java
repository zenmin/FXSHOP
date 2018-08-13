package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.zm.fx_dao_common.bean.ItemTalk;
import com.zm.fx_dao_common.bean.ItemTalkExample;
import org.apache.ibatis.annotations.Param;

public interface ItemTalkMapper extends BaseMapper<ItemTalk> {
    long countByExample(ItemTalkExample example);

    int deleteByExample(ItemTalkExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(ItemTalk record);

    int insertSelective(ItemTalk record);

    List<ItemTalk> selectByExample(ItemTalkExample example);

    ItemTalk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemTalk record, @Param("example") ItemTalkExample example);

    int updateByExample(@Param("record") ItemTalk record, @Param("example") ItemTalkExample example);

    int updateByPrimaryKeySelective(ItemTalk record);

    int updateByPrimaryKey(ItemTalk record);
}