package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.zm.fx_dao_common.bean.ItemDeatil;
import com.zm.fx_dao_common.bean.ItemDeatilExample;
import org.apache.ibatis.annotations.Param;

public interface ItemDeatilMapper extends BaseMapper<ItemDeatil> {
    long countByExample(ItemDeatilExample example);

    int deleteByExample(ItemDeatilExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(ItemDeatil record);

    int insertSelective(ItemDeatil record);

    List<ItemDeatil> selectByExampleWithBLOBs(ItemDeatilExample example);

    List<ItemDeatil> selectByExample(ItemDeatilExample example);

    ItemDeatil selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemDeatil record, @Param("example") ItemDeatilExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemDeatil record, @Param("example") ItemDeatilExample example);

    int updateByExample(@Param("record") ItemDeatil record, @Param("example") ItemDeatilExample example);

    int updateByPrimaryKeySelective(ItemDeatil record);

    int updateByPrimaryKeyWithBLOBs(ItemDeatil record);

    int updateByPrimaryKey(ItemDeatil record);
}