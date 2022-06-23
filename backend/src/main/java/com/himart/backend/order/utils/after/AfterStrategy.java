package com.himart.backend.order.utils.after;

import com.himart.backend.order.code.SystemType;
import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderRequest;

public interface AfterStrategy {

    void call(OrderRequest orderRequest, OrderDto orderDto);

    SystemType getType();

}
