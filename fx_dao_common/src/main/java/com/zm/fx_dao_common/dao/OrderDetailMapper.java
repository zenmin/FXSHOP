package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.zm.fx_dao_common.bean.OrderDetail;
import com.zm.fx_dao_common.bean.OrderDetailExample;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}