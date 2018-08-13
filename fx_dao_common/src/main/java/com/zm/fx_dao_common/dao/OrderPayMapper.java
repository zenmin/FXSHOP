package com.zm.fx_dao_common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.zm.fx_dao_common.bean.OrderPay;
import com.zm.fx_dao_common.bean.OrderPayExample;
import org.apache.ibatis.annotations.Param;

public interface OrderPayMapper extends BaseMapper<OrderPay> {
    long countByExample(OrderPayExample example);

    int deleteByExample(OrderPayExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(OrderPay record);

    int insertSelective(OrderPay record);

    List<OrderPay> selectByExample(OrderPayExample example);

    OrderPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderPay record, @Param("example") OrderPayExample example);

    int updateByExample(@Param("record") OrderPay record, @Param("example") OrderPayExample example);

    int updateByPrimaryKeySelective(OrderPay record);

    int updateByPrimaryKey(OrderPay record);
}