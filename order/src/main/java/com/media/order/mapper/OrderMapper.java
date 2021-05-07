package com.media.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.media.order.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {

    public Integer createOrder(@Param("order") Order order);
}
