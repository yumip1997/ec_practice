package com.himart.backend.order.dao;

import com.himart.backend.order.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    void insertOrderData(OrderDto orderDto);
}
